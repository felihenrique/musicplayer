package data;

public class Loader {
    private Loader() { }
    private static Loader instance;
    public static Loader getInstance() {
        if(instance == null) {
            instance = new Loader();
        }
        return instance;
    }

    public User loadUser(String path) {
        return new User("");
    }
}
