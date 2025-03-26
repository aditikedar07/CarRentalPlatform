public class LoginUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        
        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM Users WHERE email=? AND password=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                System.out.println("Login Successful! Welcome, " + rs.getString("name"));
            } else {
                System.out.println("Invalid Credentials");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}