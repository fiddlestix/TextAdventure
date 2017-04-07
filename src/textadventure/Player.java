package textadventure;

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

class Player {
    // ******************
    // ***** Fields *****
    // ******************
    private MapRoom currentMapRoom;

    // ************************
    // ***** Constructors *****
    // ************************
    Player(MapRoom startingMapRoom) {
        currentMapRoom = startingMapRoom;
        System.out.println(currentMapRoom.getRoomEntryText());
    }

    // *******************
    // ***** Methods *****
    // *******************
    boolean movePlayerToMapRoom(MapRoom newMapRoom) {
        if (this.currentMapRoom.getConnectedMapRooms().containsValue(newMapRoom)) {
            this.currentMapRoom = newMapRoom;
            System.out.println(currentMapRoom.getRoomEntryText()); // 'enter' the room, change this later!
            return true;
        } else {
            return false;
        }
    }

    // *******************************
    // ***** Getters and Setters *****
    // *******************************
    MapRoom getCurrentMapRoom() {
        return this.currentMapRoom;
    }
}
