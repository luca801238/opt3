package Strategy;

public class OpenQuestion implements QuestionStrategy {
    private final String question;
    private final String correctAnswer;

    public OpenQuestion(String question, String correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void startTask() {
        System.out.println("Vraag: " + question);
    }

    @Override
    public boolean checkAnswer(String input) {
        return input.trim().equalsIgnoreCase(correctAnswer);
    }
}
