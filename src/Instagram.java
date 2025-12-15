import java.util.Objects;

public class Instagram extends SocialNetwork {

    private boolean reelsEnabled;

    public Instagram() {
        super("Instagram");
        this.reelsEnabled = true;
    }

    public Instagram(boolean reelsEnabled) {
        super("Instagram");
        this.reelsEnabled = reelsEnabled;
    }

    @Override
    public void showFeatures() {
        System.out.println("\nInstagram features:");
        System.out.println("- Profiles");
        System.out.println("- Posts");
        System.out.println("- Likes");
        System.out.println("- Views");
        if (reelsEnabled) System.out.println("- Reels");
    }

    @Override
    public String toString() {
        return "Instagram | Reels enabled: " + reelsEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instagram)) return false;
        Instagram that = (Instagram) o;
        return reelsEnabled == that.reelsEnabled;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reelsEnabled);
    }
}
