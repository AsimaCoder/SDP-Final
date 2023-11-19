package Strategy;

public class AttackStrategyFactory {
    public static AttackStrategy createAttackStrategy(String attackType) {
        switch (attackType.toLowerCase()) {
            case "basic":
                return new BasicAttack();
            case "special":
                return new SpecialAttack();
            default:
                throw new IllegalArgumentException("Invalid attack type. Supported types: basic, special");
        }
    }
}
