import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Spel spel = new Spel();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welkom bij Scrum Escape – De Kameruitdaging!");
        System.out.println("Typ 'status' of geef antwoorden op de opdrachten.");
        System.out.println("------------------------------------------------");

        spel.getSpeler().getHuidigeKamer().startOpdracht();
        spel.setOpdrachtGestart(true);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            spel.verwerkCommando(input);
        }
    }
}
