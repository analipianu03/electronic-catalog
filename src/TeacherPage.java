
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class TeacherPage  extends JFrame implements ListSelectionListener {
    private HashMap<Teacher, ArrayList<ScoreVisitor.Tuple<Student, String, Double>>> eScores;
    ArrayList<ScoreVisitor.Tuple<Student, String, Double>> NOTE;

    JButton buttonAdaugaNote,back;
    JScrollPane scrollPaneNote;
    Vector<String> coursesNames = new Vector<>();
    JLabel nume= new JLabel();
    ArrayList<Course> courses= new ArrayList<>();
    JList listaNote,listaCursuri;
    JFrame frame2;
    ScoreVisitor copieVisitor;
    Teacher copieTeacher;

    public TeacherPage (ScoreVisitor visitor, Teacher teacher) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        super("Teacher: "+teacher.toString() );

        //MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
        //UIManager.setLookAndFeel(NoireLookAndFeel.class.getName());

        copieTeacher=teacher;
        copieVisitor=visitor;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 500);
        setMinimumSize(new Dimension(300, 300));
        setLayout(new GridLayout(1, 1));

        for (Course course : Catalog.getInstance().getCourses())
            if(course.getTeacher().equals(teacher))
            {
                courses.add(course);
                coursesNames.add(course.getName());
            }


        eScores=visitor.getExamScores();
        NOTE= eScores.get(teacher);

        listaCursuri = new JList<String>(coursesNames);
        JScrollPane scrollPaneCursuri = new JScrollPane(listaCursuri);
        add(scrollPaneCursuri, BorderLayout.CENTER);

        //add(p, BorderLayout.EAST);
        listaCursuri.addListSelectionListener(this);

        frame2= new JFrame("NOTE");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(350, 200);
        frame2.setMinimumSize(new Dimension(100, 100));
        frame2.setLayout(new GridLayout(1, 2));
        DefaultListModel<String> model = new DefaultListModel<>();
        NOTE.forEach(t -> model.addElement(t.getFirst() +" "+t.getThird()));
        listaNote = new JList<>(model);
        scrollPaneNote = new JScrollPane(listaNote);
        frame2.setLocation(0,100);
        frame2.add(scrollPaneNote);
        JPanel butoane=new JPanel(new BorderLayout());

        butoane.setAlignmentY(100);
        buttonAdaugaNote = new JButton("Adauga note");
        back = new JButton("inapoi la cursuri");

        butoane.add(buttonAdaugaNote, BorderLayout.CENTER);

        butoane.add(back, BorderLayout.SOUTH);
        //butoane.

        frame2.add(butoane);
        buttonAdaugaNote.addActionListener(new ActionListener() {
            @Override

                public void actionPerformed(ActionEvent e) {
                    copieVisitor.visit(copieTeacher);
                    System.out.println(Catalog.getInstance().getCourses().get(0));
                    scrollPaneNote.removeAll();
                    scrollPaneNote.repaint();
                }

        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(false);
                frame2.setSize(350, 200);
                setVisible(true);
            }
        });
        {

        }
        //back.addActionListener(this);
        setVisible(true);


    }

    /**
     * @param e the event that characterizes the change.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (listaCursuri.isSelectionEmpty())
            return;
        else {
            int i = listaCursuri.getSelectedIndex();
            frame2.setVisible(true);
            setVisible(false);
            listaCursuri.clearSelection();
        }

    }

    /**
     * @param e the event to be processed
     */

}
