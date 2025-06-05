package Observers;

public class StatusDisplay implements AntwoordObserver {
    public void update(boolean juistAntwoord) {
        if (juistAntwoord) {
            System.out.println("Goed gedaan! Score verhoogd.");
        } else {
            System.out.println("Fout antwoord. Let op!");
        }
    }
}
