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
 * Player.java
 * A class representing the user.
 */
public class Player {
    // ******************
    // ***** Fields *****
    // ******************
    private MapRoom currentMapRoom;

    // ************************
    // ***** Constructors *****
    // ************************
    public Player(MapRoom startingMapRoom) {
        currentMapRoom = startingMapRoom;
    }

    // *******************
    // ***** Methods *****
    // *******************
    public boolean movePlayerToMapRoom(MapRoom newMapRoom) {
        if (this.currentMapRoom.getConnectedMapRooms().contains(newMapRoom)) {
            this.currentMapRoom = newMapRoom;
            System.out.println(newMapRoom.getRoomEntryText()); // 'enter' the room, change this later!
            return true;
        } else {
            System.out.println("You cannot move there"); // change this later!
            return false;
        }
    }

    // *******************************
    // ***** Getters and Setters *****
    // *******************************
    public MapRoom getCurrentMapRoom() {
        return this.currentMapRoom;
    }
}
