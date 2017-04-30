package textadventure;

import java.util.ArrayList;

/**
 * Represents a collection of connected rooms. Rooms are represented in
 * a graph as an adajacency list, corresponding to directional connections
 * such as 'north', 'northeast', or 'up'.
 */
class MapArea {

    // ******************
    // ***** Fields *****
    // ******************
    private ArrayList<MapRoom> roomsInArea;

    /**
     * This enum data structure is used to track the direction of room connections.
     */
    enum roomConnectionDirection {
        DIRECTION_NORTH,
        DIRECTION_SOUTH,
        DIRECTION_EAST,
        DIRECTION_WEST,
        DIRECTION_NORTHEAST,
        DIRECTION_SOUTHWEST,
        DIRECTION_NORTHWEST,
        DIRECTION_SOUTHEAST,
        DIRECTION_UP,
        DIRECTION_DOWN
    }

    // ************************
    // ***** Constructor *****
    // ************************

    /**
     * Creates a blank map to add rooms and connections to.
     */
    MapArea() {
        this.roomsInArea = new ArrayList<>();
    }

    // *******************
    // ***** Methods *****
    // *******************

    /**
     * Adds a room to a map object.
     * @param newRoom The new room to add.
     */
    void addRoomToArea(MapRoom newRoom) {
        this.getRoomsInArea().add(newRoom);
    }

    /**
     * Connects two rooms in a map, according to the direction given.
     * The direction is for the first room's connection to the second room,
     * so the second room's connection to the first room will be the opposite
     * direction.
     * @param firstRoom First room to connect.
     * @param secondRoom Second room to connect.
     * @param direction Direction for connection from first room to second room.
     */
    void connectRooms(MapRoom firstRoom, MapRoom secondRoom, roomConnectionDirection direction) {
        // returns true if successful, false if failed
        if (this.getRoomsInArea().contains(firstRoom) && this.getRoomsInArea().contains(secondRoom)) {
            firstRoom.getConnectedMapRooms().replace(direction, secondRoom);
            secondRoom.getConnectedMapRooms().replace(getOppositeDirection(direction), firstRoom);
        }
    }

    /**
     * Converts a connection direction to a lowercase string.
     * @param direction Direction to convert.
     * @return String representation of given direction.
     */
    static String convertDirectionToString(roomConnectionDirection direction) {
        String directionString = null;

        switch (direction) {
            case DIRECTION_NORTH: directionString = "north"; break;
            case DIRECTION_SOUTH: directionString = "south"; break;
            case DIRECTION_EAST: directionString = "east"; break;
            case DIRECTION_WEST: directionString = "west"; break;
            case DIRECTION_NORTHEAST: directionString = "northeast"; break;
            case DIRECTION_NORTHWEST: directionString = "northwest"; break;
            case DIRECTION_SOUTHEAST: directionString = "southeast"; break;
            case DIRECTION_SOUTHWEST: directionString = "southwest"; break;
            case DIRECTION_UP: directionString = "up"; break;
            case DIRECTION_DOWN: directionString = "down"; break;
        }
        return directionString;
    }

    /**
     * Converts a string to a connection direction.
     * @param string String to convert.
     * @return Direction corresponding to given string.
     */
    static roomConnectionDirection getDirectionFromString(String string) {
        roomConnectionDirection direction = null;

        switch (string.toLowerCase()) {
            case "north": direction = roomConnectionDirection.DIRECTION_NORTH; break;
            case "south": direction = roomConnectionDirection.DIRECTION_SOUTH; break;
            case "east": direction = roomConnectionDirection.DIRECTION_EAST; break;
            case "west": direction = roomConnectionDirection.DIRECTION_WEST; break;
            case "northeast": direction = roomConnectionDirection.DIRECTION_NORTHEAST; break;
            case "northwest": direction = roomConnectionDirection.DIRECTION_NORTHWEST; break;
            case "southeast": direction = roomConnectionDirection.DIRECTION_SOUTHEAST; break;
            case "southwest": direction = roomConnectionDirection.DIRECTION_SOUTHWEST; break;
            case "up": direction = roomConnectionDirection.DIRECTION_UP; break;
            case "down": direction = roomConnectionDirection.DIRECTION_DOWN; break;
        }
        return direction;
    }

    /**
     * Returns the opposite of the given direction.
     * @param direction Original direction.
     * @return Opposite of original direction.
     */
    private roomConnectionDirection getOppositeDirection(roomConnectionDirection direction) {
        roomConnectionDirection oppositeDirection = null;
        switch (direction) {
            case DIRECTION_NORTH: oppositeDirection = roomConnectionDirection.DIRECTION_SOUTH; break;
            case DIRECTION_SOUTH: oppositeDirection = roomConnectionDirection.DIRECTION_NORTH; break;
            case DIRECTION_EAST: oppositeDirection = roomConnectionDirection.DIRECTION_WEST; break;
            case DIRECTION_WEST: oppositeDirection = roomConnectionDirection.DIRECTION_EAST; break;
            case DIRECTION_NORTHEAST: oppositeDirection = roomConnectionDirection.DIRECTION_SOUTHWEST; break;
            case DIRECTION_SOUTHWEST: oppositeDirection = roomConnectionDirection.DIRECTION_NORTHEAST; break;
            case DIRECTION_NORTHWEST: oppositeDirection = roomConnectionDirection.DIRECTION_SOUTHEAST; break;
            case DIRECTION_SOUTHEAST: oppositeDirection = roomConnectionDirection.DIRECTION_NORTHWEST; break;
            case DIRECTION_UP: oppositeDirection = roomConnectionDirection.DIRECTION_DOWN; break;
            case DIRECTION_DOWN: oppositeDirection = roomConnectionDirection.DIRECTION_UP; break;
        }
        return oppositeDirection;
    }

    // *******************************
    // ***** Getters and Setters *****
    // *******************************

    ArrayList<MapRoom> getRoomsInArea() {
        return this.roomsInArea;
    }
}
