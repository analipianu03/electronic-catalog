public class Student extends User{
    private Parent mother, father;
    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Student(String firstName, String lastName, Parent mother, Parent father) {
        super(firstName, lastName);
        this.mother=mother;
        this.father=father;
    }

    public String getFirstName()
    {
        return firstName;
    }
    public String getLastName()
    {
        return lastName;
    }


    public void setMother(Parent mother) {
        this.mother = mother;
    }

    public void setFather(Parent father) {
        this.father = father;
    }

    public Parent getMother() {
        return this.mother;
    }

    public Parent getFather() {
        return this.father;
    }

    //ordonare alfabetica dupa nume apoi dupa prenume
    public int compareTo(Student o1) {
        if(o1.lastName.compareTo(this.lastName)!=0)
            return o1.lastName.compareTo(this.lastName);
        else
            return o1.firstName.compareTo(this.firstName);
    }




}
