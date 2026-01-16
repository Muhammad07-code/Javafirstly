import java.util.ArrayList;
import java.util.List;

public abstract class SocialNetwork {
    protected List<Profile> profiles = new ArrayList();
    protected List<Post> posts = new ArrayList();

    public void addProfile(Profile p) {
        this.profiles.add(p);
    }

    public void addPost(Post p) {
        this.posts.add(p);
    }

    public Profile find(String login) {
        for(Profile p : this.profiles) {
            if (p.getLogin() != null && p.getLogin().equals(login)) {
                return p;
            }
        }

        return null;
    }

    public void delete(String login) {
        this.profiles.removeIf((p) -> p.getLogin() != null && p.getLogin().equals(login));
    }

    public List<Post> myPosts(Profile u) {
        List<Post> list = new ArrayList();

        for(Post p : this.posts) {
            if (p.getOwner().equals(u)) {
                list.add(p);
            }
        }

        return list;
    }

    public abstract void showFeatures();
}
