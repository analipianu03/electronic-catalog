import java.util.ArrayList;
import java.util.HashMap;

public class ScoreVisitor implements Visitor {
    private HashMap<Teacher, ArrayList<Tuple<Student, String, Double>>> examScores;
    private HashMap<Assistant, ArrayList<Tuple<Student, String, Double>>> partialScores;


    public ScoreVisitor() {
        this.examScores = new HashMap<>();
        this.partialScores = new HashMap<>();
    }

    public void addPartialScores(Grade grade, Assistant assistant)
    {
        Tuple<Student,String,Double> triplet= new Tuple<>(grade.getStudent(),grade.getCourse(),grade.getPartialScore());
        if(partialScores.containsKey(assistant))
        {
            ArrayList<Tuple<Student, String, Double>> partialGrades=partialScores.get(assistant);
            partialGrades.add(triplet);
            partialScores.put(assistant,partialGrades);
        }
        else
        {
            ArrayList<Tuple<Student, String, Double>> partialGrades = new ArrayList<Tuple<Student, String, Double>>();
            partialGrades.add(triplet);
            partialScores.put(assistant,partialGrades);
        }
    }


    public void visit(Assistant assistant) {
            for (Tuple<Student, String, Double> triplet : partialScores.get(assistant)) {
                Course course=Catalog.getInstance().stringToCatalog(triplet.getSecond());
                if (course.getName().equals(triplet.getSecond())) {
                    Grade grade = null;
                    if (course.getGrade(triplet.getFirst()) == null) {
                        grade = new Grade(triplet.getThird(), (double) 0, triplet.getFirst(), triplet.getSecond());
                        course.addGrade(grade);
                    } else {
                        course.getGrade(triplet.getFirst()).setPartialScore(triplet.getThird());
                    }
                }
            }

    }



    public void addExamScores(Grade grade,Teacher teacher)
    {
        Tuple<Student,String,Double> triplet= new Tuple<>(grade.getStudent(),grade.getCourse(),grade.getExamScore());
        if(examScores.containsKey(teacher))
        {
            ArrayList<Tuple<Student, String, Double>> examGrades=examScores.get(teacher);
            examGrades.add(triplet);
            examScores.put(teacher,examGrades);
        }
        else
        {
            ArrayList<Tuple<Student, String, Double>> examGrades = new ArrayList<Tuple<Student, String, Double>>();
            examGrades.add(triplet);
            examScores.put(teacher,examGrades);
        }
    }

    public void visit(Teacher teacher) {

            for( Tuple<Student,String,Double> triplet : examScores.get(teacher)) {
            Course course=Catalog.getInstance().stringToCatalog(triplet.getSecond());
            if (triplet.getSecond().equals(course.getName())) {
                Grade grade = null;
                if (course.getGrade(triplet.getFirst()) == null) {
                    grade = new Grade((double) 0, triplet.getThird(), triplet.getFirst(), triplet.getSecond());
                    course.addGrade(grade);
                } else {
                    course.getGrade(triplet.getFirst()).setExamScore(triplet.getThird());
                }

            }
        }

    }

    public HashMap<Assistant, ArrayList<Tuple<Student, String, Double>>> getPartialScores() {
        return partialScores;
    }

    public HashMap<Teacher, ArrayList<Tuple<Student, String, Double>>> getExamScores() {
        return examScores;
    }
    //dau notificare la tot catalogul
    public void sendNotifications() {

        for(Course course: Catalog.getInstance().getCourses())
        {
            for(Grade grade:course.getAllStudentGrades().values())
                 Catalog.getInstance().notifyObservers(grade);
        }
    }

    class Tuple<A, B, C> {
        private final A first;
        private final B second;
        private final C third;

        public Tuple(A first, B second, C third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }

        public C getThird() {
            return third;
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ", " + third + ")";
        }
    }
}
