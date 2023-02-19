import java.util.Objects;

public class Grade  implements Comparable,Cloneable{
    private Double partialScore, examScore;
    private Student student;
    private String course;

    public Grade(Double partialScore, Double examScore, Student student, String course)
    {
        this.partialScore=partialScore;
        this.examScore=examScore;
        this.student=student;
        this.course=course;
    }

    @Override
    public String toString() {
        return "\n"+ student+
                "\npartialScore:" + partialScore +
                "\nexamScore:" + examScore + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return Objects.equals(partialScore, grade.partialScore) && Objects.equals(examScore, grade.examScore) && Objects.equals(student, grade.student) && Objects.equals(course, grade.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partialScore, examScore, student, course);
    }

    public Double getExamScore() {
        return examScore;
    }

    public void setExamScore(Double examScore) {
        this.examScore = examScore;
    }

    public Double getPartialScore() {
        return partialScore;
    }

    public void setPartialScore(Double partialScore) {
        this.partialScore = partialScore;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getTotalScore()
    {
        return examScore+partialScore;
    }

    public int compare(Grade o1, Grade o2)
    {
        return o2.compareTo(o1);
    }

    @Override
    public int compareTo(Object o) {
        Grade grade;
        grade = (Grade) o;
        if ((this.student.getFirstName()).equals(grade.student.getFirstName())) {
            if ((this.student.getLastName()).equals(grade.student.getLastName())) {
                if (this.getTotalScore().compareTo(getTotalScore()) == 0) {
                    return (this.course.compareTo(grade.course));
                } else {
                    return this.getTotalScore().compareTo(getTotalScore());
                }
            } else {
                return (this.student.getLastName()).compareTo(grade.student.getLastName());
            }
        } else return (this.student.getFirstName()).compareTo(grade.student.getFirstName());
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return  super.clone();
    }



}
