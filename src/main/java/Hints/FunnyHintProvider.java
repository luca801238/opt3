package Hints;

// user story 20: hints
// hint type funnyhint
import Rooms.Room;

public class FunnyHintProvider implements HintProvider {
    @Override
    public String getHint(Room room) {
        return "Misschien helpt het om koffie te drinken!";
    }
}