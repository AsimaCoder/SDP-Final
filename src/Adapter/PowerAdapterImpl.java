package Adapter;

import Factory.Character;
// Adapter implementation
public class PowerAdapterImpl implements PowerAdapter {
    private final Character character;


    // Takes any character
    public PowerAdapterImpl(Character character) {
        this.character = character;
    }


    // Uses their power
    @Override
    public void usePower() {
        System.out.println("---------------------------------------------------------");
        character.performAttack();
    }
}