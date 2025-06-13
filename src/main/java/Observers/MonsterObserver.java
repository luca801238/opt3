package Observers;

import Kamers.Kamer;

public class MonsterObserver implements spelObserver {
    private final Kamer kamer;

    public MonsterObserver(Kamer kamer) {
        this.kamer = kamer;
    }

    @Override
    public void update(boolean juist) {
        if (juist) {
            System.out.println("✅ Monster is verdwenen.");
            kamer.getMonster().verbergMonster();
        } else {
            System.out.println("❗ Er verschijnt een monster!");
            kamer.getMonster().toonMonster();
        }
    }
}
