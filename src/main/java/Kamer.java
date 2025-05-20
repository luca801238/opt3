import java.util.ArrayList;
import java.util.List;

public abstract class Kamer implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public final void doorloopKamer() {
        startOpdracht();
        // toekomstig: invoer en checkAntwoord aanroepen
    }

    public abstract void startOpdracht();
    public abstract boolean checkAntwoord(String input);
    public abstract String getNaam();
    public abstract Monster getMonster();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(boolean juistAntwoord) {
        for (Observer o : observers) {
            o.update(juistAntwoord);
        }
    }
}