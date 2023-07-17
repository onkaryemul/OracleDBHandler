
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RecordDeleter {
    private Connection conn;
    private Statement stmt;
    private Scanner sc;

    public RecordDeleter(Connection conn) {
        this.conn = conn;
        this.sc = new Scanner(System.in);
    }

    public void deleteRecord() {
        try {
            stmt = conn.createStatement();

            System.out.println("\nEnter table name: ");
            String tableName = sc.nextLine();

            System.out.println("Enter condition for deletion: ");
            String condition = sc.nextLine();

            String query = "DELETE FROM " + tableName + " WHERE " + condition;
            stmt.executeUpdate(query);

            System.out.println("Record deleted successfully.\n");
        } catch (SQLException e) {
            System.out.println(e);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}
