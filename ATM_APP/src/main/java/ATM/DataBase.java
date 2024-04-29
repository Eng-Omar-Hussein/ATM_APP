/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ATM;

/**
 *
 * @author pc2
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DataBase {

    // JDBC URL for SQL Server connection
    private static final String JDBC_URL = "jdbc:sqlserver://10.0.2.15:2024;DatabaseName=BANKSYSDB";
    // Database credentials
    private static final String USERNAME = "omar";
    private static final String PASSWORD = "hussein";

    public static String getValue(String columnName, String table, String condition) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String value = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // SQL query for searching
            String sql = "SELECT " + columnName + " FROM "+table+" WHERE " + condition;

            // Create a PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);


            // Execute the search query
            resultSet = preparedStatement.executeQuery();

            // Check if the result set contains any rows
            if (resultSet.next()) {
                // Retrieve the value from the result set
                value = resultSet.getString(columnName);
            }

        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("Failed to retrieve value. Error message: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Close resources in the finally block
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }

        return value;
    }
    public static boolean check_over_draft(int id, int fastcash){
        int x=Integer.parseInt(getValue("OverDraftLimit", "Account", "Account_NO = "+id));
        if (fastcash <= x)return true;
        return false;
    }
    public static void Deposet(int id, double inc) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        

        try {
            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // SQL query for updating
            
            String sql = "UPDATE Account SET Balance = ? WHERE Account_NO = ?;";
            

            // Create a PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);
            
            // Set parameters for the PreparedStatement
            preparedStatement.setDouble(1, inc +Double.parseDouble(getValue("Balance", "Account", "Account_NO = "+id)));
            preparedStatement.setInt(2, id);
            
            
             

            // Execute the update query
            int rowsAffected = preparedStatement.executeUpdate();
            
            System.out.println(rowsAffected + " row(s) updated successfully.");
            
            JOptionPane.showMessageDialog(null, "Updated Successfully");

        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("Failed to update data. Error message: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Close resources in the finally block
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public static void FastCash(int id, int dec) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // SQL query for updating
            
            String sql = "UPDATE Account SET Balance = ? WHERE Account_NO = ?;";
            String sql1 = "UPDATE Account SET OverDraftLimit = ? WHERE Account_NO = ?;";
            
            double balance=Double.parseDouble(getValue("Balance", "Account", "Account_NO = "+id));
            // Create a PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);
            // Set parameters for the PreparedStatement
            preparedStatement.setDouble(1, balance-dec);
            preparedStatement.setInt(2, id);
            
            // Create a PreparedStatement object
            preparedStatement1 = connection.prepareStatement(sql1);
            
            // Set parameters for the PreparedStatement
            preparedStatement1.setInt(1, (int) (Integer.parseInt(getValue("OverDraftLimit", "Account", "Account_NO = "+id))- dec));
            preparedStatement1.setInt(2, id);
            
            // Execute the update query
            int rowsAffected = preparedStatement.executeUpdate();
            int rowsAffected1 = preparedStatement1.executeUpdate();
            
            System.out.println(rowsAffected + " row(s) updated successfully.");
            System.out.println(rowsAffected1 + " row(1) updated successfully.");
            JOptionPane.showMessageDialog(null, "Updated Successfully");

        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("Failed to update data. Error message: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Close resources in the finally block
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
     public static void Change_PIN(int id, int new_PIN) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // SQL query for updating
            String sql = "UPDATE Customer SET Password = ? WHERE Customer_ID = ?";

            // Create a PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters for the PreparedStatement
            preparedStatement.setInt(1, new_PIN);
            preparedStatement.setInt(2, id);

            // Execute the update query
            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " row(s) updated successfully.");
            JOptionPane.showMessageDialog(null, "Updated Successfully");

        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("Failed to update data. Error message: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Close resources in the finally block
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
     
    // Method to insert data into the database
    public static void insertData(String name, int age) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // SQL query for insertion
            String sql = "INSERT INTO your_table_name (name, age) VALUES (?, ?)";

            // Create a PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters for the PreparedStatement
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);

            // Execute the insertion query
            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " row(s) inserted successfully.");

        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("Failed to insert data. Error message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources in the finally block
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    

    // Method to search data in the database
    public static void searchData(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // SQL query for searching
            String sql = "SELECT * FROM your_table_name WHERE name = ?";

            // Create a PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);

            // Set parameter for the PreparedStatement
            preparedStatement.setString(1, name);

            // Execute the search query
            resultSet = preparedStatement.executeQuery();

            // Process the results
            while (resultSet.next()) {
                // Retrieve data from the result set and print or process it
                // Example: int id = resultSet.getInt("id");
                // Example: int age = resultSet.getInt("age");
                System.out.println("Name: " + resultSet.getString("name") + ", Age: " + resultSet.getInt("age"));
            }

        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("Failed to search data. Error message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources in the finally block
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    // Method to update data in the database
    public static void updateData(String name, int newAge) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // SQL query for updating
            String sql = "UPDATE your_table_name SET age = ? WHERE name = ?";

            // Create a PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);

            // Set parameters for the PreparedStatement
            preparedStatement.setInt(1, newAge);
            preparedStatement.setString(2, name);

            // Execute the update query
            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " row(s) updated successfully.");

        } catch (SQLException e) {
            // Handle SQL exceptions
            System.err.println("Failed to update data. Error message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close resources in the finally block
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Test the insert, search, and update methods
        insertData("John", 30); // Inserting data
        searchData("John");     // Searching data
        updateData("John", 35); // Updating data
    }
}

