package Observers;

public class Status implements spelObserver {
    private int score = 0;
    private MonsterObserver monsterObserver;

    public Status(MonsterObserver monsterObserver) {
        this.monsterObserver = this.monsterObserver;
    }

    @Override
    public void update(boolean juist) {
        if (juist) {
            if (monsterObserver != null && monsterObserver.isVisible()) {
                score += 5;
                System.out.println("Monster zichtbaar! Halve score. Huidige score: " + score);
            } else {
                score += 10;
                System.out.println("Score verhoogd! Huidige score: " + score);
            }
        } else {
            System.out.println("Fout antwoord! Score blijft: " + score);
        }
    }
}
