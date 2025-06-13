package test;

public class Mock {

    // user story 26: mock
    static class ActieMock implements Kamers.Monster.Actie {
        boolean isUitgevoerd = false;
        String ontvangenNaam = null;
        int aantalKeerUitgevoerd = 0;
        boolean isVerborgen = false;
        int aantalKeerVerborgen = 0;

        @Override
        public void voerUit(String naam) {
            isUitgevoerd = true;
            ontvangenNaam = naam;
            aantalKeerUitgevoerd++;
        }

        @Override
        public void verberg(String naam) {
            isVerborgen = true;
            ontvangenNaam = naam;
            aantalKeerVerborgen++;
        }
    }

    // user story 26: mock
    public static void main(String[] args) {
        ActieMock mock = new ActieMock();
        Kamers.Monster monster = new Kamers.Monster("Draak", mock);

        monster.toonMonster();

        if (mock.isUitgevoerd &&
                "Draak".equals(mock.ontvangenNaam) &&
                mock.aantalKeerUitgevoerd == 1) {

            System.out.println("✅ Test geslaagd: methode is 1x aangeroepen met juiste naam");
        } else {
            System.out.println("❌ Test gefaald");
        }

        monster.verbergMonster();

        if (mock.isVerborgen &&
                "Draak".equals(mock.ontvangenNaam) &&
                mock.aantalKeerVerborgen == 1) {
            System.out.println("✅ Test geslaagd: verbergMonster methode is 1x aangeroepen met juiste naam");
        } else {
            System.out.println("❌ Test gefaald voor verbergMonster");
        }
    }
}
