package textadventure;

import java.util.ArrayList;
import java.util.EnumMap;
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
    private EnumMap<roomConnectionDirection, MapRoom> connectedMapRooms;
    private ArrayList<Item> itemsInRoom;

    // ************************
    // ***** Constructors *****
    // ************************
    MapRoom() {
        this.roomIndex = roomIndexCounter++;
        this.roomName = "Default room name";
        this.roomEntryText = "Default text on entering a room.";
        this.connectedMapRooms = new EnumMap<>(roomConnectionDirection.class);
        setConnectedMapRoomsToNull();
        itemsInRoom = new ArrayList<>();
    }

    MapRoom(String newRoomName, String newRoomEntryText) {
        this.roomIndex = roomIndexCounter;
        roomIndexCounter++;
        this.roomName = newRoomName;
        this.roomEntryText = newRoomEntryText;
        this.connectedMapRooms = new EnumMap<>(roomConnectionDirection.class);
        setConnectedMapRoomsToNull();
        itemsInRoom = new ArrayList<>();
    }

    // *******************
    // ***** Methods *****
    // *******************
    static void printConnectedMapRooms(MapRoom room) {
        StringBuffer stringBuffer = new StringBuffer("");
        int count = 0;
        int stopCount = 0;

        for (roomConnectionDirection direction : roomConnectionDirection.values()) {
            if (room.getConnectedMapRooms().get(direction) != null) {
                stopCount++;
            }
        }

        for (roomConnectionDirection direction : roomConnectionDirection.values()) {
            if (room.getConnectedMapRooms().get(direction) != null) {
                if (count == 0) {
                    stringBuffer.append("This room is connected to " + room.getConnectedMapRooms().get(direction).getRoomName() +
                            " to the " + MapArea.convertDirectionToString(direction));
                    count++;
                } else if (count > 0 && count < stopCount - 1) {
                    stringBuffer.append(",\n" + room.getConnectedMapRooms().get(direction).getRoomName() +
                                        " to the " + MapArea.convertDirectionToString(direction) + ",");
                    count++;
                } else if (count == stopCount - 1){
                    stringBuffer.append("\nand " + room.getConnectedMapRooms().get(direction).getRoomName() +
                            " to the " + MapArea.convertDirectionToString(direction));
                }
            }
        }
        stringBuffer.append(".");
        System.out.println(stringBuffer);
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

    EnumMap<roomConnectionDirection, MapRoom> getConnectedMapRooms() {
        return this.connectedMapRooms;
    }

    private void setConnectedMapRoomsToNull() {
        for (roomConnectionDirection direction : roomConnectionDirection.values()) {
            this.connectedMapRooms.put(direction, null);
        }
    }

    ArrayList<Item> getItemsInRoom() {
        return this.itemsInRoom;
    }
}
