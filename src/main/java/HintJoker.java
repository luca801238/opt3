import Player.Player;
import Rooms.Room;
import Hints.HintFactory;
import Hints.HintProvider;


// user story 22: jokers
public class HintJoker extends Joker {
    @Override
    public void useJoker(Player player) {
        System.out.println("-1 Hint Joker");
        player.removeHintJoker();

        Room room = player.getCurrentRoom();
        HintProvider provider = HintFactory.createHintProvider();
        String hint = provider.getHint(room);

        System.out.println("Hint: " + hint);
    }
}