// user story 1: spel starten

public class Main {
    public static void main(String[] args) {

        System.out.println("Welkom bij Scrum Escape – De Kameruitdaging!");
        System.out.println("Typ 'status' of geef antwoorden op de opdrachten.");
        System.out.println("Gebruik bijvoorbeeld: 'gebruik zwaard' of 'gebruik Kamerinfo'");
        System.out.println("------------------------------------------------");

        Spel spel = new Spel();
        spel.start();
    }
}