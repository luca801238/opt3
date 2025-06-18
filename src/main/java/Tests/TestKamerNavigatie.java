package Tests;

public class TestKamerNavigatie {

    public static void main(String[] args) {

        int totaalAantalKamers = 6;

        assert !isGeldigKamerNummer(-1, totaalAantalKamers) : "-1 mag niet geldig zijn";
        assert isGeldigKamerNummer(0, totaalAantalKamers) : "0 moet geldig zijn";
        assert isGeldigKamerNummer(3, totaalAantalKamers) : "3 moet geldig zijn";
        assert isGeldigKamerNummer(5, totaalAantalKamers) : "5 moet geldig zijn";
        assert !isGeldigKamerNummer(6, totaalAantalKamers) : "6 ligt buiten bereik";

        System.out.println("Alle kamer randwaardetests geslaagd.");
    }

    public static boolean isGeldigKamerNummer(int index, int max) {
        return index >= 0 && index < max;
    }
}