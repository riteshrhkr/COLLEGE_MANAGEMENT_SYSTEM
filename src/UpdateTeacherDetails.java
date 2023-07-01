import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

class UpdateTeacherDetails extends JFrame implements ActionListener {
    JTextField tfQulifi, tfaddress, tfphone, tfemail, tfbranch;
    JLabel labelrollno;
    JButton update, cancel;
    Choice cteacher_ID;

    UpdateTeacherDetails() {

        /* Background Color */
        getContentPane().setBackground(new Color(238, 232, 170));
        setLayout(null);

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setForeground(new Color(204, 0, 0));
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("Arial Nova", Font.BOLD, 40));
        add(heading);

        JLabel lblTeacher_ID = new JLabel("Select Teacher ID");
        lblTeacher_ID.setBounds(50, 100, 200, 20);
        lblTeacher_ID.setForeground(new Color(0, 100, 0));
        lblTeacher_ID.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTeacher_ID);

        cteacher_ID = new Choice();
        cteacher_ID.setBounds(250, 100, 200, 20);
        add(cteacher_ID);

        try {
            Jdbc db = new Jdbc();
            ResultSet rs = db.stm.executeQuery("select * from teacher_Details");
            while (rs.next()) {
                cteacher_ID.add(rs.getString("teacher_ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 150, 150, 30);
        labelname.setFont(new Font("Arial", Font.PLAIN, 18));
        add(labelname);

        JLabel lblfname = new JLabel("Father'stm Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(600, 150, 150, 30);
        labelfname.setFont(new Font("Arial", Font.PLAIN, 18));
        add(labelfname);

        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(50, 200, 200, 30);
        lblrollno.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblrollno);

        labelrollno = new JLabel();
        labelrollno.setBounds(200, 200, 200, 30);
        labelrollno.setFont(new Font("Arial", Font.PLAIN, 18));
        add(labelrollno);

        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbldob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(600, 200, 150, 30);
        labeldob.setFont(new Font("Arial", Font.PLAIN, 18));
        add(labeldob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("Arial", Font.BOLD, 20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400, 300, 200, 30);
        lblx.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblx);

        JLabel labelx = new JLabel();
        labelx.setBounds(600, 300, 150, 30);
        labelx.setFont(new Font("Arial", Font.PLAIN, 18));
        add(labelx);

        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50, 350, 200, 30);
        lblxii.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblxii);

        JLabel labelxii = new JLabel();
        labelxii.setBounds(200, 350, 150, 30);
        labelxii.setFont(new Font("Arial", Font.PLAIN, 18));
        add(labelxii);

        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400, 350, 200, 30);
        lblaadhar.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblaadhar);

        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(600, 350, 150, 30);
        labelaadhar.setFont(new Font("Arial", Font.PLAIN, 18));
        add(labelaadhar);

        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblcourse);

        tfQulifi = new JTextField();
        tfQulifi.setBounds(200, 400, 150, 30);
        add(tfQulifi);

        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(400, 400, 200, 30);
        lblbranch.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblbranch);

        tfbranch = new JTextField();
        tfbranch.setBounds(600, 400, 150, 30);
        add(tfbranch);

        try {
            Jdbc db = new Jdbc();
            String query = "select * from teacher_Details where teacher_ID='" + cteacher_ID.getSelectedItem() + "'";
            ResultSet rs = db.stm.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("x"));
                labelxii.setText(rs.getString("xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelrollno.setText(rs.getString("teacher_ID"));
                tfQulifi.setText(rs.getString("qualification"));
                tfbranch.setText(rs.getString("department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cteacher_ID.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Jdbc db = new Jdbc();
                    String query = "select * from teacher_Details where teacher_ID='" + cteacher_ID.getSelectedItem()
                            + "'";
                    ResultSet rs = db.stm.executeQuery(query);
                    while (rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelx.setText(rs.getString("x"));
                        labelxii.setText(rs.getString("xii"));
                        labelaadhar.setText(rs.getString("aadhar"));
                        labelrollno.setText(rs.getString("teacher_ID"));
                        tfQulifi.setText(rs.getString("qualification"));
                        tfbranch.setText(rs.getString("department"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        update = new JButton("Update");
        update.setBounds(250, 500, 120, 30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        update.setFont(new Font("Arial", Font.BOLD, 15));
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 500, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Arial", Font.BOLD, 15));
        add(cancel);

        setTitle("Update Teacher Details");
        setSize(900, 650);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String rollno = labelrollno.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course = tfQulifi.getText();
            String department = tfbranch.getText();

            try {
                String query = "update teacher_Details set address='" + address + "', phone='" + phone + "', email='"
                        + email + "', course='" + course + "', department='" + department + "' where teacher_ID='"
                        + rollno + "'";
                Jdbc db = new Jdbc();
                db.stm.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new UpdateTeacherDetails();
    }

}
