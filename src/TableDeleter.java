
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TableDeleter {
    private Connection conn;
    private Statement stmt;
    private Scanner sc;

    public TableDeleter(Connection conn) {
        this.conn = conn;
        this.sc = new Scanner(System.in);
    }

    public void deleteTable() {
        try {
            stmt = conn.createStatement();

            System.out.println("\nEnter table name: ");
            String tableName = sc.nextLine();

            String query = "DROP TABLE " + tableName;
            stmt.execute(query);
            System.out.println("Table deleted successfully.\n");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
