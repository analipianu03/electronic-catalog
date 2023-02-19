import java.util.ArrayList;

public class Assistant extends User implements  Element{
    public Assistant(String firstName, String lastName) {
        super(firstName, lastName);

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return false;
    }


    /**
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
