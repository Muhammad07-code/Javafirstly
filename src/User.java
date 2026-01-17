public class User {

    private String login;
    private String password;
    private boolean verified;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.verified = false;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean v) {
        verified = v;
    }

    public void show() {
        System.out.println("Login: " + login);
        System.out.println("Verified: " + verified);
    }
}
