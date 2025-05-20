public class Deur implements Observer {
    @Override
    public void update(boolean juistAntwoord) {
        if (juistAntwoord) {
            System.out.println("De deur is open.");
        } else {
            System.out.println("De deur is gesloten.");
        }
    }
}
// test