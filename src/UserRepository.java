import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository {

    public User find(String login) {
        String sql = "SELECT * FROM public.users WHERE login = ?";

        try (Connection c = DatabaseConnection.get();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                User u = new User(
                        rs.getString("login"),
                        rs.getString("password")
                );
                u.setVerified(rs.getBoolean("verified"));
                return u;
            }

        } catch (Exception e) {
            return null;
        }

        return null;
    }

    public void save(User u) {
        String sql =
                "INSERT INTO public.users(login, password, verified) VALUES (?, ?, ?)";

        try (Connection c = DatabaseConnection.get();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, u.getLogin());
            ps.setString(2, u.getPassword());
            ps.setBoolean(3, u.isVerified());
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
