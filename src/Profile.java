import java.util.Objects;

public class Profile {
    private String username;
    private String login;
    private String password;
    private int followers;
    private boolean verified;
    private int posts;
    private int reels;
    private int likes;
    private int views;

    public Profile(String login, String password) {
        this.login = login;
        this.password = password;
        this.followers = 0;
    }

    public Profile(String username, int followers) {
        this.username = username;
        this.followers = followers;
    }

    public String getUsername() {
        return this.username;
    }

    public String getLogin() {
        return this.login;
    }

    public boolean checkPassword(String p) {
        return this.password.equals(p);
    }

    public int getFollowers() {
        return this.followers;
    }

    public boolean isVerified() {
        return this.verified;
    }

    public void setVerified(boolean v) {
        this.verified = v;
    }

    public void addStats(int l, int v, boolean r) {
        ++this.posts;
        this.likes += l;
        this.views += v;
        if (r) {
            ++this.reels;
        }

    }

    public void show() {
        String var10001 = this.username;
        System.out.println("User: " + var10001);
        int var1 = this.followers;
        System.out.println("Followers: " + var1);
        System.out.println("Verified: " + (this.verified ? "Yes" : "No"));
        System.out.println("Posts: " + this.posts);
        System.out.println("Reels: " + this.reels);
        System.out.println("Likes: " + this.likes);
        System.out.println("Views: " + this.views);
    }

    public String toString() {
        return this.username + " | followers: " + this.followers;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Profile)) {
            return false;
        } else {
            Profile p = (Profile)o;
            return Objects.equals(this.login, p.login);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.login});
    }
}
