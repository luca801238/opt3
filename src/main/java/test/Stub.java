package test;
import Kamers.Monster;
import org.junit.jupiter.api.Test;

public class Stub {

    // stub van monster/actie: user story 26
    static class ActieStub implements Monster.Actie {
        boolean isUitgevoerd = false;
        String ontvangenNaam = null;

        @Override
        public void voerUit(String naam) {
            isUitgevoerd = true;
            ontvangenNaam = naam;
        }
    }


    // stub test: user story 26
    @Test
    void stubTest() {
        ActieStub stub = new ActieStub();
        Monster monster = new Monster("Justin", stub);
        
        monster.toonMonster();
        
        if (stub.isUitgevoerd && "Justin".equals(stub.ontvangenNaam)) {
            System.out.println("Test geslaagd: actie is uitgevoerd met juiste naam");
        } else {
            System.out.println("Test gefaald: actie is niet uitgevoerd met juiste naam");
        }
    }
}



