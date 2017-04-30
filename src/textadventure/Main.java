package textadventure;

import java.util.Scanner;

/**
 * Executes the application and starts the game 'Just Another Day'.
 */
class Main {

    // A character limit for lines printed to the console, used to wrap lines that are too long
    private static final int WORDWRAP_LINE_LIMITER = 100;

    /**
     * main() method, executable part of application.
     */
    public static void main(String[] args) {

        // Load map from file
        MapArea mapArea = FileIO.loadMapFromFile();

        // Create a new player starting in the first room
        Player player = new Player(mapArea.getRoomsInArea().get(0));

        // Create a parser for handling command input
        Scanner scanner = new Scanner(System.in);
        Command.setPlayer(player);

        // Show welcome message
        System.out.println("'Just Another Day'\n\n" +
                           "!!! RESIZE YOUR CONSOLE WINDOW TO FIT YOUR SCREEN FOR BEST RESULTS !!!\n" +
                           "Also remember to use the 'look' (or 'l') command frequently so you don't get lost!\n\n" +
                           "In this game you must interact with the environment to solve puzzles and escape the house.\n" +
                           "Manipulate objects in the world using commands such as 'take key', 'pull lever', or 'inventory'.\n" +
                           "You can look at the room you are in by using the 'look' or 'l' commands.\n" +
                           "You can see a list of all of the commands at any time by typing 'help'.\n\n" +
                           "Move around the map by typing directional commands such as 'north' or ('n' as a shortcut) and\n" +
                           "'down'. Unlock doors by specifying the direction to unlock, like 'unlock north'. Note that the\n" +
                           "key in this room does not work on this door, and you instead must use clues from the world to progress.\n\n" +
                           "Try turning the wheel, and remember that puzzles will not always be so straightforward. There may be more than\n" +
                           "one path to take in this strange place. Some secrets are meant to stay hidden...\n\nGood luck.\n\n");

        // Create game loop to wait for and capture user input
        while(true) {

            MapRoom currentRoom = player.getCurrentMapRoom();
            boolean firstLoop = true;

            // Display text upon entering a room
            if (!currentRoom.hasRoomBeenVisited()) {

                System.out.println("---------------------------------------------------------------------------------------------------");
                if (currentRoom.getRoomEntryStoryText() != null) {

                    // Show story text
                    System.out.println(FileIO.formatTextForConsole(currentRoom.getRoomEntryStoryText(), WORDWRAP_LINE_LIMITER));
                    System.out.println("");
                    // Sleep for 2 seconds (for dramatic effect!)
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Show room description
                Command.lookAround();

                if (firstLoop) {
                    currentRoom.setRoomHasBeenVisited(true);
                    firstLoop = false;
                }
            }

            // Parse and execute the next command entered by the user
            Parser.parseCommand(scanner.nextLine());
        }
    }
}
