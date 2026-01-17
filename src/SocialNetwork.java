import java.util.ArrayList;
import java.util.List;

public abstract class SocialNetwork {

    protected List<User> users = new ArrayList<>();
    protected List<Post> posts = new ArrayList<>();

    public User login(String login, String password, UserRepository repo) {
        User u = repo.find(login);
        if (u == null) return null;
        if (!u.getPassword().equals(password)) return null;
        users.add(u);
        return u;
    }

    public User register(String login, String password, UserRepository repo) {
        if (repo.find(login) != null) return null;
        User u = new User(login, password);
        repo.save(u);
        users.add(u);
        return u;
    }

    public void addPost(String text, User u) {
        posts.add(new Post(text, u));
    }

    public void showPosts(User u) {
        for (Post p : posts) {
            if (p.getOwner() == u) {
                System.out.println(p);
            }
        }
    }
}
