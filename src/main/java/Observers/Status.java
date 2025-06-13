package Observers;

public class Status implements spelObserver {
    private int score = 0;

    @Override
    public void update(boolean juist) {
        if (juist) {
            score += 10;
            System.out.println("✅ Score verhoogd! Huidige score: " + score);
        } else {
            System.out.println("⚠️ Fout antwoord! Score blijft: " + score);
        }
    }
}
