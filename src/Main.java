import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Instagram instagram = new Instagram(true);

        Profile rasul = new Profile("Rasul", 1500);
        Profile dikosh = new Profile("Dikosh", 4200);
        Profile ali = new Profile("Ali", 3000);
        Profile dana = new Profile("Dana", 2100);
        Profile sanzhar = new Profile("Sanzhar", 3800);

        rasul.setVerified(true);
        dikosh.setVerified(true);

        instagram.addProfile(rasul);
        instagram.addProfile(dikosh);
        instagram.addProfile(ali);
        instagram.addProfile(dana);
        instagram.addProfile(sanzhar);

        instagram.addPost(new Post("Morning post", rasul, false));
        instagram.addPost(new Post("Workout reel", rasul, true));

        instagram.addPost(new Post("Travel reel", dikosh, true));
        instagram.addPost(new Post("Coffee post", dikosh, false));

        instagram.addPost(new Post("Study post", ali, false));
        instagram.addPost(new Post("Funny reel", ali, true));

        instagram.addPost(new Post("Nature post", dana, false));
        instagram.addPost(new Post("Dance reel", dana, true));

        instagram.addPost(new Post("Coding post", sanzhar, false));
        instagram.addPost(new Post("Motivation reel", sanzhar, true));

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            instagram.showProfilesList();
            System.out.println("0. Exit");
            System.out.print("Choose profile number: ");
            choice = sc.nextInt();

            if (choice != 0) {
                Profile selected = instagram.getProfileByIndex(choice);
                if (selected != null) {
                    selected.showStatistics();
                }
            }
        } while (choice != 0);

        sc.close();
        System.out.println("Program finished.");
    }
}
