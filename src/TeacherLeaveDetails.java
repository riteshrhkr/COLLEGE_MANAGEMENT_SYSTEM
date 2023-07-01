import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener {

    Choice cTeacher_ID;
    JTable table;
    JButton search, print, cancel;

    TeacherLeaveDetails() {

        getContentPane().setBackground(new Color(238, 232, 170));
        setLayout(null);

        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        cTeacher_ID = new Choice();
        cTeacher_ID.setBounds(180, 20, 150, 20);
        add(cTeacher_ID);

        try {
            Jdbc db = new Jdbc();
            ResultSet rs = db.stm.executeQuery("select * from teacher_Leave");
            while (rs.next()) {
                cTeacher_ID.add(rs.getString("teacher_ID"));
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
            ResultSet rs = db.stm.executeQuery("select * from teacher_Leave");
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

        cancel = new JButton("Cancel");
        cancel.setBounds(220, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900, 650);
        setTitle("Teachers Leave Details");
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from teacher_Leave where teacher_ID = '" + cTeacher_ID.getSelectedItem() + "'";
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
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}
