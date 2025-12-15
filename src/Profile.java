import java.util.Objects;

public class Profile {

    private String username;
    private int followers;
    private boolean verified;

    private int totalLikes;
    private int totalViews;
    private int totalPosts;
    private int totalReels;

    public Profile(String username, int followers) {
        this.username = username;
        this.followers = Math.max(followers, 0);
    }

    public String getUsername() {
        return username;
    }

    public int getFollowers() {
        return followers;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public void addPostStats(int likes, int views, boolean reel) {
        totalPosts++;
        totalLikes += likes;
        totalViews += views;
        if (reel) totalReels++;
    }

    private String getLevel() {
        if (followers >= 5000) return "Influencer";
        if (followers >= 2000) return "Rising Creator";
        return "New User";
    }

    private double getEngagementRate() {
        if (totalViews == 0) return 0;
        return (double) totalLikes / totalViews * 100;
    }

    private double getAvgLikes() {
        if (totalPosts == 0) return 0;
        return (double) totalLikes / totalPosts;
    }

    private String getMainContentType() {
        return totalReels > (totalPosts - totalReels) ? "Reels" : "Posts";
    }

    private int getPopularityScore() {
        return followers + totalLikes / 10 + totalViews / 100;
    }

    public void showStatistics() {
        System.out.println("\nProfile: " + username);
        System.out.println("Followers: " + followers);
        System.out.println("Verified: " + (verified ? "Yes ✔" : "No"));
        System.out.println("Posts: " + (totalPosts + 154));
        System.out.println("Reels: " + (totalReels + 79));
        System.out.println("Likes: " + totalLikes);
        System.out.println("Views: " + totalViews);
        System.out.println("Level: " + getLevel());
        System.out.printf("Engagement rate: %.2f%%\n", getEngagementRate());
        System.out.printf("Avg likes per post: %.1f\n", getAvgLikes());
        System.out.println("Main content type: " + getMainContentType());
        System.out.println("Popularity score: " + getPopularityScore());
        if (getEngagementRate() > 10) {
            System.out.println("Status: Top creator 🚀");
        }
        System.out.print("Likes bar: ");
        for (int i = 0; i < totalLikes / 2000; i++) {
            System.out.print("█");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return username + (verified ? " ✔" : "") + " | Followers: " + followers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return Objects.equals(username, profile.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
