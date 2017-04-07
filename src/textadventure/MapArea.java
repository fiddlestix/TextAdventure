package textadventure;

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
 * MapArea.java
 * A class that contains a graph of rooms represented by
 * an adjacency list.
 */

class MapArea {
    // ******************
    // ***** Fields *****
    // ******************
    private ArrayList<MapRoom> roomsInArea;

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
    // ***** Constructors *****
    // ************************
    MapArea() {
        this.roomsInArea = new ArrayList<>();
    }

    MapArea(ArrayList<MapRoom> newRoomsInArea) {
        this.roomsInArea = newRoomsInArea;
    }

    // *******************
    // ***** Methods *****
    // *******************
    void addRoomToArea(MapRoom newRoom) {
        this.getRoomsInArea().add(newRoom);
    }

    boolean connectRooms(MapRoom firstRoom, MapRoom secondRoom, roomConnectionDirection direction) {
        // returns true if successful, false if failed
        if (this.getRoomsInArea().contains(firstRoom) && this.getRoomsInArea().contains(secondRoom)) {
            firstRoom.getConnectedMapRooms().replace(direction, secondRoom);
            secondRoom.getConnectedMapRooms().replace(getOppositeDirection(direction), firstRoom);
            return true;
        }
        return false;
    }

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

    roomConnectionDirection getOppositeDirection(roomConnectionDirection direction) {
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
