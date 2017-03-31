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
        mapArea.connectRooms(mapArea.getRoomsInArea().get(0), mapArea.getRoomsInArea().get(1));
        mapArea.connectRooms(mapArea.getRoomsInArea().get(1), mapArea.getRoomsInArea().get(2));
        // Create a new player starting in room 1
        Player player = new Player(mapArea.getRoomsInArea().get(0));
        System.out.println("The Player is currently in: " + player.getCurrentMapRoom().getRoomName());
        System.out.println("The index for this room is: " + player.getCurrentMapRoom().getRoomIndex());
        System.out.println("The entry text for the current room is:");
        System.out.println(player.getCurrentMapRoom().getRoomEntryText());

        System.out.println("\nRoom 1 is connected to Room 2: " + mapArea.getAreaAdjacencyList().isConnected(0, 1));
        System.out.println("Room 2 is connected to Room 3: " + mapArea.getAreaAdjacencyList().isConnected(1, 2));
        System.out.println("Room 1 is connected to Room 3: " + mapArea.getAreaAdjacencyList().isConnected(0, 2));

        // Test moving around rooms
        player.movePlayerToMapRoom(mapArea.getRoomsInArea().get(1));
        player.movePlayerToMapRoom(mapArea.getRoomsInArea().get(2));
        player.movePlayerToMapRoom(mapArea.getRoomsInArea().get(0)); // This should fail, room 3 isn't connected to 1
    }
}
