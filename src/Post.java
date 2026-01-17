public class Post {

    private String text;
    private User owner;

    public Post(String text, User owner) {
        this.text = text;
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return text;
    }
}
