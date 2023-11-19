package Strategy;

// Concrete implementations
public class BasicAttack implements AttackStrategy {

    // Performs basic attack
    @Override
    public void rangeOfAttack() {
        System.out.println("Performs a Basic attack!");
    }
}