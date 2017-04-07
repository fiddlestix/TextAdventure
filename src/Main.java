import java.util.ArrayList;
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

public class Main {

    public static void main(String[] args) {

        // Just testing some early map stuff here

        // Create map area to hold rooms
        MapArea mapArea = new MapArea();
        // Add rooms to map area
        mapArea.addRoomToArea(new MapRoom("Room 1", "You have entered Room 1."));
        mapArea.addRoomToArea(new MapRoom("Room 2", "You have entered Room 2."));
        mapArea.addRoomToArea(new MapRoom("Room 3", "You have entered Room 3."));
        // Connect rooms 1→2, and 2→3
        mapArea.connectRooms(mapArea.getRoomsInArea().get(0), mapArea.getRoomsInArea().get(1), MapArea.roomConnectionDirection.DIRECTION_NORTHEAST);
        mapArea.connectRooms(mapArea.getRoomsInArea().get(1), mapArea.getRoomsInArea().get(2), MapArea.roomConnectionDirection.DIRECTION_SOUTHEAST);
        // Create a new player starting in room 1
        Player player = new Player(mapArea.getRoomsInArea().get(0));
        // Create a parser for handling command input
        Parser parser = new Parser(player);
        Scanner scanner = new Scanner(System.in);



        while(true) {
            for (MapRoom room : player.getCurrentMapRoom().getConnectedMapRooms()) {
                if (room != null) {
                    System.out.println("Player's room is connected to " + room.getRoomName() +
                            " to the " + convertIndexToDirectionString(player.getCurrentMapRoom().getConnectedMapRooms().indexOf(room)));
                }
            }

            parser.parseCommand(scanner.nextLine());
        }
    }

    public static String convertIndexToDirectionString(Integer index) {
        String[] directionStrings = {"north", "south", "east", "west",
                                     "northeast", "southwest", "northwest",
                                     "southeast", "up", "down"};

        return directionStrings[index];
    }
}
