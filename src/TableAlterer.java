
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TableAlterer {
    private Connection conn;
    private Statement stmt;
    private Scanner sc;

    public TableAlterer(Connection conn) {
        this.conn = conn;
        this.sc = new Scanner(System.in);
    }

    public void alterTable() {
        try {
            stmt = conn.createStatement();

            System.out.println("\nEnter table name: ");
            String tableName = sc.nextLine();

            System.out.println("Select an option:");
            System.out.println("1. Add column");
            System.out.println("2. Drop column");
            System.out.println("3. Modify column data type");
            System.out.println("4. Rename column");
            System.out.println("5. Add constraint to table");
            System.out.println("6. Drop constraint from table");
            System.out.println("7. Add constraint to column");
            System.out.println("8. Drop constraint from column");

            System.out.print("\nEnter your option --->  ");
            int option = 0;
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(e);
                return;
            }

            switch (option) {
                case 1:
                    try {
                        addColumn(tableName);
                    } catch(SQLException e) {
                        System.out.println(e);
                    }
                    break;

                case 2:
                    try {
                        dropColumn(tableName);
                    } catch(SQLException e) {
                        System.out.println(e);
                    }
                    break;

                case 3:
                    try {
                        modifyColumnDataType(tableName);
                    } catch(SQLException e) {
                        System.out.println(e);
                    }
                    break;

                case 4:
                    try {
                        renameColumn(tableName);
                    } catch(SQLException e) {
                        System.out.println(e);
                    }
                    break;

                case 5:
                    try {
                        addConstraintToTable(tableName);
                    } catch(SQLException e) {
                        System.out.println(e);
                    }
                    break;

                case 6:
                    try {
                        dropConstraintFromTable(tableName);
                    } catch(SQLException e) {
                        System.out.println(e);
                    }
                    break;

                case 7:
                    try {
                        addConstraintToColumn(tableName);
                    } catch(SQLException e) {
                        System.out.println(e);
                    }
                    break;

                case 8:
                    try {
                        dropConstraintFromColumn(tableName);
                    } catch(SQLException e) {
                        System.out.println(e);
                    }
                    break;

                default:
                    System.out.println("\nInvalid option. Try again.");
                    break;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void addColumn(String tableName) throws SQLException {
        System.out.println("\nEnter column name and data type to add: ");
        String columnToAdd = sc.nextLine();
        String addColumnQuery = "ALTER TABLE " + tableName + " ADD " + columnToAdd;
        stmt.executeUpdate(addColumnQuery);
        System.out.println("Column added successfully.\n");
    }

    private void dropColumn(String tableName) throws SQLException {
        System.out.println("\nEnter column name to drop: ");
        String columnToDrop = sc.nextLine();
        String dropColumnQuery = "ALTER TABLE " + tableName + " DROP COLUMN " + columnToDrop;
        stmt.executeUpdate(dropColumnQuery);
        System.out.println("Column dropped successfully.\n");
    }

    private void modifyColumnDataType(String tableName) throws SQLException {
        System.out.println("\nEnter column name to modify: ");
        String columnToModify = sc.nextLine();
        System.out.println("\nEnter new data type: ");
        String newDataType = sc.nextLine();
        String modifyColumnQuery = "ALTER TABLE " + tableName + " MODIFY " + columnToModify + " " + newDataType;
        stmt.executeUpdate(modifyColumnQuery);
        System.out.println("Column data type modified successfully.\n");
    }

    private void renameColumn(String tableName) throws SQLException {
        System.out.println("\nEnter current column name: ");
        String currentColumnName = sc.nextLine();
        System.out.println("\nEnter new column name: ");
        String newColumnName = sc.nextLine();
        String renameColumnQuery = "ALTER TABLE " + tableName + " RENAME COLUMN " + currentColumnName + " TO " + newColumnName;
        stmt.executeUpdate(renameColumnQuery);
        System.out.println("Column renamed successfully.\n");
    }

    private void addConstraintToTable(String tableName) throws SQLException {
        System.out.println("\nEnter constraint name to add: ");
        String constraintName = sc.nextLine();
        System.out.println("Enter constraint expression: ");
        String constraintExpr = sc.nextLine();
        String query = "ALTER TABLE " + tableName + " ADD CONSTRAINT " + constraintName + " " + constraintExpr;
        stmt.executeUpdate(query);
        System.out.println("Constraint " + constraintName + " added to table " + tableName + " successfully.\n");
    }

    private void dropConstraintFromTable(String tableName) throws SQLException {
        System.out.println("\nEnter constraint name to drop: ");
        String constraintName = sc.nextLine();
        String query = "ALTER TABLE " + tableName + " DROP CONSTRAINT " + constraintName;
        stmt.executeUpdate(query);
        System.out.println("Constraint " + constraintName + " dropped from table " + tableName + " successfully.\n");
    }

    private void addConstraintToColumn(String tableName) throws SQLException {
        System.out.println("\nEnter column name on which constraint to be added: ");
        String columnName = sc.nextLine();
        System.out.println("Enter constraint expression: ");
        String constraintExpr = sc.nextLine();
        String query = "ALTER TABLE " + tableName + " MODIFY " + columnName + " " + constraintExpr;
        stmt.executeUpdate(query);
        System.out.println("Constraint added to column " + columnName + " in table " + tableName + " successfully.\n");
    }

    private void dropConstraintFromColumn(String tableName) throws SQLException {
        System.out.println("\nEnter column name from which constraint to be dropped: ");
        String columnName = sc.nextLine();
        System.out.println("Enter constraint expression (including MODIFY or DROP): ");
        String constraintExpr = sc.nextLine();
        String query = "ALTER TABLE " + tableName + " " + constraintExpr;
        stmt.executeUpdate(query);
        System.out.println("Constraint dropped from column " + columnName + " in table " + tableName + " successfully.\n");
    }

}
