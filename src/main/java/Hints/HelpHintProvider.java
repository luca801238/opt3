package Hints;

// user story 20: hints
// hint type funnyhint
import Rooms.Room;

public class HelpHintProvider implements HintProvider {
    @Override
    public String getHint(Room room) {
        String name = room.getName();

        switch (name) {
            case "Sprint Planning":
                return "100 / 20 = ?.";
            case "Scrum Board":
                return "Wie hoort niet op een scrum team?";
            case "Daily Scrum":
                return "Wat klinkt werk gerelateerd?";
            case "Sprint Review":
                return "Denk aan wie niet thuis hoort op een scrum team van de vorige vraag.";
            case "Sprint Retrospective":
                return "De volgorde is precies zoals het staat.";
            case "TIA":
                return "Het langste antwoord, is vaak de juiste.";
            default:
                return "Algemene hint: denk na over het doel van deze kamer.";
        }
    }
}
