import java.sql.*;
// user story 5: database
public class PlayerDAO {

    public static void save(String name, int roomIndex) {
        try (Connection conn = Database.getConnection()) {
            String sql = "REPLACE INTO speler (naam, huidige_kamer_index) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setInt(2, roomIndex);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static int loadCurrentRoom(String name) {
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT huidige_kamer_index FROM speler WHERE naam = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("huidige_kamer_index");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
