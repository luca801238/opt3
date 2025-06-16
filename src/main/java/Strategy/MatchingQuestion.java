package Strategy;

public class MatchingQuestion implements QuestionStrategy {

    @Override
    public void startTask() {
        System.out.println("Koppel de juiste Scrum-termen aan hun definities:");
        System.out.println("A: Product Owner   1. Vertegenwoordigt klant");
        System.out.println("B: Scrum Master    2. Verwijdert blokkades");
        System.out.println("C: Teamlid         3. Voert werk uit");
        System.out.println("Typ bijvoorbeeld: A1 B2 C3");
    }

    @Override
    public boolean checkAnswer(String input) {
        return input.trim().replaceAll("\\s+", "").equalsIgnoreCase("A1B2C3");
    }
}
