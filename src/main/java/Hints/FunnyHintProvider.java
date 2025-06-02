package Hints;

// user story 20: hints
// hint type funnyhint
import Kamers.Kamer;

public class FunnyHintProvider implements HintProvider {
    @Override
    public String getHint(Kamer kamer) {
        return "Misschien helpt het om koffie te drinken!";
    }
}