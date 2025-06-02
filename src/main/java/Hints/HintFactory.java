package Hints;

// user story 20: hints
// systeem kiest willekeurig tussen funny hint en help hint
public class HintFactory {
    public static HintProvider createHintProvider() {
        if (Math.random() > 0.5) {
            return new HelpHintProvider();
        } else {
            return new FunnyHintProvider();
        }
    }
}