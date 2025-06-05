package Observers;

import java.util.ArrayList;
import java.util.List;

public class AntwoordChecker implements AntwoordSubject {
    private List<AntwoordObserver> observers = new ArrayList<>();

    public void controleerAntwoord(String antwoord) {
        boolean juist = antwoord.equals("het juiste antwoord"); // Pas aan op jullie game
        notifyObservers(juist);
    }

    public void voegObserverToe(AntwoordObserver observer) {
        observers.add(observer);
    }

    public void verwijderObserver(AntwoordObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(boolean juistAntwoord) {
        for (AntwoordObserver observer : observers) {
            observer.update(juistAntwoord);
        }
    }
}
