import java.util.ArrayList;
import java.util.List;

public abstract class SocialNetwork {

    protected String name;
    protected List<Profile> profiles = new ArrayList<>();
    protected List<Post> posts = new ArrayList<>();

    public SocialNetwork(String name) {
        this.name = name;
    }

    public void addProfile(Profile profile) {
        profiles.add(profile);
    }

    public void addProfile(String username, int followers) {
        profiles.add(new Profile(username, followers));
    }

    public void addPost(Post post) {
        posts.add(post);
        post.generateStats();
    }

    public void showProfilesList() {
        System.out.println("\nProfiles list:");
        for (int i = 0; i < profiles.size(); i++) {
            System.out.println((i + 1) + ". " + profiles.get(i));
        }
    }

    public Profile getProfileByIndex(int index) {
        if (index < 1 || index > profiles.size()) return null;
        return profiles.get(index - 1);
    }

    public abstract void showFeatures();
}
