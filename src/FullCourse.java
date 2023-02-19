import java.util.ArrayList;


public class FullCourse extends Course{

    public FullCourse(FullCourseBuilder builder) {
        super(builder);
    }

    public ArrayList<Student> getGraduatedS()
        {
            ArrayList<Student> students= new ArrayList<Student>();
            for (Grade g : super.getGrades())
                if(g.getPartialScore()>=3&&g.getExamScore()>=2&&!students.contains(g.getStudent()))
                    students.add((Student) g.getStudent());
            return students;
        }


}
