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

        // Create map area to hold rooms
        MapArea mapArea = new MapArea();

        // Add rooms to map area
        mapArea.addRoomToArea(new MapRoom("Room 1", "You have entered Room 1."));
        mapArea.addRoomToArea(new MapRoom("Room 2", "You have entered Room 2."));
        mapArea.addRoomToArea(new MapRoom("Room 3", "You have entered Room 3."));
        mapArea.addRoomToArea(new MapRoom("Room 4", "You have entered Room 4."));
        mapArea.addRoomToArea(new MapRoom("Room 5", "You have entered Room 5."));
        mapArea.addRoomToArea(new MapRoom("Room 6", "You have entered Room 6."));

        // Connect rooms
        mapArea.connectRooms(mapArea.getRoomsInArea().get(0), mapArea.getRoomsInArea().get(1), roomConnectionDirection.DIRECTION_EAST);
        mapArea.connectRooms(mapArea.getRoomsInArea().get(1), mapArea.getRoomsInArea().get(2), roomConnectionDirection.DIRECTION_SOUTH);
        mapArea.connectRooms(mapArea.getRoomsInArea().get(2), mapArea.getRoomsInArea().get(5), roomConnectionDirection.DIRECTION_NORTHWEST);
        mapArea.connectRooms(mapArea.getRoomsInArea().get(2), mapArea.getRoomsInArea().get(3), roomConnectionDirection.DIRECTION_SOUTHWEST);
        mapArea.connectRooms(mapArea.getRoomsInArea().get(3), mapArea.getRoomsInArea().get(4), roomConnectionDirection.DIRECTION_NORTHWEST);
        mapArea.connectRooms(mapArea.getRoomsInArea().get(4), mapArea.getRoomsInArea().get(5), roomConnectionDirection.DIRECTION_NORTH);
        mapArea.connectRooms(mapArea.getRoomsInArea().get(0), mapArea.getRoomsInArea().get(5), roomConnectionDirection.DIRECTION_SOUTH);

        // Create a new player starting in room 1
        Player player = new Player(mapArea.getRoomsInArea().get(0));

        // Create a parser for handling command input
        Parser parser = new Parser(player);
        Scanner scanner = new Scanner(System.in);

        // Create game loop to wait for and capture user input
        while(true) {
            System.out.println("");
            MapRoom.printConnectedMapRooms(player.getCurrentMapRoom());
            System.out.println("");
            // Parse and execute the command entered by the user
            parser.parseCommand(scanner.nextLine());
        }
    }
}
