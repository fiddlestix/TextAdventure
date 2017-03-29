/**
 * Created by jeffs_000 on 3/29/2017.
 */
public class Main {
    public static void main(String[] args) {
        // Testing some map stuff
        MapArea mapArea = new MapArea();
        mapArea.getRoomsInArea().add(new MapRoom());
        mapArea.getRoomsInArea().add(new MapRoom());
        mapArea.getRoomsInArea().add(new MapRoom());
        mapArea.getAreaAdjacencyList().addEdge(0, 1);
        mapArea.getAreaAdjacencyList().addEdge(1, 2);

        System.out.println(mapArea.getAreaAdjacencyList().isConnected(0, 1));
        System.out.println(mapArea.getAreaAdjacencyList().isConnected(1, 2));
        System.out.println(mapArea.getAreaAdjacencyList().isConnected(0, 2));
    }
}
