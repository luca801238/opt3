package Observers;

public interface Subject {
    void voegObserverToe(spelObserver o);
    void verwijderObserver(spelObserver o);
    void verwerkObservers(boolean juist);
}