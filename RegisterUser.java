import java.sql.*;
import java.util.Scanner;

public class RegisterUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO Users (name, email, password, phone, role) VALUES (?, ?, ?, ?, 'customer')";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.setString(4, phone);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("User Registered Successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}