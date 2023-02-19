import java.util.*;

public abstract class Course {
    private String name;
    private Teacher teacher;
    private HashSet<Assistant> assistants = new HashSet<Assistant>();
    private TreeSet<Grade> grades = new TreeSet<Grade>();
    private HashMap<String, Group> groups = new HashMap<String, Group>();
    private int credits;

    public Course(String name, Teacher teacher, HashSet<Assistant> assistants, TreeSet<Grade> grades, HashMap<String, Group> groups, int credits) {
        this.name = name;
        this.teacher = teacher;
        this.assistants = assistants;
        this.grades = grades;
        this.groups = groups;
        this.credits = credits;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public HashMap<String, Group> getGroups() {
        return groups;
    }

    public void setGroups(HashMap<String, Group> groups) {
        this.groups = groups;
    }

    public HashSet<Assistant> getAssistants() {
        return assistants;
    }

    public void setAssistants(HashSet<Assistant> assistants) {
        this.assistants = assistants;
    }

    public TreeSet<Grade> getGrades() {
        return grades;
    }

    public void setGrades(TreeSet<Grade> grades) {
        this.grades = grades;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return credits == course.credits && Objects.equals(name, course.name) && Objects.equals(teacher, course.teacher) && Objects.equals(assistants, course.assistants) && Objects.equals(grades, course.grades) && Objects.equals(groups, course.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, teacher, assistants, grades, groups, credits);
    }

    @Override
    public String toString() {
        return "Coursename:'" + name + '\'' +
                "\nteacher: " + teacher +
                "\nassistants:" + assistants +
                "\ngrades:" + grades +
                "\ngroups:" + groups +
                "\ncredits: " + credits+ "\n";
    }



    public void addAssistant(String ID, Assistant assistant) {
        if (groups.containsKey(ID))
            groups.get(ID).setAssistant(assistant);
        if (!assistants.contains(assistant))
            assistants.add(assistant);
    }

    public void addStudent(String ID, Student student) {
        if (groups.containsKey(ID))
            groups.get(ID).addStudent(student);
    }


    public void addGroup(Group group) {
        groups.putIfAbsent(group.ID, group);
    }

    public void addGroup(String ID, Assistant assistant) {
        if (!groups.containsKey(ID)) {
            groups.put(ID, new Group(ID, assistant));
        }
    }

    public void addGroup(String ID, Assistant assistant, Comparator<Student> comp) {
        if (!groups.containsKey(ID)) {
            groups.put(ID, new Group(ID, assistant, comp));
        }
    }

    public Grade getGrade(Student student) {
        for (Grade g : grades)
            if (g.getStudent().firstName.equals(student.firstName) && g.getStudent().lastName.equals(student.lastName))
                return g;
        return null;
    }

    public void addGrade(Grade grade) {
        if(grades.isEmpty())
            grades= new TreeSet<>();
        if (!grades.contains(grade))
            grades.add(grade);
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        for (Grade g : grades)
            if (!students.contains(g.getStudent()))
                students.add(g.getStudent());
        return students;
    }

    public HashMap<Student, Grade> getAllStudentGrades() {
        HashMap<Student, Grade> allStudentGrades = new HashMap<Student, Grade>();
        for (Grade g : grades) {
            if(!allStudentGrades.containsValue(g))
            allStudentGrades.put(g.getStudent(), g);
        }
        return allStudentGrades;
    }

    Course(CourseBuilder builder)
    {
        this.name=builder.name;
        this.teacher=builder.teacher;
        this.credits= builder.credits;
        this.groups=builder.groups;
        this.assistants=builder.assistants;
    }

    abstract static class CourseBuilder {
        private String name;
        private Teacher teacher;
        private HashSet<Assistant> assistants = new HashSet<Assistant>();
        private TreeSet<Grade> grades = new TreeSet<Grade>();
        private HashMap<String, Group> groups = new HashMap<String, Group>();
        private int credits;

        public CourseBuilder() {

        }
        public CourseBuilder setName(String name)
        {
            this.name=name;
            return this;
        }

        public CourseBuilder setTeacher(Teacher teacher)
        {
            this.teacher=teacher;
            return this;
        }

        public CourseBuilder setCredit( int credits)
        {
            this.credits=credits;
            return this;
        }


        public Course build()
        {
            return null;
        }

    }

    public static class PartialCourseBuilder extends Course.CourseBuilder {
        public PartialCourseBuilder() {
            super();
        }

        public Course build() {
            return new PartialCourse(this);
        }

    }

    public static class FullCourseBuilder extends Course.CourseBuilder {
        public FullCourseBuilder() {
            super();
        }

        public Course build() {
            return new FullCourse(this);
        }

    }

    private BestStudentStrategy strategy;

    public void setBestStudentStrategy(BestStudentStrategy strategy) {
        this.strategy = strategy;
    }

    public Student getBestStudent() {
        return this.strategy.getBestStudent(this);
    }



    private class Snapshot {
        private TreeSet<Grade> gradesBackup;
        public Snapshot() {
            this.gradesBackup = new TreeSet<Grade>();
        }

    }
        private Snapshot backup= new Snapshot();

        public void makeBackup() throws CloneNotSupportedException{
            Snapshot aux = new Snapshot();
            for (Grade grade: grades)
                aux.gradesBackup.add((Grade) grade.clone());
            backup=aux;
        }

        public void undo() {
                grades = backup.gradesBackup;
        }

        public void upgradeGrade(Grade oldGrade, Grade newGrade) {
            if (newGrade.getPartialScore().equals(0.0))
                oldGrade.setExamScore(newGrade.getExamScore());
            if (newGrade.getExamScore().equals(0.0))
                oldGrade.setPartialScore(newGrade.getPartialScore());
            if (((newGrade.getPartialScore()* newGrade.getExamScore()) !=0.0)) {
                grades.remove(oldGrade);
                grades.add(newGrade);
            }
        }



    }
