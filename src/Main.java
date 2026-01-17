import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Instagram ig = new Instagram();
        UserRepository repo = new UserRepository();

        while (true) {
            System.out.println("1 Login");
            System.out.println("2 Register");
            System.out.println("0 Exit");
            System.out.print("Choice: ");

            int c = sc.nextInt();
            if (c == 0) break;

            if (c == 2) {
                System.out.print("Login: ");
                String l = sc.next();
                System.out.print("Password: ");
                String p = sc.next();

                User u = ig.register(l, p, repo);
                if (u == null) {
                    System.out.println("Exists");
                } else {
                    System.out.println("Registered");
                }
            }

            if (c == 1) {
                System.out.print("Login: ");
                String l = sc.next();
                System.out.print("Password: ");
                String p = sc.next();

                User u = ig.login(l, p, repo);
                if (u == null) {
                    System.out.println("Wrong");
                    continue;
                }

                while (true) {
                    System.out.println("1 Profile");
                    System.out.println("2 My posts");
                    System.out.println("3 Add post");
                    System.out.println("4 Logout");

                    int x = sc.nextInt();
                    if (x == 4) break;

                    if (x == 1) u.show();
                    if (x == 2) ig.showPosts(u);
                    if (x == 3) {
                        sc.nextLine();
                        ig.addPost(sc.nextLine(), u);
                    }
                }
            }
        }
    }
}
