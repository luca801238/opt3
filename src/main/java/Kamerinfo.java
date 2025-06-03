import Hints.HelpHintProvider;
import Kamers.Kamer;

public class Kamerinfo implements Voorwerp {
    @Override
    public void gebruik(Speler speler) {
        Kamer kamer = speler.getHuidigeKamer();
        System.out.println("Informatie over deze kamer: " + kamer.getNaam());
        System.out.println("Hint: " + new HelpHintProvider().getHint(kamer));
        System.out.println("Gebruik het commando: 'Gebruik zwaard', om een zwaard te gebruiken en het monster te verslaan!");
    }
}
