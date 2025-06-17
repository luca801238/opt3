// user story 1: spel starten

public class Main {
    public static void main(String[] args) {

        System.out.println("Welkom bij Scrum Escape – De Kameruitdaging!");
        System.out.println("Typ 'status' of geef antwoorden op de opdrachten.");
        System.out.println("Je kunt gebruik maken van de commandos: 'gebruik zwaard' en 'gebruik kamerinfo'");
        System.out.println("------------------------------------------------");

        Game game = new Game();
        game.start();
    }
}