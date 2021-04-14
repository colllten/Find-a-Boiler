public class User {

    private String username;
    private String password;
    private int birthYear;

    public User(String username, String password, int birthYear) {
        this.username = username;
        this.password = password;
        this.birthYear = birthYear;
    }

    public User() {
        this.username = null;
        this.password = null;
        this.birthYear = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String toString() {
        return String.format("Username: %s\nPassword: %s\nBirth Year: %d", getUsername(), getPassword(), getBirthYear());
    }
}
