package Adapter;

import Factory.Character;
// Adapter implementation
public class PowerAdapterImpl implements PowerAdapter {
    private final Character character;

    public PowerAdapterImpl(Character character) {
        this.character = character;
    }

    @Override
    public void usePower() {
        System.out.println("---------------------------------------------------------");
        character.performAttack();
    }
}