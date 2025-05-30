package Hints;

public class HintFactory {
    public static HintProvider createHintProvider() {
        double number = Math.random();
        if (number > 0.5) {
            return new HelpHintProvider();
        } else {
            return new FunnyHintProvider();
        }
    }
}
