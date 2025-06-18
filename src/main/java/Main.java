// user story 1: spel starten

public class Main {
    public static void main(String[] args) {

        System.out.println("Welkom bij Scrum Escape – De Kameruitdaging! \n");
        System.out.println("UITLEG");
        System.out.println("Het spel bestaat uit in totaal 6 kamers.");
        System.out.println("Doel van het spel is om door al deze kamers heen te komen.");
        System.out.println("Dit doe je door in elke kamer een vraag te beantwoorden.");
        System.out.println("Ook krijg je punten bij het juist beantwoorden van de vragen.");
        System.out.println("Bij een goed antwoord gaat de deur open en mag je doorgaan naar de volgende kamer.");
        System.out.println("Bij een fout antwoord verschijnt een monster, deze kun je verslaan door gebruik te maken van je zwaard om toch alle punten te krijgen");
        System.out.println("of door de vraag nog een keer juist te beantwoorden maar dan krijg je niet alle punten, je kunt hierbij gebruik maken van hints als je deze hebt.");
        System.out.println("In sommige kamers is het ook mogelijk om gebruik te maken van een assistent, deze geeft je een hint, een instructie en motivatie.");
        System.out.println("Aan het begin van het spel krijg je de keauze tussen twee verschillende soorten Jokers. \n");
        System.out.println("COMMANDOS");
        System.out.println("'status' - Laat je huidige kamer zien, het aantal kamers dat je hebt gehaald en of er een monster actief is.");
        System.out.println("'gebruik zwaard' - hiermee kan je een monster verslaan. (Let op, deze krijg je maar 1 keer, ook al reset je de game).");
        System.out.println("'gebruik kamerinfo' - informatie over je huidige kamer: of de assistent beschikbaar is en of je gebruik kunt maken van de Key Joker.");
        System.out.println("------------------------------------------------");

        Game game = new Game();
        game.start();
    }
}