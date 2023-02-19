import java.util.ArrayList;

public class Catalog implements Subject  {
        private static Catalog catalog;
        private ArrayList<Course> courses;
        Catalog()
        {
            this.courses=new ArrayList<Course>();
        }

        public static Catalog getInstance()
        {
            if(catalog==null)
                catalog=new Catalog();
            return catalog;
        }

        public void addCourse(Course course)
        {
            if(!courses.contains(course))
            Catalog.getInstance().courses.add(course);
        }

        public  ArrayList<Course> getCourses()
        {
            return courses;
        }

        public void removeCourse(Course course)
        {
            Catalog.getInstance().courses.remove(course);
        }

        private ArrayList<Observer> observers;

        public void addObserver(Observer observer)
        {
            if(!observers.contains(observer))
                observers.add( observer);
        }

        public void removeObserver(Observer observer)
        {
            if(observers.contains(observer))
                observers.remove( observer);
        }

        public Course stringToCatalog(String string)
        {
            for(Course course: Catalog.getInstance().getCourses())
                if(string.equals(course.getName()))
                    return course;
            return null;
        }

        public void notifyObservers(Grade grade)
        {
            if(grade.getStudent().getMother()!=null) {
                System.out.println("\n!!!!In atentia doamnei "+grade.getStudent().getMother());
                grade.getStudent().getMother().update(new Notification(grade, grade.getStudent()));
            }
            if(grade.getStudent().getFather()!=null) {
                System.out.println("\n!!!!In atentia domnului  "+grade.getStudent().getFather());
                grade.getStudent().getFather().update(new Notification(grade, grade.getStudent()));
            }
        }

    @Override
    public String toString() {
            return  catalog.courses.toString();
    }

}
