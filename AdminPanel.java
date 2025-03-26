import java.sql.*;
import java.util.Scanner;

public class AdminPanel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nAdmin Panel: ");
            System.out.println("1. Add Car");
            System.out.println("2. View All Cars");
            System.out.println("3. Delete Car");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    addCar();
                    break;
                case 2:
                    viewCars();
                    break;
                case 3:
                    deleteCar();
                    break;
                case 4:
                    System.out.println("Exiting Admin Panel...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
    
    public static void addCar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Model: ");
        String model = sc.nextLine();
        System.out.print("Enter Brand: ");
        String brand = sc.nextLine();
        System.out.print("Enter Year: ");
        int year = sc.nextInt();
        System.out.print("Enter Price per Day: ");
        double price = sc.nextDouble();
        
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO Cars (model, brand, year, price_per_day, available) VALUES (?, ?, ?, ?, TRUE)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, model);
            pst.setString(2, brand);
            pst.setInt(3, year);
            pst.setDouble(4, price);
            pst.executeUpdate();
            System.out.println("Car Added Successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void viewCars() {
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM Cars";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println("Car ID: " + rs.getInt("car_id") + ", Model: " + rs.getString("model") + ", Brand: " + rs.getString("brand") + ", Year: " + rs.getInt("year") + ", Price: Rs." + rs.getDouble("price_per_day"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteCar() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Car ID to Delete: ");
        int carId = sc.nextInt();
        
        try (Connection con = DBConnection.getConnection()) {
            String query = "DELETE FROM Cars WHERE car_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, carId);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("Car Deleted Successfully!");
            } else {
                System.out.println("Car ID Not Found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}