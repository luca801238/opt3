import java.sql.*;

public class SpelerDAO {

    public static void slaOp(String naam, int kamerIndex) {
        try (Connection conn = Database.getConnection()) {
            String sql = "REPLACE INTO speler (naam, huidige_kamer_index) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, naam);
            stmt.setInt(2, kamerIndex);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static int laadHuidigeKamer(String naam) {
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT huidige_kamer_index FROM speler WHERE naam = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, naam);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("huidige_kamer_index");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int laadKamersGehaald(String naam) {
        try (Connection conn = Database.getConnection()) {
            String sql = "SELECT kamers_gehaald FROM speler WHERE naam = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, naam);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("kamers_gehaald");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
