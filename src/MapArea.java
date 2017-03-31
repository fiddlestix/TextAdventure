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
    private ArrayList<MapRoom> roomsInArea;
    private MapAdjList areaAdjacencyList;

    // Constructor
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

    public ArrayList<MapRoom> getRoomsInArea() {
        return this.roomsInArea;
    }

    public MapAdjList getAreaAdjacencyList() {
        return this.areaAdjacencyList;
    }
}
