import Kamers.Kamer;
import Hints.HintFactory;
import Hints.HintProvider;

public class HintJoker extends Joker {
    @Override
    public void useJoker(Speler speler) {
        System.out.println("-1 Hint Joker");
        speler.removeHintJoker();

        Kamer kamer = speler.getHuidigeKamer();
        HintProvider provider = HintFactory.createHintProvider();
        String hint = provider.getHint(kamer);

        System.out.println("Hint: " + hint);
    }
}