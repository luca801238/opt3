package Observers;

class Status implements spelObserver {
    private int score = 0;

    public void update(boolean goedAntwoord) {
        if (goedAntwoord) {
            score += 10;
            System.out.println("Score verhoogd! Huidige score: " + score);
        } else {
            System.out.println("Fout antwoord! Score blijft: " + score);
        }
    }
}
