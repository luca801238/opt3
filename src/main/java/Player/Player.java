package Player;

import Rooms.Room;
import java.util.*;
import Items.Usable;

public class Player {
    private Room currentRoom;
    private int roomsCompleted = 0;
    private boolean hasMonster = false;
    private String name;
    private int keys = 0;
    private int hintJokers = 0;
    private int keyJokers = 0;
    private List<Usable> inventory = new ArrayList<>();

    public void giveKey() {
        keys++;
        System.out.println("+1 Sleutel");
        System.out.println("Totaal aantal sleutels: " + keys);
    }

    public void addHintJoker () {
        hintJokers++;
        System.out.println("+1 Hint Joker");
        System.out.println("Totaal aantal Hint Jokers: " + hintJokers);
    }

    public void addKeyJoker () {
        keyJokers++;
        System.out.println("+1 Key Joker");
        System.out.println("Totaal aantal Key Jokers: " + keyJokers);
    }

    public void removeHintJoker () {
        hintJokers--;
        System.out.println("Totaal aantal Hint Jokers: " + hintJokers);
    }

    public void removeKeyJoker () {
        keyJokers--;
        System.out.println("Totaal aantal Key Jokers: " + keyJokers);
    }

    public int getHintJokers() {
        return hintJokers;
    }

    public int getKeyJokers() {
        return keyJokers;
    }

    public Player(String name) {
        this.name = name;
    }

    public List<Usable> getInventory() {
        return inventory;
    }

    public void addObject(Usable o) {
        inventory.add(o);
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void addCompletedRoom() {
        roomsCompleted++;
    }

    // user story 4: status commando voortgang
    // user story 7: positie en status (samengevoegd)
    public void status() {
        System.out.println("Je bent nu in: " + currentRoom.getName());
        System.out.println("Aantal kamers gehaald: " + roomsCompleted);
        if (hasMonster) {
            System.out.println("Je hebt een monster te verslaan!");
        } else {
            System.out.println("Geen monsters actief.");
        }
    }

    public void setHasMonster(boolean hasMonster) {
        this.hasMonster = hasMonster;
    }

    public boolean getHasMonster() {
        return hasMonster;
    }

    public String getName() {
        return name;
    }
}