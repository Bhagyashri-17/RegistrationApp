package dao;

import db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAO {
     public void createRegistration(String name, String email, String dob, String phone, String address) {
        String sql = "INSERT INTO Registration (Name, Email, DateOfBirth, PhoneNumber, Address) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, dob);
            stmt.setString(4, phone);
            stmt.setString(5, address);
            stmt.executeUpdate();
            System.out.println("Registration created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void readRegistration(int id) {
        String sql = "SELECT * FROM Registration WHERE ID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Name: " + rs.getString("Name"));
                    System.out.println("Email: " + rs.getString("Email"));
                    System.out.println("Date of Birth: " + rs.getDate("DateOfBirth"));
                    System.out.println("Phone: " + rs.getString("PhoneNumber"));
                    System.out.println("Address: " + rs.getString("Address"));
                } else {
                    System.out.println("No record found for ID: " + id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void updateEmail(int id, String newEmail) {
        String sql = "UPDATE Registration SET Email = ? WHERE ID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newEmail);
            stmt.setInt(2, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Email updated successfully.");
            } else {
                System.out.println("No record found for ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Operation
    public void deleteRegistration(int id) {
        String sql = "DELETE FROM Registration WHERE ID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Registration deleted successfully.");
            } else {
                System.out.println("No record found for ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public List<String> listRegistrations() {
        List<String> registrations = new ArrayList<>();
        String sql = "SELECT * FROM Registration";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                registrations.add("ID: " + rs.getInt("ID") + ", Name: " + rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrations;
    }
}
