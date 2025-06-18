import Observers.MonsterState;
import Player.Player;
import Items.Usable;
import Items.Weapon;

//user story 21
public class Zwaard implements Usable, Weapon {
    private boolean used = false;

    @Override
    public void use(Player player) {
        attack(player);
    }

    @Override
    public void attack(Player player) {
        if (used) {
            System.out.println("Je hebt het zwaard al gebruikt.");
            return;
        }
        if (player.getHasMonster()) {
            System.out.println("Je hebt het zwaard gebruikt om het monster te verslaan!");
            player.setHasMonster(false);
            MonsterState.resetActief();
            player.addCompletedRoom();
            used = true;
        } else {
            System.out.println("Er is geen monster actief.");
        }
    }
}