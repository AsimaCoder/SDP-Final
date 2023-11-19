package Adapter;

import Factory.Character;
public class PowerAdapterFactory {
    public static void usePowerAdapter(Character character) {
        PowerAdapter powerAdapter = new PowerAdapterImpl(character);
        powerAdapter.usePower();
    }
}
