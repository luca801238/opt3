package Strategy;

public class MultipleChoiceQuestion implements QuestionStrategy {
    private final String questions;
    private final String[] options;
    private final String correctAnswer;

    public MultipleChoiceQuestion(String questions, String[] options, String correctAnswer) {
        this.questions = questions;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void startTask() {
        System.out.println(questions);
        char label = 'A';
        for (String optie : options) {
            System.out.println(label + ": " + optie);
            label++;
        }
    }

    @Override
    public boolean checkAnswer(String input) {
        return input.trim().equalsIgnoreCase(correctAnswer);
    }
}