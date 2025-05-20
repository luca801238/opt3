public class Status implements Observer {
    @Override
    public void update(boolean juistAntwoord) {
        if (juistAntwoord) {
            System.out.println("Status: Goed antwoord!");
        } else {
            System.out.println("Status: Fout antwoord. Probeer opnieuw.");
        }
    }
}