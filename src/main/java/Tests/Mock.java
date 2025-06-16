package Tests;

import Rooms.Monster;

public class Mock {

    // user story 26: mock
    static class ActionMock implements Monster.Action {
        String receivedName = null;
        boolean isExecuted = false;
        int timesExecuted = 0;
        boolean isHidden = false;
        int timesHidden = 0;

        @Override
        public void execute(String name) {
            isExecuted = true;
            receivedName = name;
            timesExecuted++;
        }

        @Override
        public void hide(String name) {
            isHidden = true;
            receivedName = name;
            timesHidden++;
        }
    }

    // user story 26: mock
    public static void main(String[] args) {
        ActionMock mock = new ActionMock();
        Rooms.Monster monster = new Rooms.Monster("Draak", mock);

        monster.showMonster();

        if (mock.isExecuted &&
                "Draak".equals(mock.receivedName) &&
                mock.timesExecuted == 1) {

            System.out.println("✅ Test geslaagd: methode is 1x aangeroepen met juiste naam");
        } else {
            System.out.println("❌ Test gefaald");
        }

        monster.hideMonster();

        if (mock.isHidden &&
                "Draak".equals(mock.receivedName) &&
                mock.timesHidden == 1) {
            System.out.println("✅ Test geslaagd: hideMonster methode is 1x aangeroepen met juiste naam");
        } else {
            System.out.println("❌ Test gefaald voor hideMonster");
        }
    }
}
