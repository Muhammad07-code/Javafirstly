import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfileRepository {
    public void save(Profile p) {
        String sql = "INSERT INTO profiles(username, followers, verified) VALUES (?, ?, ?)";

        try (
                Connection c = DatabaseConnection.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, p.getUsername());
            ps.setInt(2, p.getFollowers());
            ps.setBoolean(3, p.isVerified());
            ps.executeUpdate();
            System.out.println("Saved");
        } catch (SQLException var11) {
            System.out.println("Save error");
        }

    }

    public List<Profile> findAll() {
        List<Profile> list = new ArrayList();
        String sql = "SELECT username, followers, verified FROM profiles";

        try (
                Connection c = DatabaseConnection.getConnection();
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(sql);
        ) {
            while(rs.next()) {
                Profile p = new Profile(rs.getString("username"), rs.getInt("followers"));
                p.setVerified(rs.getBoolean("verified"));
                list.add(p);
            }
        } catch (SQLException var14) {
            System.out.println("Read error");
        }

        return list;
    }

    public void updateFollowers(String username, int followers) {
        String sql = "UPDATE profiles SET followers=? WHERE username=?";

        try (
                Connection c = DatabaseConnection.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setInt(1, followers);
            ps.setString(2, username);
            ps.executeUpdate();
            System.out.println("Updated");
        } catch (SQLException var12) {
            System.out.println("Update error");
        }

    }

    public void deleteByUsername(String username) {
        String sql = "DELETE FROM profiles WHERE username=?";

        try (
                Connection c = DatabaseConnection.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, username);
            ps.executeUpdate();
            System.out.println("Deleted");
        } catch (SQLException var11) {
            System.out.println("Delete error");
        }

    }
}
