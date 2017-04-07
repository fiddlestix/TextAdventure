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
    private MapAdjList areaAdjacencyList;

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
        this.areaAdjacencyList = new MapAdjList();
    }

    MapArea(ArrayList<MapRoom> newRoomsInArea) {
        this.roomsInArea = newRoomsInArea;
    }

    MapArea(ArrayList<MapRoom> newRoomsInArea, MapAdjList newAreaAdjacencyList) {
        this.roomsInArea = newRoomsInArea;
        this.areaAdjacencyList = newAreaAdjacencyList;
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
            //this.getAreaAdjacencyList().addEdge(firstRoom.getRoomIndex(), secondRoom.getRoomIndex());

            firstRoom.getConnectedMapRooms().set(direction.ordinal(), secondRoom);

            if (direction.ordinal() % 2 == 0) {
                secondRoom.getConnectedMapRooms().set(direction.ordinal() + 1, firstRoom);
            } else {
                secondRoom.getConnectedMapRooms().set(direction.ordinal() - 1, firstRoom);
            }

            return true;
        }
        return false;
    }

    static String convertIndexToDirectionString(Integer index) {
        String[] directionStrings = {"north", "south", "east", "west",
                "northeast", "southwest", "northwest",
                "southeast", "up", "down"};

        return directionStrings[index];
    }

    // *******************************
    // ***** Getters and Setters *****
    // *******************************
    ArrayList<MapRoom> getRoomsInArea() {
        return this.roomsInArea;
    }

    MapAdjList getAreaAdjacencyList() {
        return this.areaAdjacencyList;
    }

}
