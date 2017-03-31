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
 * Main.java
 * An executable class, contains main() method to start application.
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
