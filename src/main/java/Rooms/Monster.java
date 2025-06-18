package Rooms;

// user story 10: monster klasse
public class Monster {
    private String name;
    private Action action;

    public interface Action {
        void execute(String name);
        void hide(String name);
    }

    private static class StandardAction implements Action {
        @Override
        public void execute(String name) {
            System.out.println("Monster verschenen: " + name);
            System.out.println("Los eerst de opdracht correct op om door te mogen!");
        }

        @Override
        public void hide(String name) {
            System.out.println("Monster " + name + " is verslagen en verdwenen!");
        }
    }

    public Monster(String name) {
        this.name = name;
        this.action = new StandardAction();
    }

    public Monster(String name, Action action) {
        this.name = name;
        this.action = action;
    }

    public void showMonster() {
        action.execute(name);
    }

    public void hideMonster() {
        action.hide(name);
    }
}