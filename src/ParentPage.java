import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class ParentPage  extends JFrame {


        JPanel p=new JPanel();
        //JFrame frame2= new JFrame();
        JButton button,back ;
        Parent copyParent;

        public ParentPage(Parent parent)
        {
            super("Parent: "+parent.toString());
            copyParent=parent;
            setLocation(700,400);
            setSize(350,100);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new FlowLayout());
            button = new JButton("UPDATE NOTE");
            add(button);





            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame frame2= new JFrame("NEWS");
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setSize(800, 300);
                    frame2.setLocation(700,400);
                    frame2.setMinimumSize(new Dimension(300, 300));
                    frame2.setLayout( new FlowLayout());
                    back = new JButton("back to main");
                    back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            setVisible(true);
                            frame2.setVisible(false);
                        }
                    });
                    frame2.add(back);

                    Student student=null;
                    for(Course course:Catalog.getInstance().getCourses())
                        for(HashMap.Entry<Student,Grade> entry :course.getAllStudentGrades().entrySet())
                        {
                            if(entry.getKey().getMother()!=null)
                                if(entry.getKey().getMother().toString().equals(copyParent.toString())) {
                                    student = entry.getKey();
                                    Grade grade=entry.getValue();
                                    JLabel text= new JLabel(new Notification(grade, grade.getStudent()).toString());
                                    frame2.add(text);
                                }
                            if(entry.getKey().getFather()!=null)
                                if(entry.getKey().getFather().toString().equals(copyParent.toString())) {
                                    student = entry.getKey();
                                    Grade grade=entry.getValue();
                                    JLabel text= new JLabel(new Notification(grade, grade.getStudent()).toString());
                                    frame2.add(text);
                                }
                        }
                    frame2.setVisible(true);
                    setVisible(false);
                }
            });
            setVisible(true);
            /*
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setSize(800, 300);
            frame2.setLocation(700,400);
            frame2.setMinimumSize(new Dimension(300, 300));
            frame2.setLayout( new FlowLayout());



            ///JLabel ESTE TEXT IN PANEL!!!!!!!!!!!!!!!!!!!!
            button = new JButton("UPDATE NOTE");
            add(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Parent parent=null;
                    Student student=null;
                    for(Course course:Catalog.getInstance().getCourses())
                        for(HashMap.Entry<Student,Grade> entry :course.getAllStudentGrades().entrySet())
                        {
                            if(entry.getKey().getMother()!=null)
                                if(entry.getKey().getMother().toString().equals(nume)) {
                                    parent = entry.getKey().getMother();
                                    student = entry.getKey();
                                    Grade grade=entry.getValue();
                                    JLabel text= new JLabel(new Notification(grade, grade.getStudent()).toString());
                                    frame2.add(text);
                                }
                            if(entry.getKey().getFather()!=null)
                                if(entry.getKey().getFather().toString().equals(nume)) {
                                    parent = entry.getKey().getFather();
                                    student = entry.getKey();
                                    Grade grade=entry.getValue();
                                    JLabel text= new JLabel(new Notification(grade, grade.getStudent()).toString());
                                    frame2.add(text);
                                }
                        }
                }
            });




            setVisible(true);

             */
        }


    }
