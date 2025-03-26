public class PaymentProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Booking ID: ");
        int bookingId = sc.nextInt();
        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();
        String transactionId = "TXN" + System.currentTimeMillis();
        
        try (Connection con = DBConnection.getConnection()) {
            String query = "INSERT INTO Payments (booking_id, user_id, amount, payment_status, transaction_id) SELECT ?, user_id, ?, 'completed', ? FROM Bookings WHERE booking_id=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, bookingId);
            pst.setDouble(2, amount);
            pst.setString(3, transactionId);
            pst.setInt(4, bookingId);
            int rows = pst.executeUpdate();
            
            if (rows > 0) {
                String updateBooking = "UPDATE Bookings SET status='confirmed' WHERE booking_id=?";
                PreparedStatement pstUpdate = con.prepareStatement(updateBooking);
                pstUpdate.setInt(1, bookingId);
                pstUpdate.executeUpdate();
                System.out.println("Payment Successful! Transaction ID: " + transactionId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
