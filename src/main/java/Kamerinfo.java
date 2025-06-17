import Hints.HelpHintProvider;
import Player.Player;
import Rooms.Room;
import items.Readable;
import items.Usable;


public class Kamerinfo implements Usable, Readable {
    @Override
    public void use(Player player) {
        showMessage(player);
    }
    @Override
    public void showMessage(Player player) {
        Room room = player.getCurrentRoom();
        System.out.println("Informatie over deze kamer: " + room.getName());
        System.out.println("Hint: " + new HelpHintProvider().getHint(room));
        System.out.println("Gebruik het commando: 'Gebruik zwaard', om een zwaard te gebruiken en het monster te verslaan!");
    }
}

//user story 21