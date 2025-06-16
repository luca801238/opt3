package Observers;

import Rooms.Room;

public class MonsterObserver implements spelObserver {
    private final Room room;

    public MonsterObserver(Room room) {
        this.room = room;
    }

    @Override
    public void update(boolean juist) {
        if (juist) {
            System.out.println("✅ Monster is verdwenen.");
            room.getMonster().hideMonster();
        } else {
            System.out.println("❗ Er verschijnt een monster!");
            room.getMonster().showMonster();
        }
    }
}
