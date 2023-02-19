# electronic-catalog
## DESIGN PATTERN FACTORY
## **Student, Parent, Assistant, Teacher** CLASSES
All these classes inherit the User class, having only the name in the constructor.
The different default is Student which also has parents in a constructor for simplicity of implementation.

Class USER
Has a constructor for name and toString method.

Using UserFactory we can declare and initialize any user, by 
UserFactory user= UserFactory.factory("type", "firstname", "name");

## DESIGN PATTERN BUILDER
## **FullCourse and PartialCourse classes**

These classes inherit Course. 
Using Builder we can declare and initialize any course, by
FullCourse.FullCourseBuilder fb1 = new FullCourse.FullCourseBuilder() ;
and using builder we set all fields.


## DESIGN PATTERN OBSERVER

The Parents class implements Observer, and the Catalog class implements Subject.
We use Observer to notify the observers (the student's parents).

**The Notification class** keeps the student and their grade for a notification, so we can use these details in toString.


## DESIGN PATTERN STRATEGY
The Strategy interface is used to find the best students in each course.
The BestPartialScore, BestExamScore and BestTotalScore classes implement BestStudentStrategy.
Using the strategy set for each course the easiest way to find the student you are looking for.


## DESIGN PATTERN VISITOR
The Visitor interface has 2 visit functions, one for the teacher and one for the assistant.
The assistant can add partial grades and the teacher can add exam grades.

For the visit we used a tuple containing the student, the grade and the course (the name of the course is transformed into a Course variable by stringToCourse).
The methods addPartialScore and addExamScore of the class ScoreVisitor add the grades sent by the parameter in its "agenda", i.e. in the field of the HashMap corresponding to the list of the accredited person.
In visit we browse with a Tuple iterator the scores of the accredited person and add them to the catalog.
NotifyObservers in the Catalog sends notifications to the parents of the student who got the grade given by the parameter.



## DESIGN PATTERN REMINDER
Using the SnapSnapshot class we can keep a backup of the added notes useful in case of a human input error or in case of application crashes.


## GRAPHICAL INTERFACE

### TeacherPage/ AssistentPage

Each assistant/teacher has a list of courses and is interactive.
After selecting a course a new frame will open with the notes to be added. When the add button is pressed, the notes are put in the catalogue and removed from the list of notes.


### StudentPage

Each student has a list of courses they are enrolled in.
Selecting a course and pressing the details button will display various details about the student's participation in the course.

### ParentPage

Each parent has notifications for their child and can update them via the update button.
