import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

class TeacherDetails extends JFrame implements ActionListener {
    Choice teacher_ID;
    JTable table;
    JButton search, print, update, add, cancel;

    TeacherDetails() {

        /* Background Color */
        getContentPane().setBackground(new Color(238, 232, 170));
        setLayout(null);

        JLabel heading = new JLabel("Search by Teacher ID");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        teacher_ID = new Choice();
        teacher_ID.setBounds(180, 20, 150, 20);
        add(teacher_ID);

        try {
            Jdbc db = new Jdbc();
            ResultSet rs = db.stm.executeQuery("select * from teacher_Details");
            while (rs.next()) {
                teacher_ID.add(rs.getString("teacher_ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable();
        table.setBackground(Color.LIGHT_GRAY);
        table.setBorder(BorderFactory.createLineBorder(Color.black));
        table.setGridColor(Color.black);

        try {
            Jdbc db = new Jdbc();
            ResultSet rs = db.stm.executeQuery("select * from teacher_Details");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);

        add = new JButton("Add");
        add.setBounds(220, 70, 80, 20);
        add.addActionListener(this);
        add(add);

        update = new JButton("Update");
        update.setBounds(320, 70, 80, 20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(420, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setTitle("Teacher's Details");
        setSize(900, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from teacher_Details where teacher_ID = '" + teacher_ID.getSelectedItem() + "'";
            try {
                Jdbc db = new Jdbc();
                ResultSet rs = db.stm.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == add) {
            setVisible(false);
            new NewFacultyInformation();
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateTeacherDetails();
        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new TeacherDetails();
    }

}
