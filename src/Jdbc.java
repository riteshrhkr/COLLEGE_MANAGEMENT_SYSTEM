import java.sql.Connection;
import java.sql.DriverManager;
// import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
  String jdbcURL = "jdbc:mysql://localhost:3306/college_manag_sys";
  String username = "root";
  String password = "Password@1234";
  Connection con = null;

  Statement stm = null;

  Jdbc() {
    try {
      con = DriverManager.getConnection(jdbcURL, username, password);
      // System.out.println("Connected to Postgresql server");

      stm = con.createStatement();

    } catch (SQLException e) {

      System.out.println("Error in connecting to MySQL server");
      e.printStackTrace();
    }

  }

}
