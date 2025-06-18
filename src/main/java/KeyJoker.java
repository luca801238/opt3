import Player.Player;
import Rooms.Room;

// user story 22: jokers
public class KeyJoker extends Joker{
    @Override
    public void useJoker(Player player) {
        Room room = player.getCurrentRoom();

        if (!room.acceptsKeyJoker()) {
            System.out.println("De Key Joker werkt hier niet.");
            return;
        }

        System.out.println("-1 Key Joker");
        player.giveKey();
        player.removeKeyJoker();
    }
}