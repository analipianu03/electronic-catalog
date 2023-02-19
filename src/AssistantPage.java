import jdk.dynalink.support.AbstractRelinkableCallSite;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;


public class AssistantPage  extends JFrame implements ListSelectionListener {
    private HashMap<Assistant, ArrayList<ScoreVisitor.Tuple<Student, String, Double>>> pScores;
    ArrayList<ScoreVisitor.Tuple<Student, String, Double>> NOTE;

    JButton back, buttonAdaugaNote;
    JScrollPane scrollPaneNote;
    Vector<String> coursesNames = new Vector<>();
    JPanel p = new JPanel();
    ArrayList<Course> courses = new ArrayList<>();
    JList listaNote, listaCursuri;
    JFrame frame2;
    ScoreVisitor copieVisitor;
    Assistant copieAssistant;

    public AssistantPage(ScoreVisitor visitor, Assistant assistant) {
        super("Assistant: "+ assistant.toString());

        copieAssistant = assistant;
        copieVisitor = visitor;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 500);
        setMinimumSize(new Dimension(300, 300));
        setLayout(new GridLayout(1, 1));

        setLocation(350,0);
        for (Course course : Catalog.getInstance().getCourses())
            for (Group group : course.getGroups().values())
                if (group.getAssistant().equals(assistant)) {
                    courses.add(course);
                    coursesNames.add(course.getName());
                }


        pScores = visitor.getPartialScores();
        NOTE = pScores.get(assistant);

        listaCursuri = new JList<String>(coursesNames);
        JScrollPane scrollPaneCursuri = new JScrollPane(listaCursuri);
        add(scrollPaneCursuri, BorderLayout.WEST);


        listaCursuri.addListSelectionListener(this);

        frame2 = new JFrame("NOTE");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(350, 200);
        frame2.setMinimumSize(new Dimension(100, 100));
        frame2.setLayout(new GridLayout(1, 2));
        DefaultListModel<String> model = new DefaultListModel<>();
        NOTE.forEach(t -> model.addElement(t.getFirst() + " " + t.getThird()));
        listaNote = new JList<>(model);
        scrollPaneNote = new JScrollPane(listaNote);
        frame2.add(scrollPaneNote);
        frame2.setLocation(350,100);
        JPanel butoane = new JPanel(new BorderLayout());

        butoane.setAlignmentY(100);
        buttonAdaugaNote = new JButton("Adauga note");
        back = new JButton("inapoi la cursuri");

        butoane.add(buttonAdaugaNote, BorderLayout.CENTER);

        butoane.add(back, BorderLayout.SOUTH);
        frame2.add(butoane);
        buttonAdaugaNote.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                copieVisitor.visit(copieAssistant);
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

