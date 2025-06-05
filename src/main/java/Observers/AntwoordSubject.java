package Observers;

public interface AntwoordSubject {
    void voegObserverToe(AntwoordObserver observer);
    void verwijderObserver(AntwoordObserver observer);
    void notifyObservers(boolean juistAntwoord);
}
