package DDT;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DataOperations {
    static User user;
    public static int insertOperation() throws SQLException {
        int userId = 0;
        String sql = "INSERT into users values (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DataBaseConnection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, "Saba");
            stmt.setString(2, "Gogichashvili");
            stmt.setString(3, "5551515800");
            stmt.setString(4, "saba@gmail.com");
            stmt.setDate(5, Date.valueOf("2003-04-05"));
            stmt.setString(6, "password");
            stmt.executeUpdate();
            ResultSet generatedID = stmt.getGeneratedKeys();
            if(generatedID.next()){
                userId = generatedID.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userId;
    }

    public static User returnDB(int id) throws SQLException {
        String sql = "SELECT * from users where id ="+ id;
        try (Connection conn = DataBaseConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String name = rs.getString("firstName");
                String lastN = rs.getString("lastName");
                String mobileNumber = rs.getString("phone");
                String email = rs.getString("email");
                Date date = rs.getDate(("dateOfBirth"));
                String formattedDate = dateFormat.format(date);
                String password = rs.getString("password");

                user = new User(name, lastN, mobileNumber, email, formattedDate, password);


            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;

    }
    public static void delete(int id) throws SQLException{
        String delete = "Delete from users where id = ?";
        try (Connection conn = DataBaseConnection.getConnection()){
            PreparedStatement pstmt = conn.prepareStatement(delete);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
