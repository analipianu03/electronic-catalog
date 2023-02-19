import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Notification {
    Grade grade;
    Student student;
    ArrayList<Observer> observers ;
    public Notification(Grade grade,Student student)
    {
        this.grade=grade;
        this.student=student;
        observers = new ArrayList<Observer>();
    }
    @Override
    public String toString() {
        return
                "Va aducem la cunostinta ca elevul " + student +
                " a obtinut nota " + grade.getTotalScore() + " la cursul " + grade.getCourse() +"\n";
    }
}
