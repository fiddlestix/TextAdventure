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

public class MapArea {
    // ******************
    // ***** Fields *****
    // ******************
    private ArrayList<MapRoom> roomsInArea;
    private MapAdjList areaAdjacencyList;

    // ************************
    // ***** Constructors *****
    // ************************
    public MapArea() {
        this.roomsInArea = new ArrayList<MapRoom>();
        this.areaAdjacencyList = new MapAdjList();
    }

    public MapArea(ArrayList<MapRoom> newRoomsInArea) {
        this.roomsInArea = newRoomsInArea;
    }

    public MapArea(ArrayList<MapRoom> newRoomsInArea, MapAdjList newAreaAdjacencyList) {
        this.roomsInArea = newRoomsInArea;
        this.areaAdjacencyList = newAreaAdjacencyList;
    }

    // *******************
    // ***** Methods *****
    // *******************
    public void addRoomToArea(MapRoom newRoom) {
        this.getRoomsInArea().add(newRoom);
    }

    public boolean connectRooms(MapRoom firstRoom, MapRoom secondRoom) {
        // returns true if successful, false if failed
        if (this.getRoomsInArea().contains(firstRoom) && this.getRoomsInArea().contains(secondRoom)) {
            this.getAreaAdjacencyList().addEdge(firstRoom.getRoomIndex(), secondRoom.getRoomIndex());
            firstRoom.getConnectedMapRooms().add(secondRoom);
            secondRoom.getConnectedMapRooms().add(firstRoom); // going to have to change this later to use the
            // connectedMapRooms array to indicate direction the room is connected in
            return true;
        }
        return false;
    }

    // *******************************
    // ***** Getters and Setters *****
    // *******************************
    public ArrayList<MapRoom> getRoomsInArea() {
        return this.roomsInArea;
    }

    public MapAdjList getAreaAdjacencyList() {
        return this.areaAdjacencyList;
    }

}
