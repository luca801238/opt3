import java.util.Scanner;

public class Spel {
    private final SpelController controller;
    private Scanner scanner;
    

    public Spel() {
        this.controller = new SpelController();
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        System.out.println("Welkom bij Scrum Escape!");
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            controller.verwerkCommando(input);
        }
    }
}