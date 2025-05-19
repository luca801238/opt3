public class CommandoParser {
    public static boolean isGaNaarKamer(String input) {
        return input.startsWith("ga naar kamer");
    }

    public static int extractKamernummer(String input) {
        return Integer.parseInt(input.replaceAll("\\D+", ""));
    }
}
