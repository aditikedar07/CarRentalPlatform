public class InvoiceGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Booking ID: ");
        int bookingId = sc.nextInt();
        
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT b.booking_id, u.name, u.email, c.model, c.brand, b.start_date, b.end_date, b.total_price FROM Bookings b JOIN Users u ON b.user_id = u.user_id JOIN Cars c ON b.car_id = c.car_id WHERE b.booking_id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, bookingId);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                System.out.println("\n--- Invoice ---");
                System.out.println("Booking ID: " + rs.getInt("booking_id"));
                System.out.println("Customer Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Car: " + rs.getString("brand") + " " + rs.getString("model"));
                System.out.println("Rental Period: " + rs.getString("start_date") + " to " + rs.getString("end_date"));
                System.out.println("Total Price: Rs. " + rs.getDouble("total_price"));
            } else {
                System.out.println("No Booking Found with this ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
