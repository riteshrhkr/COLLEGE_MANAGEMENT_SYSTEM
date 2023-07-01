import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener {

    String rollno;
    JButton Back;
    JButton Show;
    Choice cSemester;
    JLabel lblsemester, totallbl, totalNum;
    JLabel sub1, sub2, sub3, sub4, sub5;
    int total = 0;

    Marks(String rollno) {
        this.rollno = rollno;

        setLayout(null);
        getContentPane().setBackground(new Color(238, 232, 170));

        JLabel heading = new JLabel("Nalanda College, Biharsharif");
        heading.setBounds(100, 10, 500, 25);
        heading.setForeground(new Color(220, 20, 60));
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Result of Examination, 2023");
        subheading.setBounds(110, 50, 500, 20);
        subheading.setForeground(new Color(220, 20, 60));
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);

        JLabel lblrollno = new JLabel("Roll Number : " + rollno);
        lblrollno.setBounds(60, 100, 500, 20);
        lblrollno.setForeground(new Color(47, 79, 79));
        lblrollno.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblrollno);

        lblsemester = new JLabel("Select Semester :");
        lblsemester.setBounds(60, 138, 180, 20);
        lblsemester.setForeground(new Color(47, 79, 79));
        lblsemester.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblsemester);

        cSemester = new Choice();
        cSemester.setBounds(250, 138, 150, 25);
        add(cSemester);

        try {
            Jdbc db = new Jdbc();
            ResultSet rs = db.stm.executeQuery("select * from marks_details where roll = '" + rollno + "'");
            while (rs.next()) {
                cSemester.add(rs.getString("semester"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        sub1 = new JLabel();
        sub1.setForeground(new Color(0, 100, 0));
        sub1.setBounds(100, 200, 500, 20);
        sub1.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(sub1);

        sub2 = new JLabel();
        sub2.setForeground(new Color(0, 100, 0));
        sub2.setBounds(100, 230, 500, 20);
        sub2.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(sub2);

        sub3 = new JLabel();
        sub3.setForeground(new Color(0, 100, 0));
        sub3.setBounds(100, 260, 500, 20);
        sub3.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(sub3);

        sub4 = new JLabel();
        sub4.setForeground(new Color(0, 100, 0));
        sub4.setBounds(100, 290, 500, 20);
        sub4.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(sub4);

        sub5 = new JLabel();
        sub5.setForeground(new Color(0, 100, 0));
        sub5.setBounds(100, 320, 500, 20);
        sub5.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(sub5);

        totallbl = new JLabel();
        totallbl.setForeground(new Color(47, 79, 79));
        totallbl.setBounds(60, 400, 100, 30);
        totallbl.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(totallbl);

        totalNum = new JLabel();
        totalNum.setForeground(new Color(47, 79, 79));
        totalNum.setBounds(150, 400, 100, 30);
        totalNum.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(totalNum);

        /*
         * cSemester.addItemListener(new ItemListener() {
         * public void itemStateChanged(ItemEvent ie) {
         * try {
         * jdbc db = new jdbc();
         * 
         * String query1 =
         * "select * from subject where roll = '"+rollno+"' and semester = '"
         * +cSemester.getSelectedItem()+"'" ;
         * 
         * String query2 =
         * "select * from marks_Details where roll = '"+rollno+"' and semester = '"
         * +cSemester.getSelectedItem()+"'";
         * 
         * ResultSet rs1 = db.stm.executeQuery(query1);
         * while(rs1.next()) {
         * sub1.setText(rs1.getString("subject1"));
         * sub2.setText(rs1.getString("subject2"));
         * sub3.setText(rs1.getString("subject3"));
         * sub4.setText(rs1.getString("subject4"));
         * sub5.setText(rs1.getString("subject5"));
         * }
         * 
         * 
         * ResultSet rs2 = db.stm.executeQuery(query2);
         * while(rs2.next()) {
         * sub1.setText(sub1.getText() + "------------" + rs2.getString("marks1"));
         * sub2.setText(sub2.getText() + "------------" + rs2.getString("marks2"));
         * sub3.setText(sub3.getText() + "------------" + rs2.getString("marks3"));
         * sub4.setText(sub4.getText() + "------------" + rs2.getString("marks4"));
         * sub5.setText(sub5.getText() + "------------" + rs2.getString("marks5"));
         * 
         * }
         * } catch (Exception e) {
         * e.printStackTrace();
         * }
         * }
         * });
         */

        /*
         * try {
         * jdbc db = new jdbc();
         * 
         * ResultSet rs1 = db.stm.executeQuery("select * from subject where roll = '"
         * +rollno+"' and '"+cSemester.getSelectedItem()+"'");
         * while(rs1.next()) {
         * sub1.setText(rs1.getString("subject1"));
         * sub2.setText(rs1.getString("subject2"));
         * sub3.setText(rs1.getString("subject3"));
         * sub4.setText(rs1.getString("subject4"));
         * sub5.setText(rs1.getString("subject5"));
         * }
         * 
         * /* ResultSet rs2 =
         * db.stm.executeQuery("select * from marks_Details where roll = '"
         * +rollno+"' and semester = '"+cSemester.getSelectedItem()+"'");
         * while(rs2.next()) {
         * sub1.setText(sub1.getText() + "------------" + rs2.getString("marks1"));
         * sub2.setText(sub2.getText() + "------------" + rs2.getString("marks2"));
         * sub3.setText(sub3.getText() + "------------" + rs2.getString("marks3"));
         * sub4.setText(sub4.getText() + "------------" + rs2.getString("marks4"));
         * sub5.setText(sub5.getText() + "------------" + rs2.getString("marks5"));
         * 
         * }
         * 
         * 
         * 
         * } catch (Exception e) {
         * e.printStackTrace();
         * }
         */

        Show = new JButton("Show");
        Show.setBounds(60, 500, 100, 30);
        Show.setBackground(Color.BLACK);
        Show.setForeground(Color.WHITE);
        Show.addActionListener(this);
        Show.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(Show);

        Back = new JButton("Back");
        Back.setBounds(250, 500, 120, 30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.addActionListener(this);
        Back.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(Back);

        setTitle("Marks Details");
        setSize(500, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Show) {

            try {
                Jdbc db = new Jdbc();

                String query1 = "select * from subject where roll = '" + rollno + "' and semester = '"
                        + cSemester.getSelectedItem() + "'";

                String query2 = "select * from marks_Details where roll = '" + rollno + "' and semester = '"
                        + cSemester.getSelectedItem() + "'";

                ResultSet rs1 = db.stm.executeQuery(query1);
                while (rs1.next()) {
                    sub1.setText(rs1.getString("sub1"));
                    sub2.setText(rs1.getString("sub2"));
                    sub3.setText(rs1.getString("sub3"));
                    sub4.setText(rs1.getString("sub4"));
                    sub5.setText(rs1.getString("sub5"));
                }

                ResultSet rs2 = db.stm.executeQuery(query2);
                while (rs2.next()) {
                    sub1.setText(sub1.getText() + "------------" + rs2.getString("mark1"));
                    total = total + Integer.parseInt(rs2.getString("mark1"));
                    sub2.setText(sub2.getText() + "------------" + rs2.getString("mark2"));
                    total = total + Integer.parseInt(rs2.getString("mark2"));
                    sub3.setText(sub3.getText() + "------------" + rs2.getString("mark3"));
                    total = total + Integer.parseInt(rs2.getString("mark3"));
                    sub4.setText(sub4.getText() + "------------" + rs2.getString("mark4"));
                    total = total + Integer.parseInt(rs2.getString("mark4"));
                    sub5.setText(sub5.getText() + "------------" + rs2.getString("mark5"));
                    total = total + Integer.parseInt(rs2.getString("mark5"));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            totallbl.setText("Total : ");
            totalNum.setText(String.valueOf(total));
            total = 0;

        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Marks("");
    }
}
