package Observers;

public class Monsta implements AntwoordObserver {
    public void update(boolean juistAntwoord) {
        if (juistAntwoord) {
            System.out.println("Het monster verdwijnt.");
        } else {
            System.out.println("Een monster verschijnt!");
        }
    }
}
