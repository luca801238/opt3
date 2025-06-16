import Hints.HelpHintProvider;
import Rooms.Room;

public class Kamerinfo implements Object {
    @Override
    public void use(Player player) {
        Room room = player.getCurrentRoom();
        System.out.println("Informatie over deze kamer: " + room.getName());
        System.out.println("Hint: " + new HelpHintProvider().getHint(room));
        System.out.println("Gebruik het commando: 'Gebruik zwaard', om een zwaard te gebruiken en het monster te verslaan!");
    }
}
