import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ExaminationDetails extends JFrame implements ActionListener {

    JTextField search;
    JButton submit, cancel;
    JTable table;

    ExaminationDetails() {

        setLayout(null);
        getContentPane().setBackground(new Color(238, 232, 170));

        JLabel heading = new JLabel("Check Result");
        heading.setBounds(80, 15, 400, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(heading);

        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(search);

        submit = new JButton("Result");
        submit.setBounds(300, 90, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);

        cancel = new JButton("Back");
        cancel.setBounds(440, 90, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        table = new JTable();
        table.setBackground(Color.LIGHT_GRAY);
        table.setBorder(BorderFactory.createLineBorder(Color.black));
        table.setGridColor(Color.black);
        // table.setFont(new Font("Tahoma", Font.PLAIN, 16));
        // table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 1000, 310);
        add(jsp);

        try {
            Jdbc db = new Jdbc();
            ResultSet rs = db.stm.executeQuery("select * from student_Details");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString());
            }
        });

        setSize(1000, 475);
        setTitle("Examination Details");
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            setVisible(false);
            new Marks(search.getText());
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ExaminationDetails();
    }
}
