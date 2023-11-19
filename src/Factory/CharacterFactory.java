package Factory;

public class CharacterFactory {
    public static Character createCharacter(String characterType) {
        switch (characterType.toLowerCase()) {
            case "scorpion":
                System.out.println("Created character: Scorpion.");
                System.out.println("---------------------------------------------------------");
                return new Scorpion();
            case "subzero":
                System.out.println("Created character: SubZero.");
                System.out.println("---------------------------------------------------------");
                return new SubZero();
            case "smoke":
                System.out.println("Created character: Smoke.");
                System.out.println("---------------------------------------------------------");
                return new Smoke();
            default:
                throw new IllegalArgumentException("Invalid character type. Supported types: scorpion, subzero, smoke");
        }
    }
}
