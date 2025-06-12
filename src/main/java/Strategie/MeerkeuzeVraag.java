package Strategie;

public class MeerkeuzeVraag implements VraagStrategie {
    private final String vraag;
    private final String[] opties;
    private final String correcteAntwoord;

    public MeerkeuzeVraag(String vraag, String[] opties, String correcteAntwoord) {
        this.vraag = vraag;
        this.opties = opties;
        this.correcteAntwoord = correcteAntwoord;
    }

    @Override
    public void startOpdracht() {
        System.out.println(vraag);
        char label = 'A';
        for (String optie : opties) {
            System.out.println(label + ": " + optie);
            label++;
        }
    }

    @Override
    public boolean checkAntwoord(String input) {
        return input.trim().equalsIgnoreCase(correcteAntwoord);
    }
}
