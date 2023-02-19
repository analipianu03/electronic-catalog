import java.util.ArrayList;
import java.util.HashMap;

public interface Visitor {
    void visit(Assistant assistant);
    void visit(Teacher teacher);
    public HashMap<Assistant, ArrayList<ScoreVisitor.Tuple<Student, String, Double>>> getPartialScores();
    public HashMap<Teacher, ArrayList<ScoreVisitor.Tuple<Student, String, Double>>> getExamScores();

}
