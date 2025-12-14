public class Main {
    public static void main(String[] args) {

        SocialNetwork sn = new SocialNetwork("AITU Social");
        sn.showNetworkName();

        Profile user1 = new Profile("Muhammad", 150);
        Profile user2 = new Profile("Rasul", 200);

        Post post1 = new Post("Hello AITU!");

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(post1);

        post1.likePostByProfile(user1);
        System.out.println("After like by Muhammad: " + post1);
        post1.likePostByProfile(user2);
        System.out.println("After like by Rasul: " + post1);

        System.out.println(post1.getLikeOwners());

        if (user1.getFollowers() > user2.getFollowers()) {
            System.out.println(user1.getUsername() + " is more popular!");
        } else {
            System.out.println(user2.getUsername() + " is more popular!");
        }
    }
}