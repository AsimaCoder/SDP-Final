package Decorator;

import Strategy.AttackStrategy;

public class SmokeAttackDecorator implements AttackDecorator {

    private final AttackStrategy decoratedStrategy;

    public SmokeAttackDecorator(AttackStrategy decoratedStrategy) {
        this.decoratedStrategy = decoratedStrategy;
    }

    @Override
    public void rangeOfAttack() {
        decoratedStrategy.rangeOfAttack();
        System.out.println("---------------------------------------------------------");
        System.out.println("Adds smoke damage!");
    }
}
