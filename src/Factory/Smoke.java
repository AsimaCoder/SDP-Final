package Factory;

public class Smoke implements Character {

    // Smoke's attack
    @Override
    public void performAttack() {
        System.out.println("Smoke's attack: Smoke Bomb!");
    }
}