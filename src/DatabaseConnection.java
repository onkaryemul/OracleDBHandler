
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String user = "system";
    private static final String password = "admin";

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("\nConnection successful.");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch(SQLException e) {
            System.out.println(e);
        }

        return conn;
    }

}
