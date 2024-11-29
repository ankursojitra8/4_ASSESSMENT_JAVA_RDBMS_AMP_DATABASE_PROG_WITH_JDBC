# 4_ASSESSMENT_JAVA_RDBMS_&_AMP_DATABASE_PROG_WITH_JDBC
 
java-crud-swing-mysql/
├── README.md
├── database_schema/
│   ├── create_employee_table.sql
├── src/
│   ├── Core_Java/
│   │   └── DEMONSTRATION_OF_GUI_BASED_CRUD_OPERATIONS_WITH_JAVA_SWING.java
├── lib/
│   └── mysql-connector-java-<version>.jar
└── sql_queries/
    ├── insert_employee.sql
    ├── update_employee.sql
    ├── delete_employee.sql
    ├── search_employee.sql

# CRUD Operations with Java Swing and MySQL

## Overview
This project demonstrates CRUD (Create, Read, Update, Delete) operations on the Employee table in a MySQL database using Java Swing for the GUI.

## Table Schema
    The `employee` table schema includes the following fields:
        - `Id`: Primary key, auto-incremented
        - `FirstName`: Employee's first name
        - `LastName`: Employee's last name
        - `Email`: Employee's email
        - `Mobile`: Employee's mobile number

## Getting Started
    1. Clone this repository: `git clone <repository_url>`
    2. Set up MySQL database and execute the SQL schema provided in `database_schema/create_employee_table.sql`.
    3. Add your MySQL connector JAR file to the `lib` directory (e.g., `mysql-connector-java-<version>.jar`).
    4. Compile and run the Java program.

## How to Run
    1. Navigate to `src/Core_Java/` directory.
    2. Compile the Java file: `javac DEMONSTRATION_OF_GUI_BASED_CRUD_OPERATIONS_WITH_JAVA_SWING.java`
    3. Run the Java program: `java DEMONSTRATION_OF_GUI_BASED_CRUD_OPERATIONS_WITH_JAVA_SWING`

## SQL Queries
        - `insert_employee.sql`: Insert a new employee into the table.
        - `update_employee.sql`: Update the details of an employee.
        - `delete_employee.sql`: Delete an employee from the table.
        - `search_employee.sql`: Search for an employee by ID.

## Requirements
        - MySQL database server
        - Java JDK 8 or higher
        - MySQL Connector/J for JDBC
