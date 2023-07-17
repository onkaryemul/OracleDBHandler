
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DataInserter {
    private Connection conn;
    private Statement stmt;
    private Scanner sc;

    public DataInserter(Connection conn) {
        this.conn = conn;
        this.sc = new Scanner(System.in);
    }

    public void insertData() {
        try {
            stmt = conn.createStatement();

            System.out.println("\nEnter table name: ");
            String tableName = sc.nextLine();

            System.out.println("Select an option:");
            System.out.println("1. Insert values into all columns");
            System.out.println("2. Insert values into selected columns");

            System.out.print("\nEnter your option --->  ");
            int option = 0;
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(e);
                return;
            }

            String columns = "";
            String values = "";

            switch (option) {
                case 1:
                    System.out.println("Enter values to insert (separated by commas): ");
                    values = sc.nextLine();
                    break;

                case 2:
                    System.out.println("Enter column names (separated by commas): ");
                    columns = sc.nextLine();
                    System.out.println("Enter values to insert (separated by commas): ");
                    values = sc.nextLine();
                    break;

                default:
                    System.out.println("\nInvalid option. Try again.");
                    return;
            }

            String query;
            if (columns.isEmpty()) {
                query = "INSERT INTO " + tableName + " VALUES(" + values + ")";
            } else {
                query = "INSERT INTO " + tableName + "(" + columns + ")" + " VALUES(" + values + ")";
            }

            stmt.executeUpdate(query);

            System.out.println("Data inserted successfully.\n");
        } catch (SQLException e) {
            System.out.println(e);
        } catch(Exception e) {
            System.out.println(e);
        }

    }

}
