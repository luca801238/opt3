package test;
import Kamers.Monster;
public class Stub {

    // stub van monster/actie: user story 26
    static class ActieStub implements Monster.Actie {
        boolean isUitgevoerd = false;
        String ontvangenNaam = null;
        boolean isVerborgen = false;

        @Override
        public void voerUit(String naam) {
            isUitgevoerd = true;
            ontvangenNaam = naam;
        }

        @Override
        public void verberg(String naam) {
            isVerborgen = true;
            ontvangenNaam = naam;
        }
    }


    // stub test: user story 26
    public static void main(String[] args) {
        ActieStub stub = new ActieStub();
        Monster monster = new Monster("Justin", stub);
        
        monster.toonMonster();
        
        if (stub.isUitgevoerd && "Justin".equals(stub.ontvangenNaam)) {
            System.out.println("Test geslaagd: actie is uitgevoerd met juiste naam");
        } else {
            System.out.println("Test gefaald: actie is niet uitgevoerd met juiste naam");
        }

        monster.verbergMonster();

        if (stub.isVerborgen && "Justin".equals(stub.ontvangenNaam)) {
            System.out.println("Test geslaagd: verbergMonster actie is uitgevoerd met juiste naam");
        } else {
            System.out.println("Test gefaald: verbergMonster actie is niet uitgevoerd met juiste naam");
        }
    }
}



