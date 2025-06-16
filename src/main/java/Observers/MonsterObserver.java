package Observers;

import Rooms.Room;

public class MonsterObserver implements spelObserver {
    private Room room;

    public MonsterObserver(Room room) {
        this.room = room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public void update(boolean correct) {
        if (room != null && room.getMonster() != null) {
            if (!correct) {
                room.getMonster().showMonster();
            } else {
                room.getMonster().hideMonster();
            }
        }
    }
}