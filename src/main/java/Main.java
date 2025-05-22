public class Main {
    public static void main(String[] args) {

        System.out.println("Welkom bij Scrum Escape – De Kameruitdaging!");
        System.out.println("Typ 'status' of geef antwoorden op de opdrachten.");
        System.out.println("------------------------------------------------");

        Spel spel = new Spel();
        spel.start();
    }
}