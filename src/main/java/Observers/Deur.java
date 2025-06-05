package Observers;

public class Deur implements AntwoordObserver {
    public void update(boolean juistAntwoord) {
        if (juistAntwoord) {
            System.out.println("De deur opent!");
        } else {
            System.out.println("De deur blijft gesloten.");
        }
    }
}
