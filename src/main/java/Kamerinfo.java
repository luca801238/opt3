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
        System.out.println("Informatie over kamer: " + room.getName());
        System.out.println("Assistent beschikbaar: " + room.hasAssistent());
        System.out.println("Accepteert KeyJoker: " + room.acceptsKeyJoker());
        System.out.println("Gebruik het commando: 'gebruik zwaard', om een zwaard te gebruiken en het monster te verslaan als het verschijnt!");
    }
}

//user story 21