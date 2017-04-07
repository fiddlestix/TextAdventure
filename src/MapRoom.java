import java.util.ArrayList;

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
 * MapRoom.java
 * A class for a single room on the map, containing loot, enemies, etc...
 */

class MapRoom {
    // ******************
    // ***** Fields *****
    // ******************
    private static int roomIndexCounter = 0;
    private Integer roomIndex;
    private String roomName;
    private String roomEntryText;
    private ArrayList<MapRoom> connectedMapRooms;

    // ************************
    // ***** Constructors *****
    // ************************
    MapRoom() {
        this.roomIndex = roomIndexCounter++;
        this.roomName = "Default room name";
        this.roomEntryText = "Default text on entering a room.";
        this.connectedMapRooms = new ArrayList<>(10); // 10 for each direction:
        // N, NE, E, SE, S, SW, W, NW, UP, DOWN
        setConnectedMapRoomsToNull();
    }

    MapRoom(String newRoomName, String newRoomEntryText) {
        this.roomIndex = roomIndexCounter;
        roomIndexCounter++;
        this.roomName = newRoomName;
        this.roomEntryText = newRoomEntryText;
        this.connectedMapRooms = new ArrayList<>(10);
        setConnectedMapRoomsToNull();
    }

    // *******************************
    // ***** Getters and Setters *****
    // *******************************
    String getRoomEntryText() {
        return this.roomEntryText;
    }

    String getRoomName() {
        return this.roomName;
    }

    Integer getRoomIndex() {
        return this.roomIndex;
    }

    ArrayList<MapRoom> getConnectedMapRooms() {
        return this.connectedMapRooms;
    }

    private void setConnectedMapRoomsToNull() {
        for (int i = 0; i < 10; i++) {
            this.connectedMapRooms.add(i, null);
        }

    }
}
