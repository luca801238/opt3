package Observers;

import Rooms.Room;

public class MonsterObserver implements spelObserver {
    private Room room;
    private boolean gezien = false;

    public MonsterObserver(Room room) {
        this.room = room;
    }

    public void setRoom(Room room) {
        this.room = room;
        this.gezien = false;
    }


    @Override
    public void update(boolean correct) {

        if (room != null && room.getMonster() != null) {
            if (!correct && !gezien) {
                room.getMonster().showMonster();
                gezien = true;
            } else {
                room.getMonster().hideMonster();
                gezien = false;
            }
        }
    }
}