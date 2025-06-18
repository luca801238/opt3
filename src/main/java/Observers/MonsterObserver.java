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



    @Override
    public void update(boolean correct) {
        if (room != null && room.getMonster() != null) {
            if (!correct) {
                if (!gezien) {
                    room.getMonster().showMonster();
                    gezien = true;
                }
                MonsterState.setActief();

                // laat monster zichtbaar
            } else {
                room.getMonster().hideMonster();
                gezien = false;
                MonsterState.resetActief();
            }
        }
    }


}