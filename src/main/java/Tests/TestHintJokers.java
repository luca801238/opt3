package Tests;

public class TestHintJokers {

    public static void main(String[] args) {

        int maxHints = 3;

        assert !isHintAantalGeldig(-1, maxHints) : "-1 hints mag niet";
        assert isHintAantalGeldig(2, maxHints) : "2 is geldig";
        assert isHintAantalGeldig(3, maxHints) : "3 hints is de grens";
        assert !isHintAantalGeldig(4, maxHints) : "4 of meer hints is te veel";

        System.out.println("Alle hint randwaardetests geslaagd.");
    }

    public static boolean isHintAantalGeldig(int aantal, int max) {
        return aantal >= 0 && aantal <= max;
    }
}
