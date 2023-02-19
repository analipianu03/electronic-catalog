import java.util.*;

public class PartialCourse extends Course{

    public PartialCourse(PartialCourseBuilder builder) {
        super(builder);
    }

    public  ArrayList<Student> getGraduatedS()
    {
        ArrayList<Student> students= new ArrayList<Student>();
        for (Grade g : super.getGrades())
            if(g.getTotalScore()>=5&&!students.contains(g.getStudent()))
                students.add((Student) g.getStudent());
        return students;
    }


}
