public class Commands {
    public static boolean isGoToRoom(String input) {
        return input.startsWith("ga naar kamer");
    }

    public static int getRoomNumber(String input) {
        return Integer.parseInt(input.replaceAll("\\D+", ""));
    }
    public static boolean containsNumber(String input) {
        return input.matches(".*\\d.*");
    }
}