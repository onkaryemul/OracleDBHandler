
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TableDisplayer {
    private Connection conn;
    private Statement stmt;
    private Scanner sc;

    public TableDisplayer(Connection conn) {
        this.conn = conn;
        this.sc = new Scanner(System.in);
    }

    public void displayTable() {
        try {
            stmt = conn.createStatement();

            System.out.println("\nEnter table name: ");
            String tableName = sc.nextLine();

            System.out.println("Select an option:");
            System.out.println("1. Display entire table");
            System.out.println("2. Display selected columns");
            System.out.println("3. Display selected rows");
            System.out.println("4. Display selected columns with selected rows");

            System.out.print("\nEnter your option --->  ");
            int option = 0;
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(e);
                return;
            }

            String query = "";

            switch (option) {
                case 1:
                    query = "SELECT * FROM " + tableName;
                    break;

                case 2:
                    System.out.println("\nEnter column names to display (separated by commas): ");
                    String columns = sc.nextLine();
                    query = "SELECT " + columns + " FROM " + tableName;
                    break;

                case 3:
                    System.out.println("\nEnter condition for selection: ");
                    String condition = sc.nextLine();
                    query = "SELECT * FROM " + tableName + " WHERE " + condition;
                    break;

                case 4:
                    System.out.println("\nEnter column names to display (separated by commas): ");
                    String selectedColumns = sc.nextLine();
                    System.out.println("\nEnter condition for selection: ");
                    String selectionCondition = sc.nextLine();
                    query = "SELECT " + selectedColumns + " FROM " + tableName + " WHERE " + selectionCondition;
                    break;

                default:
                    System.out.println("\nInvalid option. Try again.");
                    break;
            }

            // Following commented code do not give result in tabular format i.e it gives result in non-tabular format
          /*
            if (!query.isEmpty()) {
                ResultSet rs = stmt.executeQuery(query);

                ResultSetMetaData metaData = rs.getMetaData();
                int columns = metaData.getColumnCount();

                while (rs.next()) {
                    for (int i = 1; i <= columns; i++) {
                        if (i < columns) {
                            System.out.print(rs.getString(i) + " | ");
                        } else {
                            System.out.print(rs.getString(i));
                        }
                    }
                    System.out.println();
                }

                System.out.println();
            }
          */


            // Following code do give result in tabular format

            if (!query.isEmpty()) {
                try {
                    ResultSet rs = stmt.executeQuery(query);

                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    // Initialize column widths with column names lengths
                    int[] columnWidths = new int[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        columnWidths[i - 1] = columnName.length();
                    }

                    // Update column widths based on values in each row
                    while (rs.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            String columnValue = rs.getString(i);
                            if (columnValue != null) {
                                int valueLength = columnValue.length();
                                if (valueLength > columnWidths[i - 1]) {
                                    columnWidths[i - 1] = valueLength;
                                }
                            }
                        }
                    }

                    // Print column headers
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        System.out.printf("%-" + (columnWidths[i - 1] + 2) + "s", columnName);
                    }
                    System.out.println();

                    // Print separator line
                    for (int i = 1; i <= columnCount; i++) {
                        for (int j = 0; j < columnWidths[i - 1] + 2; j++) {
                            System.out.print("-");
                        }
                    }
                    System.out.println();

                    // Fetch rows again and print table rows
                    rs = stmt.executeQuery(query); // Re-execute the query
                    while (rs.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            String columnValue = rs.getString(i);
                            System.out.printf("%-" + (columnWidths[i - 1] + 2) + "s", columnValue);
                        }
                        System.out.println();
                    }

                    System.out.println();
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
