import Hints.HintFactory;
import Hints.HintProvider;
import Kamers.Kamer;

public class Assistent {
    public void gebruik(Speler speler) {
        Kamer kamer = speler.getHuidigeKamer();
        HintProvider provider = HintFactory.createHintProvider();
        String hint = provider.getHint(kamer);
        String instructie = kamer.getInstructie();
        String motivatie = kamer.getMotivatie();

        System.out.println("Assistent geactiveerd! \n");

        System.out.println("Hint: " + hint);
        System.out.println("Instructie: " + instructie);
        System.out.println("Motivatie: " + motivatie);
    }
}