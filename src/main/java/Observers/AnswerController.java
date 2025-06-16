package Observers;

import java.util.ArrayList;
import java.util.List;

public class AnswerController {
    private List<spelObserver> observers = new ArrayList<>();

    public void voegObserverToe(spelObserver ob) {
        observers.add(ob);
    }

    public void verwijderObserver(spelObserver o) {
        observers.remove(o);
    }

    public void verwerkAntwoord(boolean juist) {
        System.out.println("Speler gaf antwoord: " + (juist ? "GOED" : "FOUT"));
        for (spelObserver o : observers) {
            o.update(juist);
        }
    }
}

