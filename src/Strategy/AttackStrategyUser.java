package Strategy;

import Factory.Character;

public class AttackStrategyUser {
    public static void useAttackStrategy(Character character, AttackStrategy attackStrategy) {
        System.out.println("Performance: ");
        character.performAttack();
        System.out.print("Range: ");
        attackStrategy.rangeOfAttack();
    }
}
