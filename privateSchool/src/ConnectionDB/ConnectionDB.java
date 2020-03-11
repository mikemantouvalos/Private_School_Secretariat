package ConnectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {

    String URL = "jdbc:mysql://localhost:3306/privateschool?serverTimezone=UTC";
    String USER = "root";
    String Pass = "1234";
    protected Connection conn;

    public java.sql.Connection getConnection() {

        try {
            conn = DriverManager.getConnection(URL, USER, Pass);
            //System.out.println("Connection with DB Established!");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection with db failed");
        }

        return conn;
    }

    public void closeConnections(ResultSet rs, Statement stmt) {
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void closeConnections(Statement stmt) {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
