package Hints;

// user story 20: hints
// hint type funnyhint
import Kamers.Kamer;

public class HelpHintProvider implements HintProvider {
    @Override
    public String getHint(Kamer kamer) {
        String naam = kamer.getNaam();

        switch (naam) {
            case "Sprint Planning":
                return "Denk aan het verdelen van werk in kleine stukken.";
            case "Scrum Board":
                return "Wat zijn de rollen binnen Scrum?";
            case "Daily Scrum":
                return "Wat doet een kolom 'In Progress'?";
            case "Sprint Review":
                return "Wat toon je in een Sprint Review?";
            case "Sprint Retrospective":
                return "Reflecteer op wat goed ging én wat beter kan.";
            case "TIA":
                return "Test-Impact-Analyse toont wat moet worden getest.";
            default:
                return "Algemene hint: denk na over het doel van deze kamer.";
        }
    }
}
