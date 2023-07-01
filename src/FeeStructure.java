import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame {

    FeeStructure() {

        setLayout(null);

        getContentPane().setBackground(new Color(238, 232, 170));

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50, 10, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);

        JTable table = new JTable();
        table.setBackground(Color.LIGHT_GRAY);
        table.setBorder(BorderFactory.createLineBorder(Color.black));
        table.setGridColor(Color.black);

        try {
            Jdbc db = new Jdbc();
            ResultSet rs = db.stm.executeQuery("select * from fee_Details");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 60, 1000, 700);
        add(jsp);

        setSize(1000, 400);
        setTitle("Fee Structure");
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new FeeStructure();
    }
}
