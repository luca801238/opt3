package Observers;

import Rooms.Room;

public class MonsterObserver implements spelObserver {
    private Room room;
    private boolean gezien = false;
    private boolean heeftEffect = false;

    public MonsterObserver(Room room) {
        this.room = room;
    }

    public void setRoom(Room room) {
        this.room = room;
        this.gezien = false;
        this.heeftEffect = false;
    }

    public boolean heeftEffect() {
        return heeftEffect;
    }


    @Override
    public void update(boolean correct) {
        if (room != null && room.getMonster() != null) {
            if (!correct) {
                if (!gezien) {
                    room.getMonster().showMonster();
                    gezien = true;
                }
                heeftEffect = true;
                // laat monster zichtbaar
            } else {
                room.getMonster().hideMonster();
                gezien = false;
                heeftEffect = false;
            }
        }
    }


}