public abstract class User {
    String firstName;
    String lastName;
    public User(String firstName, String lastName)
    {
        this.firstName=firstName;
        this.lastName=lastName;
    }


    public String toString()
    {
        return firstName+" "+lastName;
    }


}
