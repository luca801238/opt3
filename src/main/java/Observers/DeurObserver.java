package Observers;

public class DeurObserver implements spelObserver {
    @Override
    public void update(boolean juist) {
        if (juist) {
            System.out.println("De deur opent!");
        } else {
            System.out.println("De deur blijft gesloten.");
        }
    }
}
