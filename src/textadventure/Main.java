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

class Main {

    public static void main(String[] args) {

        // Just testing some early map stuff here

        // load map from file
        MapArea mapArea = FileIO.loadMapFromFile();

        // Create a new player starting in room 1
        Player player = new Player(mapArea.getRoomsInArea().get(0));

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
                           "such as 'take key' or 'pull lever'\n");

        // Create game loop to wait for and capture user input
        while(true) {

            // Display text upon entering a room
            System.out.println("----------------------------");
            String entryText = "";
            int lineLength = 0;
            String[] entryTextWords = player.getCurrentMapRoom().getRoomEntryText().split(" ");

            for (String word : entryTextWords) {
                if (lineLength > 80) {
                    entryText = entryText + "\n" + word + " ";
                    lineLength = 0;
                } else {
                    entryText = entryText + word + " ";
                    lineLength = lineLength + word.length();
                }
            }

            System.out.println(entryText);

            // Display connected rooms to player's current room
            System.out.println("");
            MapRoom.printConnectedMapRooms(player.getCurrentMapRoom());
            System.out.println("");

            // Display items in the room
            if (!player.getCurrentMapRoom().getItemsInRoom().isEmpty()) {
                System.out.println("\nItems in room:");
                for (Item item : player.getCurrentMapRoom().getItemsInRoom()) {
                    System.out.println(item.getName());
                }
                System.out.println("");
            }
            // Parse and execute the command entered by the user
            System.out.println("----------------------------");
            Parser.parseCommand(scanner.nextLine());
        }
    }
}
