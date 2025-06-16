package Tests;
import Rooms.Monster;
public class Stub {

    // stub van monster/actie: user story 26
    static class ActionStub implements Monster.Action {
        String receivedName = null;
        boolean isExecuted = false;
        boolean isHidden = false;

        @Override
        public void execute(String name) {
            isExecuted = true;
            receivedName = name;
        }

        @Override
        public void hide(String name) {
            isHidden = true;
            receivedName = name;
        }
    }


    // stub test: user story 26
    public static void main(String[] args) {
        ActionStub stub = new ActionStub();
        Monster monster = new Monster("Justin", stub);
        
        monster.showMonster();
        
        if (stub.isExecuted && "Justin".equals(stub.receivedName)) {
            System.out.println("Test geslaagd: actie is uitgevoerd met juiste naam");
        } else {
            System.out.println("Test gefaald: actie is niet uitgevoerd met juiste naam");
        }

        monster.hideMonster();

        if (stub.isHidden && "Justin".equals(stub.receivedName)) {
            System.out.println("Test geslaagd: hideMonster actie is uitgevoerd met juiste naam");
        } else {
            System.out.println("Test gefaald: hideMonster actie is niet uitgevoerd met juiste naam");
        }
    }
}



