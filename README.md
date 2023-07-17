A menu-driven Java application for handling Oracle databases.

# OracleDBHandler
This project is a Java-based command-line application for interacting with an Oracle database. It provides functionalities to create tables, insert data, update records, delete records, alter table structure, display table data, and describe table structure.

- Interactive menu-driven interface for easy navigation and interaction.
- Ability to create tables and define table schema.
- Support for inserting data into tables, with options to insert into all columns or selected columns.
- Update and delete records based on user-defined conditions.
- Alter table structure by adding or dropping columns, modifying column data types, renaming columns, and adding or dropping constraints.
- Display table data in a tabular format, including options to display entire tables, selected columns, or selected rows.
- Describe table structure, including column names, data types, sizes, and nullable information.

---

## Table of Contents

- [Description](#description)
- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Description

The project is a Java-based menu-driven application that provides various functionalities for handling an Oracle database. It allows users to create tables, insert data, display tables, delete records or tables, update tables, and describe table structures. The application is designed to interact with an Oracle database using JDBC (Java Database Connectivity).

## Features

- Create tables: Users can define table structures by specifying column names and data types.
- Insert data: Users can insert records into the specified tables.
- Display tables: Users can view table data either in its entirety, specific columns, or based on selected conditions.
- Delete records: Users can delete specific records from the tables based on given conditions.
- Update tables: Users can update values in the tables based on specified conditions.
- Alter table: Users can modify the structure of existing tables by adding columns, dropping columns, modifying column data types, or renaming columns.
- Delete table: Users can delete entire tables from the database.
- Describe table: Users can view the metadata and structure of the specified table.

## Prerequisites or Technologies Used

- Java Development Kit (JDK) installed (preferably 19.0.2 or later)
- Oracle Database 11g or later installed and running
- Oracle SQL Developer or any other database management tool
- Intellij IDEA (or any Java IDE)

## Setup

1. Clone the repository or download the project files.

2. Import the project into your Java IDE (e.g., IntelliJ IDEA) by selecting the project's root directory.

3. Add the Oracle JDBC driver to the project:

   - Download the Oracle JDBC driver JAR file (e.g., ojdbc8.jar) from the Oracle website.
   - In IntelliJ IDEA, right-click on the project, select "Open Module Settings."
   - Go to "Libraries" and click on the "+" button to add a new library.
   - Choose "Java" and select the downloaded Oracle JDBC driver JAR file.
   - Apply the changes and close the dialog.

4. Update the database connection details in the `DatabaseConnection.java` file:

   - Open the `src/DatabaseConnection.java` file.
   - Modify the `url`, `user`, and `password` variables to match your Oracle database connection details.

5. Run the `OracleDatabaseMenu.java` file to start the menu-driven program:

   - Locate and run the `OracleDatabaseMenu.java` file in your Java IDE.
   - The program will connect to the Oracle database using the provided credentials.
   - You can now interact with the menu options to perform various operations on the database.
   - Follow the on-screen prompts to perform various database operations.


## Usage

The menu-driven program provides the following options:

1. Create table: Create a new table in the database by specifying the table name and column names with data types.

2. Insert data: Insert data into an existing table by specifying the table name and values to insert.

3. Display table: Display the contents of a table. You can choose to display the entire table, selected columns, or selected rows based on a condition.

4. Delete record: Delete a record from a table by specifying the table name and a condition.

5. Update table: Update a record in a table by specifying the table name, column name, new value, and condition.

6. Alter table: Alter the structure of a table. You can add or drop columns, modify column data types, or rename columns.

7. Delete table: Delete a table from the database by specifying the table name.

8. Describe table: Get the metadata information of a table, including column names, data types, and nullability.

9. Exit: Terminate the program.

Simply select the corresponding option and follow the prompts to perform the desired operation on the Oracle database.


## Contributing

Contributions are welcome! If you encounter any issues or have suggestions for improvements, please feel free to create an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

---
