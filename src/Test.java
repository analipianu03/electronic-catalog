import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Test {
    public Test() throws CloneNotSupportedException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Catalog catalog= new Catalog();

        ///POO
        FullCourse.FullCourseBuilder fb1 = new FullCourse.FullCourseBuilder() ;
        Course curs= fb1.setName("Programare Orientata pe Obiecte").setCredit(3).setTeacher((Teacher)UserFactory.factory("Teacher","Ion","Mihalache")).build();

        ///grupa 312CC
        User student1= UserFactory.factory("Student","Gigel","Frone");
        ((Student)student1).setMother(((Parent)UserFactory.factory("Parent","Maria","Frone")));
        ((Student)student1).setFather((Parent)UserFactory.factory("Parent","Daniel","Frone"));

        User student2= UserFactory.factory("Student","Cosmin","Andrei");
        ((Student)student2).setFather((Parent)UserFactory.factory("Parent","Vasile","Andrei"));

        User student3= UserFactory.factory("Student","Ionel","Dragomir");
        ((Student)student3).setMother((Parent)UserFactory.factory("Parent","Letitia","Dragomir"));

        User student4= UserFactory.factory("Student","Florin","Florea");
        ((Student)student4).setMother((Parent)UserFactory.factory("Parent","Adriana","Florea"));
        ((Student)student4).setFather((Parent)UserFactory.factory("Parent","Catalin","Florea"));

        User student5= UserFactory.factory("Student","Costel","Busuioc");
        ((Student)student5).setFather((Parent)UserFactory.factory("Parent","Nelu","Busuioc"));
        ((Student)student5).setMother((Parent)UserFactory.factory("Parent","Carmen","Busuioc"));

        User a= (Assistant)UserFactory.factory("Assistant","Andrei","Georgescu");

        Group group1= new Group("312CC",(Assistant) a);
        curs.addGroup(group1);
        group1.addStudent((Student)student1);
        group1.addStudent((Student)student2);
        group1.addStudent((Student)student3);
        group1.addStudent((Student)student4);
        group1.addStudent((Student)student5);
        curs.addAssistant("312CC",(Assistant) a);
        curs.addStudent("312CC",(Student)student1);
        curs.addStudent("312CC",(Student)student2);
        curs.addStudent("312CC",(Student)student3);
        curs.addStudent("312CC",(Student)student4);
        curs.addStudent("312CC",(Student)student5);

        //grupa 314CC

        User assistant= (Assistant)UserFactory.factory("Assistant","Alexandra","Maria");

        User student6= UserFactory.factory("Student","Sebastian","Moisescu");
        ((Student)student6).setMother((Parent)UserFactory.factory("Parent","Viorela","Moisescu"));
        ((Student)student6).setFather((Parent)UserFactory.factory("Parent","Ionut","Moisescu"));

        User student7= UserFactory.factory("Student","Larisa","Oana");
        ((Student)student7).setFather((Parent)UserFactory.factory("Parent","Alecu","Oana"));

        User student8= UserFactory.factory("Student","Georgiana","Calin");
        ((Student)student8).setMother((Parent)UserFactory.factory("Parent","Lidia","Calin"));

        User student9= UserFactory.factory("Student","Dragos","Barbu");
        ((Student)student9).setMother((Parent)UserFactory.factory("Parent","Anastasia","Barbu"));
        ((Student)student9).setFather((Parent)UserFactory.factory("Parent","Lucian","Barbu"));

        User student10= UserFactory.factory("Student","Alberto","Ciobanu");
        ((Student)student10).setFather((Parent)UserFactory.factory("Parent","Emil","Ciobanu"));
        ((Student)student10).setMother((Parent)UserFactory.factory("Parent","Mihaela","Ciobanu"));

        Group group2= new Group("314CC",(Assistant) assistant);
        group2.addStudent((Student) student6);
        group2.addStudent((Student)student7);
        group2.addStudent((Student)student8);
        group2.addStudent((Student)student8);
        group2.addStudent((Student)student9);
        group2.addStudent((Student)student10);


        curs.addAssistant("314CC",(Assistant) assistant);

        curs.addGroup(group2);

        FullCourse.FullCourseBuilder fb2 = new FullCourse.FullCourseBuilder() ;

        Course curs2= fb2.setName("Paradigme de programare").setCredit(3).setTeacher((Teacher)UserFactory.factory("Teacher","Sonia","Lupu")).build();


        User assistant3= (Assistant)UserFactory.factory("Assistant","Florentina","Bratosin");
        Group group3= new Group("312CC",(Assistant) assistant3);
        group3.addStudent((Student) student1);
        group3.addStudent((Student) student2);
        group3.addStudent((Student) student3);
        group3.addStudent((Student) student4);
        group3.addStudent((Student) student5);

        curs2.addGroup(group3);
        curs2.addAssistant("312CC", (Assistant) assistant3);


        User assistant4= (Assistant)UserFactory.factory("Assistant","Horia","Ghita");
        Group group4= new Group("314CC", (Assistant) assistant4);
        group4.addStudent((Student) student6);
        group4.addStudent((Student) student7);
        group4.addStudent((Student) student8);
        group4.addStudent((Student) student8);
        group4.addStudent((Student) student9);
        group4.addStudent((Student) student10);
        curs2.addAssistant("314CC", (Assistant) assistant4);
        curs2.addGroup(group4);

        Course.PartialCourseBuilder partialCourseBuilder =  new Course.PartialCourseBuilder();

        Course curs3=partialCourseBuilder.setCredit(2).setTeacher((Teacher)UserFactory.factory("Teacher","George","Dinu")).setName("Electronica digitala").build();

        User assistant5= (Assistant)UserFactory.factory("Assistant","Emilian","Voinea");
        User assistant6= (Assistant)UserFactory.factory("Assistant","Adrian","Sava");


        curs3.addAssistant("311CC", (Assistant) assistant6);
        curs3.addAssistant("313CC", (Assistant) assistant5);

        //311CC
        User student11= UserFactory.factory("Student","Livia","Ursu");

        User student12= UserFactory.factory("Student","Alfred","Pop");
        ((Student)student12).setFather((Parent)UserFactory.factory("Parent","Albert","Pop"));

        User student13= UserFactory.factory("Student","Iulian","Iancu");
        ((Student)student13).setMother((Parent)UserFactory.factory("Parent","Elena","Iancu"));

        User student14= UserFactory.factory("Student","Sofia","Negoita");
        ((Student)student14).setMother((Parent)UserFactory.factory("Parent","Ana","Negoita"));
        ((Student)student14).setFather((Parent)UserFactory.factory("Parent","Marius","Negoita"));

        User student15= UserFactory.factory("Student","Alma","Dobrica");
        ((Student)student15).setMother((Parent)UserFactory.factory("Parent","Corina","Dobrica"));
        ((Student)student15).setFather((Parent)UserFactory.factory("Parent","Cristi","Dobrica"));

        Group group5= new Group("311CC", (Assistant) assistant6);

        group5.addStudent((Student) student11);
        group5.addStudent((Student) student12);
        group5.addStudent((Student) student13);
        group5.addStudent((Student) student14);
        group5.addStudent((Student) student15);
        curs3.addGroup(group5);


        User student16= UserFactory.factory("Student","Cristian","Manole");
        ((Student)student16).setMother((Parent)UserFactory.factory("Parent","Victoria","Manole"));
        ((Student)student16).setFather((Parent)UserFactory.factory("Parent","Andrei","Manole"));

        User student17= UserFactory.factory("Student","Denisa","Pavel");
        ((Student)student17).setFather((Parent)UserFactory.factory("Parent","Bogdan","Pavel"));

        User student18= UserFactory.factory("Student","Alex","Petrescu");
        ((Student)student18).setMother((Parent)UserFactory.factory("Parent","Monica","Petrescu"));

        User student19= UserFactory.factory("Student","Cosmin","Tomulescu");

        User student20= UserFactory.factory("Student","Camelia","Tunaru");
        ((Student)student20).setMother((Parent)UserFactory.factory("Parent","Petra","Tunaru"));
        ((Student)student20).setFather((Parent)UserFactory.factory("Parent","Cristian","Tunaru"));

        Group group6= new Group("313CC", (Assistant) assistant5);

        group6.addStudent((Student) student16);
        group6.addStudent((Student) student17);
        group6.addStudent((Student) student18);
        group6.addStudent((Student) student19);
        group6.addStudent((Student) student20);
        curs3.addGroup(group6);


        Course.PartialCourseBuilder partialCourseBuilder2 =  new Course.PartialCourseBuilder();

        Course curs4=partialCourseBuilder2.setCredit(2).setName("Sisteme de operare").setTeacher((Teacher)UserFactory.factory("Teacher","Razvan","Calinescu")).build();

        User assistant7= (Assistant)UserFactory.factory("Assistant","Alma","Toma");
        User assistant8= (Assistant)UserFactory.factory("Assistant","Cornel","Cosma");

        curs4.addAssistant("311CC", (Assistant) assistant7);
        curs4.addAssistant("313CC", (Assistant) assistant8);

        Group group7= new Group("311CC", (Assistant) assistant7);

        group7.addStudent((Student) student11);
        group7.addStudent((Student) student12);
        group7.addStudent((Student) student13);
        group7.addStudent((Student) student14);
        group7.addStudent((Student) student15);
        curs4.addGroup(group7);

        Group group8= new Group("313CC", (Assistant) assistant8);

        group8.addStudent((Student) student16);
        group8.addStudent((Student) student17);
        group8.addStudent((Student) student18);
        group8.addStudent((Student) student19);
        group8.addStudent((Student) student20);
        curs4.addGroup(group8);

        catalog.addCourse(curs);
        catalog.addCourse(curs2);
        catalog.addCourse(curs3);
        catalog.addCourse(curs4);

        ///NOTE

        ScoreVisitor visitor=new ScoreVisitor();
        //POO
        visitor.addExamScores(new Grade(3.40,2.35, (Student) student3,curs.getName()),curs.getTeacher());
        visitor.addPartialScores(new Grade(3.40,2.35, (Student) student3,curs.getName()), (Assistant) a);

        visitor.addExamScores(new Grade(2.75,1.20, (Student) student1,curs.getName()),curs.getTeacher());
        visitor.addPartialScores(new Grade(2.75,1.20, (Student) student1,curs.getName()), (Assistant) a);

        visitor.addExamScores(new Grade(3.50,1.60, (Student) student5,curs.getName()),curs.getTeacher());
        visitor.addPartialScores(new Grade(3.50,1.60, (Student) student5,curs.getName()),(Assistant) a);

        visitor.addExamScores(new Grade(4.85,4.10, (Student) student4,curs.getName()),curs.getTeacher());
        visitor.addPartialScores(new Grade(4.85,4.10, (Student) student4,curs.getName()),(Assistant) a);

        visitor.addExamScores(new Grade(2.35,2.35, (Student) student2,curs.getName()),curs.getTeacher());
        visitor.addPartialScores(new Grade(2.35,2.35, (Student) student2,curs.getName()),(Assistant) a);


        visitor.addExamScores(new Grade(2.15,0.85, (Student) student6,curs.getName()),curs.getTeacher());
        visitor.addPartialScores(new Grade(2.15,0.85, (Student) student6,curs.getName()), (Assistant) assistant);

        visitor.addExamScores(new Grade(0.40,1.50, (Student) student7,curs.getName()),curs.getTeacher());
        visitor.addPartialScores(new Grade(0.40,1.50, (Student) student7,curs.getName()), (Assistant) assistant);

        visitor.addExamScores(new Grade(3.65,3.75, (Student) student8,curs.getName()),curs.getTeacher());
        visitor.addPartialScores(new Grade(3.65,3.75, (Student) student8,curs.getName()), (Assistant) assistant);

        visitor.addExamScores(new Grade(4.90,5.00, (Student) student9,curs.getName()),curs.getTeacher());
        visitor.addPartialScores(new Grade(4.90,5.00, (Student) student9,curs.getName()), (Assistant) assistant);

        visitor.addExamScores(new Grade(2.10,3.25, (Student) student10,curs.getName()),curs.getTeacher());
        visitor.addPartialScores(new Grade(2.10,3.25, (Student) student10,curs.getName()), (Assistant) assistant);

        //PP
        visitor.addExamScores(new Grade(4.35,1.15, (Student) student3,curs2.getName()),curs2.getTeacher());
        visitor.addPartialScores(new Grade(4.35,1.15, (Student) student3,curs2.getName()), (Assistant) assistant3);

        visitor.addExamScores(new Grade(1.25,3.70, (Student) student1,curs2.getName()),curs2.getTeacher());
        visitor.addPartialScores(new Grade(1.25,3.70, (Student) student1,curs2.getName()),(Assistant) assistant3);

        visitor.addExamScores(new Grade(4.65,4.00, (Student) student5,curs2.getName()),curs2.getTeacher());
        visitor.addPartialScores(new Grade(4.65,4.00, (Student) student5,curs2.getName()),(Assistant) assistant3);

        visitor.addExamScores(new Grade(2.10,2.35, (Student) student4,curs2.getName()),curs2.getTeacher());
        visitor.addPartialScores(new Grade(2.10,2.35, (Student) student4,curs2.getName()),(Assistant) assistant3);

        visitor.addExamScores(new Grade(3.40,2.90, (Student) student2,curs2.getName()),curs2.getTeacher());
        visitor.addPartialScores(new Grade(3.40,2.90, (Student) student2,curs2.getName()),(Assistant) assistant3);

        visitor.addExamScores(new Grade(0.70,1.75, (Student) student6,curs2.getName()),curs2.getTeacher());
        visitor.addPartialScores(new Grade(0.70,1.75, (Student) student6,curs2.getName()),(Assistant) assistant4);

        visitor.addExamScores(new Grade(3.25,2.25, (Student) student7,curs2.getName()),curs2.getTeacher());
        visitor.addPartialScores(new Grade(3.25,2.25, (Student) student7,curs2.getName()),(Assistant) assistant4);

        visitor.addExamScores(new Grade(2.45,4.20, (Student) student8,curs2.getName()),curs2.getTeacher());
        visitor.addPartialScores(new Grade(2.45,4.20, (Student) student8,curs2.getName()),(Assistant) assistant4);

        visitor.addExamScores(new Grade(4.25,3.60, (Student) student9,curs2.getName()),curs2.getTeacher());
        visitor.addPartialScores(new Grade(4.25,3.60, (Student) student9,curs2.getName()),(Assistant) assistant4);

        visitor.addExamScores(new Grade(1.30,1.95, (Student) student10,curs2.getName()),curs2.getTeacher());
        visitor.addPartialScores(new Grade(1.30,1.95, (Student) student10,curs2.getName()),(Assistant) assistant4);

        //ED
        visitor.addExamScores(new Grade(2.05,3.45, (Student) student11,curs3.getName()),curs3.getTeacher());
        visitor.addPartialScores(new Grade(2.05,3.45, (Student) student11,curs3.getName()),(Assistant) assistant6);

        visitor.addExamScores(new Grade(4.15,1.75, (Student) student12,curs3.getName()),curs3.getTeacher());
        visitor.addPartialScores(new Grade(4.15,1.75, (Student) student12,curs3.getName()),(Assistant) assistant6);

        visitor.addExamScores(new Grade(1.75,2.50, (Student) student13,curs3.getName()),curs3.getTeacher());
        visitor.addPartialScores(new Grade(1.75,2.50, (Student) student13,curs3.getName()),(Assistant) assistant6);

        visitor.addExamScores(new Grade(0.85,0.60, (Student) student14,curs3.getName()),curs3.getTeacher());
        visitor.addPartialScores(new Grade(0.85,0.60, (Student) student14,curs3.getName()),(Assistant) assistant6);

        visitor.addExamScores(new Grade(1.15,3.95, (Student) student15,curs3.getName()),curs3.getTeacher());
        visitor.addPartialScores(new Grade(1.15,3.95, (Student) student15,curs3.getName()),(Assistant) assistant6);

        visitor.addExamScores(new Grade(3.85,5.00, (Student) student16,curs3.getName()),curs3.getTeacher());
        visitor.addPartialScores(new Grade(3.85,5.00, (Student) student16,curs3.getName()),(Assistant) assistant5);

        visitor.addExamScores(new Grade(3.35,3.55, (Student) student17,curs3.getName()),curs3.getTeacher());
        visitor.addPartialScores(new Grade(3.35,3.55, (Student) student17,curs3.getName()),(Assistant) assistant5);

        visitor.addExamScores(new Grade(1.60,2.15, (Student) student18,curs3.getName()),curs3.getTeacher());
        visitor.addPartialScores(new Grade(1.60,2.15, (Student) student18,curs3.getName()),(Assistant) assistant5);

        visitor.addExamScores(new Grade(3.95,1.00, (Student) student19,curs3.getName()),curs3.getTeacher());
        visitor.addPartialScores(new Grade(3.95,1.00, (Student) student19,curs3.getName()),(Assistant) assistant5);

        visitor.addExamScores(new Grade(2.35,2.20, (Student) student20,curs3.getName()),curs3.getTeacher());
        visitor.addPartialScores(new Grade(2.35,2.20, (Student) student20,curs3.getName()),(Assistant) assistant5);



        //SO
        visitor.addExamScores(new Grade(3.45,1.65, (Student) student11,curs4.getName()),curs4.getTeacher());
        visitor.addPartialScores(new Grade(3.45,1.65, (Student) student11,curs4.getName()),(Assistant) assistant7);

        visitor.addExamScores(new Grade(2.70,3.35, (Student) student12,curs4.getName()),curs4.getTeacher());
        visitor.addPartialScores(new Grade(2.70,3.35, (Student) student12,curs4.getName()),(Assistant) assistant7);

        visitor.addExamScores(new Grade(3.40,2.80, (Student) student13,curs4.getName()),curs4.getTeacher());
        visitor.addPartialScores(new Grade(3.40,2.80, (Student) student13,curs4.getName()),(Assistant) assistant7);

        visitor.addExamScores(new Grade(2.30,4.15, (Student) student14,curs4.getName()),curs4.getTeacher());
        visitor.addPartialScores(new Grade(2.30,4.15, (Student) student14,curs4.getName()),(Assistant) assistant7);

        visitor.addExamScores(new Grade(3.15,0.55, (Student) student15,curs4.getName()),curs4.getTeacher());
        visitor.addPartialScores(new Grade(3.15,0.55, (Student) student15,curs4.getName()),(Assistant) assistant7);

        visitor.addExamScores(new Grade(2.40,3.65, (Student) student16,curs4.getName()),curs4.getTeacher());
        visitor.addPartialScores(new Grade(2.40,3.65, (Student) student16,curs4.getName()),(Assistant) assistant8);

        visitor.addExamScores(new Grade(3.00,2.10, (Student) student17,curs4.getName()),curs4.getTeacher());
        visitor.addPartialScores(new Grade(3.00,2.10, (Student) student17,curs4.getName()),(Assistant) assistant8);

        visitor.addExamScores(new Grade(0.80,3.10, (Student) student18,curs4.getName()),curs4.getTeacher());
        visitor.addPartialScores(new Grade(0.80,3.10, (Student) student18,curs4.getName()),(Assistant) assistant8);

        visitor.addExamScores(new Grade(1.90,3.30, (Student) student19,curs4.getName()),curs4.getTeacher());
        visitor.addPartialScores(new Grade(1.90,3.30, (Student) student19,curs4.getName()),(Assistant) assistant8);

        visitor.addExamScores(new Grade(4.65,1.45, (Student) student20,curs4.getName()),curs4.getTeacher());
        visitor.addPartialScores(new Grade(4.65,1.45, (Student) student20,curs4.getName()),(Assistant) assistant8);

       // visitor.visit(curs.getTeacher());
        // visitor.visit(group1.getAssistant());
        visitor.visit(group2.getAssistant());


        visitor.visit(curs2.getTeacher());
        visitor.visit(group3.getAssistant());
        visitor.visit(group4.getAssistant());

        visitor.visit(curs3.getTeacher());
        visitor.visit(group5.getAssistant());
        visitor.visit(group6.getAssistant());

        visitor.visit(curs4.getTeacher());
        visitor.visit(group7.getAssistant());
        visitor.visit(group8.getAssistant());


        curs.setBestStudentStrategy(new BestStudentStrategy.BestPartialScore());
        curs2.setBestStudentStrategy(new BestStudentStrategy.BestExamScore());
        curs3.setBestStudentStrategy(new BestStudentStrategy.BestTotalScore());
        curs4.setBestStudentStrategy(new BestStudentStrategy.BestPartialScore());

        //System.out.println(curs.getBestStudent()+"\n");

        //System.out.println(curs2.getBestStudent()+"\n");

        //System.out.println(curs3.getBestStudent()+"\n");

        //System.out.println(curs4.getBestStudent()+"\n");
        //visitor.sendNotifications();
       // System.out.println(Catalog.getInstance()+"\n..................................................................\n");

       // curs.makeBackup();

       // System.out.println(curs.getGrade((Student) student1));
        //curs.upgradeGrade(curs.getGrade((Student) student1),new Grade(6.00,0.00, (Student) student1,curs.getName()));

       // System.out.println(curs.getGrade((Student) student1));

      //  curs.undo();
        TeacherPage notesPage=new TeacherPage(visitor, curs.getTeacher());
        AssistantPage assistantPage=new AssistantPage(visitor, group1.getAssistant());
        StudentPage studentPage = new StudentPage((Student) student1);
        ParentPage parentPage= new ParentPage(((Student) student1).getMother());
        //System.out.println(curs.getGrade((Student) student1));
    }
}
