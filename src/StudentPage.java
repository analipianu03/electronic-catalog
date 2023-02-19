import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.Vector;


public class StudentPage extends JFrame implements ListSelectionListener, ActionListener {
    JList list;
    JLabel t1, t2,t3,t4,t5,t6;
    JButton button;
    JLabel j1, j2,j3,j4,j5,j6;
    Vector<String> coursesNames = new Vector<>();
    ArrayList<Course> courses= new ArrayList<>();
    Assistant assistant;
    Student copieStudent;
    public StudentPage(Student student) {
        super("Student: "+student.toString());
        copieStudent=student;

        for (Course course : Catalog.getInstance().getCourses())
            for(Group group: course.getGroups().values())
            if (group.getStudents().contains(student))
            {
                courses.add(course);
                assistant=group.getAssistant();
                coursesNames.add(course.getName());
            }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 300);
        setMinimumSize(new Dimension(300, 300));
        setLayout(new GridLayout(1, 2));
        setLocation(700,100);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(7, 1));
        j1 = new JLabel("Profesor");
        j2 = new JLabel("Echipa");
        j3 = new JLabel("Asistent");
        j4 = new JLabel("Nota partial");
        j5 = new JLabel("Nota examen");
        j6 = new JLabel("Nota finala");
        t1 = new JLabel("");
        t2 = new JLabel("");
        t3 = new JLabel("");
        t4 = new JLabel("");
        t5 = new JLabel("");
        t6 = new JLabel("");
        p.add(j1);
        p.add(t1);
        p.add(j2);
        p.add(t2);
        p.add(j3);
        p.add(t3);
        p.add(j4);
        p.add(t4);
        p.add(j5);
        p.add(t5);
        p.add(j6);
        p.add(t6);

        button = new JButton("Vezi detalii");
        p.add(button);
        button.addActionListener(this);
        list = new JList<String>(coursesNames);
        JScrollPane scrollPane = new JScrollPane(list);
        add(scrollPane, BorderLayout.WEST);
        add(p, BorderLayout.EAST);

        list.addListSelectionListener(this);
        setVisible(true);

    }

    public void valueChanged(ListSelectionEvent e) {

    }

    public void actionPerformed(ActionEvent e) {

        if (list.isSelectionEmpty())
            return;
        else {
            int i = list.getSelectedIndex();
            Course c = courses.get(i);
            t1.setText(c.getTeacher().toString());
            t2.setText(c.getAssistants().toString());
            t3.setText(assistant.toString());
            if(c.getGrade(copieStudent)==null||c.getGrade(copieStudent).getPartialScore()==0)
                t4.setText("nota neadaugata");
            else
            t4.setText(c.getGrade(copieStudent).getPartialScore().toString());
            if(c.getGrade(copieStudent)==null||c.getGrade(copieStudent).getExamScore()==0)
                t5.setText("nota neadaugata");
            else
            t5.setText(c.getGrade(copieStudent).getExamScore().toString());
            if(c.getGrade(copieStudent)==null||c.getGrade(copieStudent).getTotalScore()==0)
                t6.setText("nota neadaugata");
            else
            t6.setText(c.getGrade(copieStudent).getTotalScore().toString());
        }
    }
}