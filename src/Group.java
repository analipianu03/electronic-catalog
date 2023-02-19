import java.security.PublicKey;
import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class Group {
    String ID;
    Assistant assistant;
    TreeSet<Student> students;

    private Comparator<Student> comp=new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o2.compareTo(o1);
        }
    };

    public Group(String ID, Assistant assistant) {
        this.ID=ID;
        this.assistant=assistant;
        this.students= new TreeSet<Student>(comp) ;
    }

    public Group(String ID, Assistant assistant, Comparator<Student> comp) {
        this.ID=ID;
        this.assistant=assistant;
        this.students= new TreeSet<Student>(comp) ;
        this.comp=comp;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setComp(Comparator<Student> comp) {
        this.comp = comp;
    }

    public Comparator<Student> getComp() {
        return comp;
    }

    public void setStudents(TreeSet<Student> students) {
        this.students = students;
    }

    public TreeSet<Student> getStudents() {
        return students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(ID, group.ID) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, assistant, students, comp);
    }


    @Override
    public String toString() {
        return
                "\nassistant: " + assistant +
                "\n students: " + students +"\n";
    }

    public void addStudent(Student student)
    {
        students.add(student);
    }
}