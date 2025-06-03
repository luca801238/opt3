import Kamers.Kamer;

public class KeyJoker extends Joker{
    @Override
    public void useJoker(Speler speler) {
        Kamer kamer = speler.getHuidigeKamer();

        if (!kamer.accepteertKeyJoker()) {
            System.out.println("De Key Joker werkt hier niet.");
            return;
        }

        System.out.println("-1 Key Joker");
        speler.giveKey();
        speler.removeKeyJoker();

    }
}