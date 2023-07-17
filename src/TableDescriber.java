
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class TableDescriber {
    private Connection conn;
    private Scanner sc;

    public TableDescriber(Connection conn) {
        this.conn = conn;
        this.sc = new Scanner(System.in);
    }

    public void describeTable() {
        try {
            System.out.println("\nEnter table name: ");
            String tableName = sc.nextLine();

            String query = "SELECT * FROM " + tableName + " WHERE ROWNUM = 1";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();

            int columnCount = metaData.getColumnCount();

            // For a table with columnCount <=3, it is throwing ArrayIndexOutOfBoundException when executed following else block.
            // Hence, to avoid that exception, we are trying to describe the table in non-tabular format by executing following if block
            if(columnCount <= 3) {
               // Following code do not give result in tabular format
                System.out.println("Columns : ");
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    System.out.printf("%s | %s(%d) | %s\n",
                                       metaData.getColumnName(i),
                                       metaData.getColumnTypeName(i),
                                       metaData.getColumnDisplaySize(i),
                                       metaData.isNullable(i) == 1 ? "Nullable" : "Not Nullable");
                }
                System.out.println();
            } else {
                // Following code do give result in tabular format

                // Calculate maximum column widths
                int[] columnWidths = new int[columnCount];
                String[] columnNames = new String[columnCount];
                String[] dataTypes = new String[columnCount];
                int[] columnSizes = new int[columnCount];
                String[] nullableInfo = new String[columnCount];

                for (int i = 1; i <= columnCount; i++) {
                    columnNames[i - 1] = metaData.getColumnName(i);
                    columnWidths[i - 1] = columnNames[i - 1].length();

                    dataTypes[i - 1] = metaData.getColumnTypeName(i);
                    if (dataTypes[i - 1].length() > columnWidths[i - 1]) {
                        columnWidths[i - 1] = dataTypes[i - 1].length();
                    }

                    columnSizes[i - 1] = metaData.getColumnDisplaySize(i);
                    if (String.valueOf(columnSizes[i - 1]).length() > columnWidths[i - 1]) {
                        columnWidths[i - 1] = String.valueOf(columnSizes[i - 1]).length();
                    }

                    nullableInfo[i - 1] = metaData.isNullable(i) == 1 ? "Nullable" : "Not Nullable";
                    if (nullableInfo[i - 1].length() > columnWidths[i - 1]) {
                        columnWidths[i - 1] = nullableInfo[i - 1].length();
                    }
                }

                // Print table header
                System.out.println("Columns:");
                System.out.printf("%-" + (columnWidths[0] + 2) + "s", "Name");
                System.out.printf("%-" + (columnWidths[1] + 2) + "s", "Data Type");
                System.out.printf("%-" + (columnWidths[2] + 2) + "s", "Size");
                System.out.printf("%-" + (columnWidths[3] + 2) + "s", "Nullable");
                System.out.println();

                // Print separator line
                for (int i = 0; i < columnCount; i++) {
                    for (int j = 0; j < columnWidths[i] + 2; j++) {
                        System.out.print("-");
                    }
                }

                System.out.println();

                // Print column information
                for (int i = 0; i < columnCount; i++) {
                    System.out.printf("%-" + (columnWidths[0] + 2) + "s", columnNames[i]);
                    System.out.printf("%-" + (columnWidths[1] + 2) + "s", dataTypes[i]);
                    System.out.printf("%-" + (columnWidths[2] + 2) + "s", columnSizes[i]);
                    System.out.printf("%-" + (columnWidths[3] + 2) + "s", nullableInfo[i]);
                    System.out.println();
                }

                System.out.println();
           }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
