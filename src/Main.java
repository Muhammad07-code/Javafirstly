import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Instagram ig = new Instagram();
        Profile admin = new Profile("admin", "admin");
        ig.addProfile(admin);
        Profile a = new Profile("rasul", "1234");
        Profile b = new Profile("ali", "2222");
        a.setVerified(true);
        ig.addProfile(a);
        ig.addProfile(b);
        ig.addPost(new Post("Morning post", a, false));
        ig.addPost(new Post("Workout reel", a, true));
        ig.addPost(new Post("Funny reel", b, true));
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("1 Login");
            System.out.println("2 Register");
            System.out.println("0 Exit");
            int c = sc.nextInt();
            if (c == 0) {
                sc.close();
                return;
            }

            if (c == 1) {
                System.out.print("Login: ");
                String l = sc.next();
                System.out.print("Password: ");
                String p = sc.next();
                Profile u = ig.find(l);
                if (u == null || !u.checkPassword(p)) {
                    System.out.println("Wrong");
                    continue;
                }

                if (l.equals("admin")) {
                    for(Profile pr : ig.profiles) {
                        System.out.println(pr);
                    }

                    System.out.print("Delete login: ");
                    ig.delete(sc.next());
                    continue;
                }

                while(true) {
                    System.out.println("1 My profile");
                    System.out.println("2 My posts");
                    System.out.println("3 Logout");
                    int x = sc.nextInt();
                    if (x == 3) {
                        break;
                    }

                    if (x == 1) {
                        u.show();
                    }

                    if (x == 2) {
                        for(Post pt : ig.myPosts(u)) {
                            System.out.println(pt);
                        }
                    }
                }
            }

            if (c == 2) {
                System.out.print("Login: ");
                String l = sc.next();
                System.out.print("Password: ");
                String p = sc.next();
                if (ig.find(l) != null) {
                    System.out.println("Login exists");
                } else {
                    ig.addProfile(new Profile(l, p));
                    System.out.println("Registered");
                }
            }
        }
    }
}
