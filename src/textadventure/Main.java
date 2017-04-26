package textadventure;

import java.util.Scanner;

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

    private static final int WORDWRAP_LINE_LIMITER = 100;

    public static void main(String[] args) {

        // Just testing some early map stuff here

        // load map from file
        MapArea mapArea = FileIO.loadMapFromFile();

        // Create a new player starting in room 1
        Player player = new Player(mapArea.getRoomsInArea().get(0));

        // Create a parser for handling command input
        Scanner scanner = new Scanner(System.in);
        Command.setPlayer(player);

        // Create game loop to wait for and capture user input
        while(true) {

            MapRoom currentRoom = player.getCurrentMapRoom();

            // Display text upon entering a room
            System.out.println("----------------------------");
            if (!currentRoom.hasRoomBeenVisited()) {
                if (currentRoom.getRoomEntryStoryText() != null) {
                    System.out.println(FileIO.formatTextForConsole(currentRoom.getRoomEntryStoryText(), WORDWRAP_LINE_LIMITER));
                    currentRoom.setRoomHasBeenVisited(true);
                    System.out.println("");
                }
            }
            System.out.println(FileIO.formatTextForConsole(currentRoom.getRoomEntryText(), WORDWRAP_LINE_LIMITER));

            // Display connected rooms to player's current room
            System.out.println("");
            MapRoom.printConnectedMapRooms(currentRoom);
            System.out.println("");

            // Display items in the room
            if (!currentRoom.getItemsInRoom().isEmpty()) {
                System.out.println("\nItems in room:");
                for (Item item : currentRoom.getItemsInRoom()) {
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
