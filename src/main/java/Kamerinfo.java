import Player.Player;
import Rooms.Room;
import Items.Readable;
import Items.Usable;

//user story 21
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
    }
}