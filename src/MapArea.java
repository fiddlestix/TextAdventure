import java.util.ArrayList;

/**
 * Created by jeffs_000 on 3/29/2017.
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
