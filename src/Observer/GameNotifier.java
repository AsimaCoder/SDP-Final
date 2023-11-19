package Observer;

import java.util.ArrayList;
import java.util.List;

// Concrete Subject
public class GameNotifier implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    // Add observer

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Remove observer

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Notify Observers

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}