package Strategy;

public class SpecialAttack implements AttackStrategy {
    @Override
    public void rangeOfAttack() {
        System.out.println("Performs a Special attack!");
    }
}