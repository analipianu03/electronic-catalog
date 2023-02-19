import java.util.ArrayList;

public class Teacher extends User implements Element{

    public Teacher(String firstName, String lastName) {
        super(firstName, lastName);
    }

    /**
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
