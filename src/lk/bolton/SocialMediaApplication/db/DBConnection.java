//package lk.bolton.SocialMediaApplication.db;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBConnection {
//    private static DBConnection dbConnection;
//    private Connection connection;
//
//    private DBConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tileshop", "root", "1234");
//
//    }
//
//    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
//        if (dbConnection == null) {
//            dbConnection = new DBConnection();
//        }
//        return dbConnection;
//    }
//    public Connection getConnection(){
//        return this.connection;
//    }
//}


package lk.bolton.SocialMediaApplication.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
    private static Connection connection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia", "root", "1234");
    }

    private static class SingletonHelper {
        private static final DBConnection INSTANCE;

        static {
            try {
                INSTANCE = new DBConnection();
            } catch (ClassNotFoundException | SQLException e) {
                throw new ExceptionInInitializerError(e);
            }
        }
    }

    public static DBConnection getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialmedia", "root", "1234");
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Failed to close the database connection: " + e.getMessage());
        }
    }
}

