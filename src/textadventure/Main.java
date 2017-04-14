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
        player.addItemToInventory(new Item("TestItem1", "First test item."));
        player.addItemToInventory(new Item("TestItem2", "Second test item."));
        player.equipWeapon((Weapon) player.getInventory().get(0)); // equip TestWeapon1
        player.equipArmor((Armor) player.getInventory().get(1)); // equip TestArmor1

        // Create a parser for handling command input
        Parser parser = new Parser(player);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome!\nType 'help' to see all of the commands!\n" +
                           "Explore the map and interact with the world using commands\n" +
                           "such as 'take key' or 'equip sword'\n");


        // Create game loop to wait for and capture user input
        while(true) {
            System.out.println(player.getCurrentMapRoom().getRoomEntryText());

            System.out.println("");
            MapRoom.printConnectedMapRooms(player.getCurrentMapRoom());

            System.out.println("\nItems in room:");
            for (Item item : player.getCurrentMapRoom().getItemsInRoom()) {
                System.out.println(item.getName());
            }
            System.out.println("");
            // Parse and execute the command entered by the user
            parser.parseCommand(scanner.nextLine());
        }
    }
}
