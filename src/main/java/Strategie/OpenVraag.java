package Strategie;

public class OpenVraag implements VraagStrategie {
    private final String vraag;
    private final String juisteAntwoord;

    public OpenVraag(String vraag, String juisteAntwoord) {
        this.vraag = vraag;
        this.juisteAntwoord = juisteAntwoord;
    }

    @Override
    public void startOpdracht() {
        System.out.println("Vraag: " + vraag);
    }

    @Override
    public boolean checkAntwoord(String input) {
        return input.trim().equalsIgnoreCase(juisteAntwoord);
    }
}
