package Decorator;

import Strategy.AttackStrategy;

// Concrete decorator
public class FireAttackDecorator implements AttackDecorator {
    private final AttackStrategy decoratedStrategy;

    public FireAttackDecorator(AttackStrategy decoratedStrategy) {
        this.decoratedStrategy = decoratedStrategy;
    }

    @Override
    public void rangeOfAttack() {
        decoratedStrategy.rangeOfAttack();
        System.out.println("---------------------------------------------------------");
        System.out.println("Adds fire damage!");
    }
}