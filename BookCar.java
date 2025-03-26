public class BookCar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        System.out.print("Enter Car ID: ");
        int carId = sc.nextInt();
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        String startDate = sc.next();
        System.out.print("Enter End Date (YYYY-MM-DD): ");
        String endDate = sc.next();
        System.out.print("Enter Total Price: ");
        double totalPrice = sc.nextDouble();
        
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO Bookings (user_id, car_id, start_date, end_date, total_price, status) VALUES (?, ?, ?, ?, ?, 'pending')";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, userId);
            pst.setInt(2, carId);
            pst.setString(3, startDate);
            pst.setString(4, endDate);
            pst.setDouble(5, totalPrice);
            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("Car Booked Successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
