package DAO;


//import com.sun.jdi.connect.spi.Connection;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import model.Flight;
import java.sql.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author apple
 */
public class FlightDAO {
    private Connection dbConnect;
    public FlightDAO() {

        dbConnect = GetJDBCConnection();
    }
    
    public static Connection GetJDBCConnection(){
        String url = "jdbc:mysql://localhost:3306/flightdb";
        String username = "root";
        String pass = "maithanh";
        try {
      Class.forName("com.mysql.jdbc.Driver");
      return DriverManager.getConnection(url, username, pass);
    } catch(ClassNotFoundException | SQLException ex) {
      Logger.getLogger(FlightDAO.class.getName()).log(Level.SEVERE,null, ex);
    }
        return null;
    }
    public static void main(String[] args){
        Connection conn =  GetJDBCConnection();
        if (conn != null) {
            System.out.println("Thanh cong");
        }
        else {
            System.out.println("That bai");
        }
    }
    
    
    public Flight getFlightById(int flightId) {
        String query = "SELECT * FROM flight WHERE id = ?";
        try (PreparedStatement statement = dbConnect.prepareStatement(query)) {
            statement.setInt(1, flightId);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    int id = result.getInt("id");
                    String name = result.getString("name");
                    String departure = result.getString("departure");
                    String arrival = result.getString("arrival");
                    String duration = result.getString("duration");
                    
                    Flight flight = new Flight(id, name, departure, arrival, duration);
                    return flight;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public boolean updateFlight(Flight flight) {
    String query = "UPDATE flight SET name = ?, departure = ?, arrival = ?, duration = ? WHERE id = ?";
    try (PreparedStatement statement = dbConnect.prepareStatement(query)) {
        statement.setString(1, flight.getName());
        statement.setString(2, flight.getDeparture());
        statement.setString(3, flight.getArrival());
        statement.setString(4, flight.getDuration());
        statement.setInt(5, flight.getId());

        int rowsAffected = statement.executeUpdate();
        // Nếu có ít nhất một dòng bị ảnh hưởng bởi câu lệnh UPDATE, trả về true
        return rowsAffected > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}

}
