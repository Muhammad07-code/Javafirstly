import java.util.Random;

public class Post {
    private String text;
    private Profile owner;
    private boolean reel;
    private int likes;
    private int views;

    public Post(String text, Profile owner, boolean reel) {
        this.text = text;
        this.owner = owner;
        this.reel = reel;
        Random r = new Random();
        this.likes = r.nextInt(500) + 1;
        this.views = r.nextInt(3000) + 1;
        owner.addStats(this.likes, this.views, reel);
    }

    public Profile getOwner() {
        return this.owner;
    }

    public String toString() {
        return this.text + (this.reel ? " [REEL]" : "") + " | likes: " + this.likes + " | views: " + this.views;
    }
}
