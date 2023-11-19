package Factory;

public class Smoke implements Character {
    @Override
    public void performAttack() {
        System.out.println("Smoke's attack: Smoke Bomb!");
    }
}