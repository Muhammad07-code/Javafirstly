import java.util.ArrayList;
import java.util.List;

public class Post {
    private String content;
    private final List<Profile> likeOwners = new ArrayList<>();


    public Post(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return this.likeOwners.size();
    }

    public void likePostByProfile(Profile profile) {
        this.likeOwners.add(profile); // 0 + 1 (Muhammad)
        //[] // [Muhammad, Rasul]
    }

    public List<Profile> getLikeOwners() {
        return this.likeOwners;
    }

    public String toString() {
        return "Post: " + content + " | Likes: " + this.likeOwners.size();
    }
}
