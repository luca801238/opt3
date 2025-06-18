package Observers;

public class StatusObserver implements spelObserver {
    private int score = 0;

    @Override
    public void update(boolean juist) {
        if (juist) {
            if (MonsterState.isActief()) {
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