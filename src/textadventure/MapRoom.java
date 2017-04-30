package textadventure;

import java.util.ArrayList;
import java.util.EnumMap;
import textadventure.MapArea.roomConnectionDirection;

/**
 * Represents a single area in the map. Contains connections to other areas
 * of the map, a description and a piece of the story, items, locks, and puzzles.
 */
class MapRoom {
    // ******************
    // ***** Fields *****
    // ******************
    private String roomName; // A short, 1 - 2 word description for the room
    private String roomEntryText; // The description of the room, to be displayed when entering
    private String roomEntryStoryText; // The story attached to the room, to be displayed right before entering
    private EnumMap<roomConnectionDirection, MapRoom> connectedMapRooms; // A list of connected rooms
    private EnumMap<roomConnectionDirection, Boolean> directionIsLocked; // A list of booleans tracking locked directions
    private EnumMap<roomConnectionDirection, DirectionLock> directionLockMechanism; // A list of DirectionLocks for connected rooms
    private ArrayList<Item> itemsInRoom; // A list of items in the room
    private boolean roomHasBeenVisited; // A boolean tracking whether the player has already been in the room

    // ************************
    // ***** Constructors *****
    // ************************

    /**
     * Creates a room object, using the given name and description.
     * @param newRoomName The brief, 1 - 2 word description for the room.
     * @param newRoomEntryText The detailed description of the room.
     */
    MapRoom(String newRoomName, String newRoomEntryText) {
        this.roomName = newRoomName;
        this.roomEntryText = newRoomEntryText;
        this.connectedMapRooms = new EnumMap<>(roomConnectionDirection.class);
        this.directionIsLocked = new EnumMap<>(roomConnectionDirection.class);
        this.directionLockMechanism = new EnumMap<>(roomConnectionDirection.class);
        setConnectedMapRoomsToNull();
        setDirectionLocksToNull();
        this.itemsInRoom = new ArrayList<>();
        this.roomHasBeenVisited = false;
    }

    // *******************
    // ***** Methods *****
    // *******************

    /**
     * Prints a list of connected rooms to the console in a natural
     * sentence-like format.
     * @param room Room to print connected rooms for.
     */
    private static void printConnectedMapRooms(MapRoom room) {

        StringBuffer stringBuffer = new StringBuffer("");
        int count = 0;
        int stopCount = 0;

        // Loop through connected map rooms to count them
        // This is important for creating a more natural output
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
                        stringBuffer.append("This room is connected to a " + room.getConnectedMapRooms().get(direction).getRoomName() + " upstairs.");
                    } else if (direction == roomConnectionDirection.DIRECTION_DOWN) {
                        stringBuffer.append("This room is connected to a " + room.getConnectedMapRooms().get(direction).getRoomName() + " downstairs.");
                    } else {
                        stringBuffer.append("This room is connected to a " + room.getConnectedMapRooms().get(direction).getRoomName() +
                                " to the " + MapArea.convertDirectionToString(direction));

                    }
                    count++;
                } else if (count > 0 && count < stopCount - 1) {
                    if (direction == roomConnectionDirection.DIRECTION_UP) {
                        stringBuffer.append("\na " + room.getConnectedMapRooms().get(direction).getRoomName() + " upstairs,");
                    } else if (direction == roomConnectionDirection.DIRECTION_DOWN) {
                        stringBuffer.append("\na " + room.getConnectedMapRooms().get(direction).getRoomName() + " downstairs,");
                    } else {
                        stringBuffer.append("\na " + room.getConnectedMapRooms().get(direction).getRoomName() +
                                " to the " + MapArea.convertDirectionToString(direction) + ",");
                    }
                    count++;
                } else if (count == stopCount - 1){
                    if (direction == roomConnectionDirection.DIRECTION_UP) {
                        stringBuffer.append("\nand a " + room.getConnectedMapRooms().get(direction).getRoomName() + " upstairs");
                    } else if (direction == roomConnectionDirection.DIRECTION_DOWN) {
                        stringBuffer.append("\nand a " + room.getConnectedMapRooms().get(direction).getRoomName() + " downstairs");
                    } else {
                        stringBuffer.append("\nand a " + room.getConnectedMapRooms().get(direction).getRoomName() +
                                " to the " + MapArea.convertDirectionToString(direction));
                    }
                }
            }
        }
        stringBuffer.append(".");
        System.out.println(stringBuffer);
    }

    /**
     * Adds a DirectionLock to a room, in the given direction.
     * @param direction Direction to lock.
     * @param lock DirectionLock object to set in that direction.
     */
    void addLockToDirection(roomConnectionDirection direction, DirectionLock lock) {

        // Check if that direction is already locked
        if (!this.isLocked(direction)) {
            // Set that direction to locked, add DirectionLock object to travel table
            this.directionIsLocked.put(direction, true);
            this.directionLockMechanism.put(direction, lock);
        }
    }

    /**
     * Checks if a room is locked in the given direction.
     * @param direction Direction to check.
     * @return Returns true if it is locked, false if it is not.
     */
    boolean isLocked(roomConnectionDirection direction) {
        return this.directionIsLocked.get(direction) != null && this.directionIsLocked.get(direction);
    }

    /**
     * Unlocks the DirectionLock in a room for the given direction.
     * @param direction Direction to unlock.
     */
    void unlock(roomConnectionDirection direction) {
        if (this.isLocked(direction)) {
            this.directionIsLocked.replace(direction, false);
        }
    }

    /**
     * Returns the DirectionLock object for the given direction.
     * @param direction Direction to get.
     * @return The DirectionLock in the given direction.
     */
    DirectionLock getDirectionLock(roomConnectionDirection direction) {
        if (this.isLocked(direction)) {
            return this.directionLockMechanism.get(direction);
        }
        return null;
    }

    /**
     * Prints a description of the room to the console, including items in the room
     * @param room Room to show
     */
    static void lookAroundRoom(MapRoom room) {
        final int WORDWRAP_LINE_LIMITER = 100;

        System.out.println("");
        System.out.println(FileIO.formatTextForConsole(room.getRoomEntryText(), WORDWRAP_LINE_LIMITER));
        // Display connected rooms to player's current room
        System.out.println("");
        MapRoom.printConnectedMapRooms(room);
        System.out.println("");

        // Display items in the room
        if (!room.getItemsInRoom().isEmpty()) {
            System.out.println("\nItems in room:");
            for (Item item : room.getItemsInRoom()) {
                System.out.println(item.getName());
            }
            System.out.println("");
        }
    }

    // *******************************
    // ***** Getters and Setters *****
    // *******************************
    private String getRoomEntryText() {
        return this.roomEntryText;
    }

    String getRoomEntryStoryText() {
        return roomEntryStoryText;
    }

    void setRoomHasBeenVisited(boolean bool) {
        this.roomHasBeenVisited = bool;
    }

    boolean hasRoomBeenVisited() {
        return roomHasBeenVisited;
    }

    void setRoomEntryStoryText(String string) {
        this.roomEntryStoryText = string;
    }

    String getRoomName() {
        return this.roomName;
    }

    EnumMap<roomConnectionDirection, MapRoom> getConnectedMapRooms() {
        return this.connectedMapRooms;
    }

    /**
     * Sets all rooms connected to this room to null, to prevent errors with null access exceptions
     */
    private void setConnectedMapRoomsToNull() {
        for (roomConnectionDirection direction : roomConnectionDirection.values()) {
            this.connectedMapRooms.put(direction, null);
        }
    }

    /**
     * Sets all DirectionLocks in a room to null, to prevent errors with null access exceptions
     */
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
