import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface BestStudentStrategy {
    Student getBestStudent(Course course);

    public class BestPartialScore implements BestStudentStrategy {
        public Student getBestStudent(Course course) {
            Student bestStudent = null;
            Double maxGrade= Double.valueOf(0);
            HashMap <Student, Grade> grades = course.getAllStudentGrades();

            for (Map.Entry<Student, Grade> entry : grades.entrySet())
            {
                if(entry.getValue().getPartialScore()>maxGrade)
                {
                    bestStudent=entry.getKey();
                    maxGrade=entry.getValue().getPartialScore();
                }
            }
            return bestStudent;
        }
    }

    public class BestExamScore implements BestStudentStrategy {
        public Student getBestStudent(Course course) {
            Student bestStudent = null;
            Double maxGrade= Double.valueOf(0);
            HashMap <Student, Grade> grades = course.getAllStudentGrades();
            for (Map.Entry<Student, Grade> entry : grades.entrySet())
            {
                if(entry.getValue().getExamScore()>maxGrade)
                {
                    bestStudent=entry.getKey();
                    maxGrade=entry.getValue().getExamScore();
                }
            }
            return bestStudent;
        }
    }

    public class BestTotalScore implements BestStudentStrategy {
        public Student getBestStudent(Course course) {
            Student bestStudent = null;
            Double maxGrade= Double.valueOf(0);
            HashMap <Student, Grade> grades = course.getAllStudentGrades();
            for (Map.Entry<Student, Grade> entry : grades.entrySet())
            {
                if(entry.getValue().getTotalScore()>maxGrade)
                {
                    bestStudent=entry.getKey();
                    maxGrade=entry.getValue().getTotalScore();
                }
            }
            return bestStudent;
        }
    }
}
