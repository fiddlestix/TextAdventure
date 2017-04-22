package textadventure;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Objects;

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
    private EnumMap<roomConnectionDirection, Boolean> directionIsLocked;
    private EnumMap<roomConnectionDirection, DirectionLock> directionLockMechanism;
    private ArrayList<Item> itemsInRoom;

    // ************************
    // ***** Constructors *****
    // ************************
    MapRoom(String newRoomName, String newRoomEntryText) {
        this.roomIndex = roomIndexCounter;
        roomIndexCounter++;
        this.roomName = newRoomName;
        this.roomEntryText = newRoomEntryText;
        this.connectedMapRooms = new EnumMap<>(roomConnectionDirection.class);
        this.directionIsLocked = new EnumMap<>(roomConnectionDirection.class);
        this.directionLockMechanism = new EnumMap<>(roomConnectionDirection.class);
        setConnectedMapRoomsToNull();
        setDirectionLocksToNull();
        itemsInRoom = new ArrayList<>();
    }

    // *******************
    // ***** Methods *****
    // *******************
    static void printConnectedMapRooms(MapRoom room) {
        /*
          Prints a list to the console, of connected rooms to given room
         */
        StringBuffer stringBuffer = new StringBuffer("");
        int count = 0;
        int stopCount = 0;

        // Loop through connected map rooms to count them
        for (roomConnectionDirection direction : roomConnectionDirection.values()) {
            if (room.getConnectedMapRooms().get(direction) != null) {
                stopCount++;
            }
        }

        // Loop through connected map rooms to output in a sentence-style format.
        for (roomConnectionDirection direction : roomConnectionDirection.values()) {
            if (room.getConnectedMapRooms().get(direction) != null) {
                // If this is the first connected room, start the sentence
                if (count == 0) {
                    // Record connected room and direction
                    if (direction == roomConnectionDirection.DIRECTION_UP) {
                        stringBuffer.append("This room is connected to " + room.getConnectedMapRooms().get(direction).getRoomName() + " upstairs.");
                    } else if (direction == roomConnectionDirection.DIRECTION_DOWN) {
                        stringBuffer.append("This room is connected to " + room.getConnectedMapRooms().get(direction).getRoomName() + " downstairs.");
                    } else {
                        stringBuffer.append("This room is connected to " + room.getConnectedMapRooms().get(direction).getRoomName() +
                                " to the " + MapArea.convertDirectionToString(direction));

                    }
                    count++;
                } else if (count > 0 && count < stopCount - 1) {
                    if (direction == roomConnectionDirection.DIRECTION_UP) {
                        stringBuffer.append("\n" + room.getConnectedMapRooms().get(direction).getRoomName() + " upstairs,");
                    } else if (direction == roomConnectionDirection.DIRECTION_DOWN) {
                        stringBuffer.append("\n" + room.getConnectedMapRooms().get(direction).getRoomName() + " downstairs,");
                    } else {
                        stringBuffer.append("\n" + room.getConnectedMapRooms().get(direction).getRoomName() +
                                " to the " + MapArea.convertDirectionToString(direction) + ",");
                    }
                    count++;
                } else if (count == stopCount - 1){
                    if (direction == roomConnectionDirection.DIRECTION_UP) {
                        stringBuffer.append("\nand " + room.getConnectedMapRooms().get(direction).getRoomName() + " upstairs");
                    } else if (direction == roomConnectionDirection.DIRECTION_DOWN) {
                        stringBuffer.append("\nand " + room.getConnectedMapRooms().get(direction).getRoomName() + " downstairs");
                    } else {
                        stringBuffer.append("\nand " + room.getConnectedMapRooms().get(direction).getRoomName() +
                                " to the " + MapArea.convertDirectionToString(direction));
                    }
                }
            }
        }
        stringBuffer.append(".");
        System.out.println(stringBuffer);
    }

    boolean addLockToDirection(roomConnectionDirection direction, DirectionLock lock) {
        /*
          Adds a DirectionLock to a room's travel table. Returns true if successful and
          false if unsuccessful.
         */
        // Check if that direction is already locked
        if (!this.isLocked(direction)) {
            // Set that direction to locked, add DirectionLock object to travel table
            this.directionIsLocked.put(direction, true);
            this.directionLockMechanism.put(direction, lock);
            return true;
        } else return false;
    }

    boolean removeLockFromDirection(roomConnectionDirection direction) {
        if (this.directionIsLocked.get(direction)) {
            this.directionIsLocked.replace(direction, false);
            this.directionLockMechanism.remove(direction);
            return true;
        } else return false;
    }

    boolean isLocked(roomConnectionDirection direction) {
        return this.directionIsLocked.get(direction) != null && this.directionIsLocked.get(direction);
    }

    boolean unlock(roomConnectionDirection direction) {
        if (this.isLocked(direction)) {
            this.directionIsLocked.replace(direction, false);
            return true;
        } else return false;
    }

    DirectionLock getDirectionLock(roomConnectionDirection direction) {
        if (this.isLocked(direction)) {
            return this.directionLockMechanism.get(direction);
        }
        return null;
    }

    // *******************************
    // ***** Getters and Setters *****
    // *******************************
    String getRoomEntryText() {
        return this.roomEntryText;
    }

    private String getRoomName() {
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

    private void setDirectionLocksToNull() {
        for (roomConnectionDirection direction : directionIsLocked.keySet()) {
            directionIsLocked.put(direction, null);
        }
        for (roomConnectionDirection direction : directionLockMechanism.keySet()) {
            directionLockMechanism.put(direction, null);
        }
    }

    ArrayList<Item> getItemsInRoom() {
        return this.itemsInRoom;
    }
}
