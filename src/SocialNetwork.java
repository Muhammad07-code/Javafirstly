public class SocialNetwork {

    private String name;

    public SocialNetwork(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showNetworkName() {
        System.out.println("Social Network: " + name);
    }
}
