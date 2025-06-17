package Observers;

import java.util.ArrayList;
import java.util.List;

public class AnswerController implements Subject {
    private List<spelObserver> observers = new ArrayList<>();

    @Override
    public void voegObserverToe(spelObserver ob) {
        observers.add(ob);
    }


    @Override
    public void verwerkObservers(boolean juist) {
        for (spelObserver o : observers) {
            o.update(juist);
        }
    }

    public void verwerkAntwoord(boolean juist) {
        System.out.println("Speler gaf antwoord: " + (juist ? "goed" : "fout"));
        verwerkObservers(juist);
    }

    public void verwerkAntwoordZonderMonster(boolean correct) {
        for (spelObserver observer : observers) {
            if (!(observer instanceof MonsterObserver)) {
                observer.update(correct);
            }
        }
    }
}
