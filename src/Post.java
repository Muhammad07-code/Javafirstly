import java.util.Objects;
import java.util.Random;

public class Post {

    private String content;
    private int likes;
    private int views;
    private boolean reel;
    private Profile owner;

    public Post(String content, Profile owner, boolean reel) {
        this.content = content;
        this.owner = owner;
        this.reel = reel;
    }

    public void generateStats() {
        Random r = new Random();
        likes = r.nextInt(5000) + 1;
        views = r.nextInt(20000) + 1;
        owner.addPostStats(likes, views, reel);
    }

    @Override
    public String toString() {
        return content + (reel ? " [REEL]" : "") + " | Likes: " + likes + " | Views: " + views;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return Objects.equals(content, post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
