import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentLeaveDetails extends JFrame implements ActionListener {

    Choice rollno;
    JTable table;
    JButton search, print, cancel;

    StudentLeaveDetails() {

        getContentPane().setBackground(new Color(238, 232, 170));
        setLayout(null);

        JLabel heading = new JLabel("Search by Student_Roll : ");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        rollno = new Choice();
        rollno.setBounds(180, 20, 150, 20);
        add(rollno);

        try {
            Jdbc db = new Jdbc();
            ResultSet rs = db.stm.executeQuery("select * from student_Leave");
            while (rs.next()) {
                rollno.add(rs.getString("roll"));
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
            ResultSet rs = db.stm.executeQuery("select * from student_Leave");
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
        setTitle("Student Leave Details");
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from student_Leave where roll = '" + rollno.getSelectedItem() + "'";
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
        new StudentLeaveDetails();
    }
}
