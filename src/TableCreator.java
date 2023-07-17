
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TableCreator {
    private Connection conn;
    private Statement stmt;
    private Scanner sc;

    public TableCreator(Connection conn) {
        this.conn = conn;
        this.sc = new Scanner(System.in);
    }

    public void createTable() {
        try {
            stmt = conn.createStatement();

            System.out.println("\nEnter table name: ");
            String tableName = sc.nextLine();

            System.out.println("Enter column names and data types (separated by commas): ");
            String columns = sc.nextLine();

            String query = "CREATE TABLE " + tableName + "(" + columns + ")";
            stmt.execute(query);
            System.out.println("Table created successfully.\n");
        } catch (SQLException e) {
            System.out.println(e);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

}
