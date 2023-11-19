package Observer;

import Singleton.GameManager;
public class ObserverPatternEnabler {
    public static void enableObserverPattern() {

        // Create a GameNotifier and add an observer
        GameNotifier gameNotifier = new GameNotifier();
        gameNotifier.addObserver(new ConsoleObserver());
        gameNotifier.notifyObservers(GameManager.getInstance().getUserName());
        System.out.println("---------------------------------------------------------");
    }
}
