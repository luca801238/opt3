package Hints;

import Rooms.Room;
// user story 20: hints
public interface HintProvider {
    String getHint(Room room);
}