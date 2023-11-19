package Strategy;

// Concrete implementations
public class BasicAttack implements AttackStrategy {
    @Override
    public void rangeOfAttack() {
        System.out.println("Performs a Basic attack!");
    }
}