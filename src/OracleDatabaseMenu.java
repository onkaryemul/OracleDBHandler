
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OracleDatabaseMenu {
    private static Connection conn;
    private static Statement stmt;
    private static Scanner sc;
    private static TableCreator tableCreator;
    private static DataInserter dataInserter;
    private static TableDisplayer tableDisplayer;
    private static RecordDeleter recordDeleter;
    private static TableUpdater tableUpdater;
    private static TableAlterer tableAlterer;
    private static TableDeleter tableDeleter;
    private static TableDescriber tableDescriber;


    private static void displayMenu() {
        System.out.println("\n*******  Menu  *******");
        System.out.println("1. Create table");
        System.out.println("2. Insert data");
        System.out.println("3. Display table");
        System.out.println("4. Delete record");
        System.out.println("5. Update table");
        System.out.println("6. Alter table");
        System.out.println("7. Delete table");
        System.out.println("8. Describe table");
        System.out.println("9. Exit");
    }


    public static void main(String[] args) {

        try {
            conn = DatabaseConnection.getConnection();
            stmt = conn.createStatement();
            sc = new Scanner(System.in);

            tableCreator = new TableCreator(conn);
            dataInserter = new DataInserter(conn);
            tableDisplayer = new TableDisplayer(conn);
            recordDeleter = new RecordDeleter(conn);
            tableUpdater = new TableUpdater(conn);
            tableAlterer = new TableAlterer(conn);
            tableDeleter = new TableDeleter(conn);
            tableDescriber = new TableDescriber(conn);

            while (true) {
                displayMenu();

                System.out.print("Enter your choice --->  ");
                int option = 0;
                try {
                    option = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println(e);
                    continue;
                }

                switch (option) {
                    case 1:
                        TableCreator tableCreator = new TableCreator(conn);
                        tableCreator.createTable();
                        break;

                    case 2:
                        DataInserter dataInserter = new DataInserter(conn);
                        dataInserter.insertData();
                        break;

                    case 3:
                        TableDisplayer tableDisplayer = new TableDisplayer(conn);
                        tableDisplayer.displayTable();
                        break;

                    case 4:
                        RecordDeleter recordDeleter = new RecordDeleter(conn);
                        recordDeleter.deleteRecord();
                        break;

                    case 5:
                        TableUpdater tableUpdater = new TableUpdater(conn);
                        tableUpdater.updateTable();
                        break;

                    case 6:
                        TableAlterer tableAlterer = new TableAlterer(conn);
                        tableAlterer.alterTable();
                        break;

                    case 7:
                        TableDeleter tableDeleter = new TableDeleter(conn);
                        tableDeleter.deleteTable();
                        break;

                    case 8:
                        TableDescriber tableDescriber = new TableDescriber(conn);
                        tableDescriber.describeTable();
                        break;

                    case 9:
                        System.out.println("\nExiting program.");
                        System.exit(0);

                    default:
                        System.out.println("\nInvalid option. Try again.");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

}

