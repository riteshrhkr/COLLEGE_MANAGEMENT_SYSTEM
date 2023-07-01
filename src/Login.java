import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
  private Image loginImage;
  private Image loginIcon;
  private Image cancelIcon;
  // private Image custImage;

  JButton login, cancel;
  JTextField tfusername;
  JPasswordField jpassword;
  JLabel lUsername, lPassword;

  Login() {
    getContentPane().setBackground(new Color(238, 232, 170));
    setLayout(null);

    lUsername = new JLabel("Username");
    lUsername.setFont(new Font("Regular", Font.BOLD, 20));
    lUsername.setBounds(250, 20, 150, 40);
    add(lUsername);

    tfusername = new JTextField();
    tfusername.setFont(new Font("Regular", Font.BOLD, 16));
    tfusername.setBounds(400, 20, 200, 40);
    add(tfusername);

    lPassword = new JLabel("Password");
    lPassword.setFont(new Font("Regular", Font.BOLD, 20));
    lPassword.setBounds(250, 80, 150, 40);
    add(lPassword);

    jpassword = new JPasswordField();
    jpassword.setEchoChar('*');
    jpassword.setToolTipText("Password");
    jpassword.setBackground(Color.YELLOW);
    jpassword.setForeground(Color.BLUE);
    jpassword.setFont(new Font("Regular", Font.BOLD, 16));
    jpassword.setBounds(400, 80, 200, 40);
    add(jpassword);

    ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
    loginIcon = i11.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
    ImageIcon i12 = new ImageIcon(loginIcon);

    login = new JButton("Login", i12);
    login.setBounds(280, 160, 150, 40);
    // login.setBackground(Color.BLACK);
    // login.setForeground(Color.white);
    login.setFont(new Font("Tahoma", Font.BOLD, 15));
    login.addActionListener(this);
    add(login);

    ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/cancel.jpg"));
    cancelIcon = i13.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);

    cancel = new JButton("Cancel", new ImageIcon(cancelIcon));
    cancel.setBounds(450, 160, 150, 40);
    // cancel.setBackground(Color.BLACK);
    // cancel.setForeground(Color.white);
    cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
    cancel.addActionListener(this);
    add(cancel);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
    loginImage = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
    ImageIcon i2 = new ImageIcon(loginImage);
    JLabel lcust = new JLabel(i2);
    lcust.setBounds(-20, 0, 250, 290);
    add(lcust);

    setTitle("Login Page");
    setResizable(false);
    setSize(640, 300);
    setLocationRelativeTo(null);
    setVisible(true);
    // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == login) {
      String username = tfusername.getText();
      String password = String.valueOf(jpassword.getPassword());

      // String query = "select * from login where username = '"+username+"', and
      // password = '"+password+"'";

      try {
        Jdbc db = new Jdbc();
        String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
        /*
         * When we use select statement then 'executeQuery' is used and if we use insert
         * command then 'executeUpdate' is used
         */
        ResultSet rs = db.stm.executeQuery(query);

        if (rs.next()) {
          setVisible(false);
          new Project();
        } else {
          JOptionPane.showMessageDialog(null, "Invalid Login");
          tfusername.setText("");
          jpassword.setText("");
        }
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    } else if (e.getSource() == cancel) {
      setVisible(false);
    }
  }

  public static void main(String[] args) {
    new Login();
  }

}
