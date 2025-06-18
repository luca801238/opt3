package Observers;

public class MonsterState {
    private static boolean actief = false;

    public static void setActief() {
        actief = true;
    }

    public static void resetActief() {
        actief = false;
    }

    public static boolean isActief() {
        return actief;
    }
}