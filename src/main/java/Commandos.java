public class Commandos {
    public static boolean isGaNaarKamer(String input) {
        return input.startsWith("ga naar kamer");
    }

    public static int haalopKamernummer(String input) {
        return Integer.parseInt(input.replaceAll("\\D+", ""));
    }
    public static boolean bevatGetal(String input) {
        return input.matches(".*\\d.*");
    }

}