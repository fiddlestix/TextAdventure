package textadventure;

import java.util.Scanner;
import textadventure.MapArea.roomConnectionDirection;

/**
 * Text-based Adventure Game
 *
 * A project for CMSC 495 7982
 * Trends and Projects in Computer Science
 * University of Maryland University College
 *
 * Jeff Schouw
 * Mansukh Saini
 * Lionel Rockymore
 *
 * Main.java
 * An executable class, contains main() method to start application.
 */

public class Main {

    public static void main(String[] args) {

        // Just testing some early map stuff here

        // load map from file
        MapArea mapArea = FileIO.loadMapFromFile("src/testmap.txt");

        // Create a new player starting in room 1
        Player player = new Player(mapArea.getRoomsInArea().get(0));

        // Add some weapons and armor for testing
        player.addItemToInventory(new Weapon("TestWeapon1", "First test weapon.", 5, 10, 0.5));
        player.addItemToInventory(new Weapon("TestWeapon2", "Second test weapon.", 10, 15, 0.9));
        player.addItemToInventory(new Armor("TestArmor1", "First test armor.", 3, 5));
        player.addItemToInventory(new Armor("TestArmor2", "Second test armor.", 5, 9));
        player.equipWeapon((Weapon) player.getInventory().get(0)); // equip TestWeapon1
        player.equipArmor((Armor) player.getInventory().get(1)); // equip TestArmor1

        // Add lock to first room's north connection to room 2
        player.getCurrentMapRoom().addLockToDirection(roomConnectionDirection.DIRECTION_NORTH, new Wheel());
        // Add lock to second room's northeast connection to room 3
        mapArea.getRoomsInArea().get(1).addLockToDirection(roomConnectionDirection.DIRECTION_NORTHEAST, new Lever());

        // Create a parser for handling command input
        Scanner scanner = new Scanner(System.in);
        Command.setPlayer(player);

        // Display welcome message
        System.out.println("Welcome!\nType 'help' to see all of the commands!\n" +
                           "Explore the map and interact with the world using commands\n" +
                           "such as 'take key' or 'push lever'\n");

        // Create game loop to wait for and capture user input
        while(true) {

            // Display text upon entering a room
            System.out.println("");
            System.out.println(player.getCurrentMapRoom().getRoomEntryText());

            // Display connected rooms to player's current room
            System.out.println("");
            MapRoom.printConnectedMapRooms(player.getCurrentMapRoom());
            System.out.println("");

            // Display items in the room
            System.out.println("\nItems in room:");
            for (Item item : player.getCurrentMapRoom().getItemsInRoom()) {
                System.out.println(item.getName());
            }
            System.out.println("");
            // Parse and execute the command entered by the user
            Parser.parseCommand(scanner.nextLine());
        }
    }
}
