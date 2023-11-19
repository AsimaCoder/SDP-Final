package Observer;

// Concrete Observer
public class ConsoleObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("\"" + message + "\" has been run the game.");
    }
}