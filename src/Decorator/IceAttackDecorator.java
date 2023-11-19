package Decorator;

import Strategy.AttackStrategy;

public class IceAttackDecorator implements AttackDecorator {

    private final AttackStrategy decoratedStrategy;

    public IceAttackDecorator(AttackStrategy decoratedStrategy) {
        this.decoratedStrategy = decoratedStrategy;
    }

    // Decorate any attack with ice ability
    @Override
    public void rangeOfAttack() {
        decoratedStrategy.rangeOfAttack();
        System.out.println("---------------------------------------------------------");
        System.out.println("Adds ice damage!");
    }
}
