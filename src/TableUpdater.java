
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TableUpdater {
    private Connection conn;
    private Statement stmt;
    private Scanner sc;

    public TableUpdater(Connection conn) {
        this.conn = conn;
        this.sc = new Scanner(System.in);
    }

    public void updateTable() {
        try {
            stmt = conn.createStatement();

            System.out.println("\nEnter table name: ");
            String tableName = sc.nextLine();

            System.out.println("Enter column name to update: ");
            String columnName = sc.nextLine();

            System.out.println("Enter new value: ");
            String newValue = sc.nextLine();

            System.out.println("Enter condition for updating: ");
            String condition = sc.nextLine();

            String query = "UPDATE " + tableName + " SET " + columnName + " = " + newValue + " WHERE " + condition;
            stmt.executeUpdate(query);

            System.out.println("Table updated successfully.\n");
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
