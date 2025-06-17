import Hints.HintFactory;
import Hints.HintProvider;
import Player.Player;
import Rooms.Room;

public class Assistent {
    public void use(Player player) {
        Room room = player.getCurrentRoom();
        String hint = room.getHint();
        String instruction = room.getInstruction();
        String motivation = room.getMotivation();

        System.out.println("Assistent geactiveerd! \n");

        System.out.println("Hint: " + hint);
        System.out.println("Instructie: " + instruction);
        System.out.println("Motivatie: " + motivation);
    }
}