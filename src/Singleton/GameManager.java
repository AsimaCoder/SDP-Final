package Singleton;

// Singleton class
public class GameManager {
    private static GameManager instance;
    private String userName;

    private GameManager() {
        // Private constructor to prevent instantiation
    }

    // Single instance implementation
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    // Get Username

    public String getUserName() {
        return userName;
    }

    // Set Username
    public void setUserName(String userName) {
        this.userName = userName;
    }

}