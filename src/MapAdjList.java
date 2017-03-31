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
 * MapAdjList.java
 * A class that represents connections in an undirected graph.
 */
public class MapAdjList {
    private ArrayList<ArrayList<Integer>> adjList;

    // Constructor
    public MapAdjList() {
        // Create empty adjacency list
        this.adjList = new ArrayList<ArrayList<Integer>>();
    }

    public MapAdjList(ArrayList<ArrayList<Integer>> newAdjList) {
        this.adjList = newAdjList;
    }

    public void addEdge(Integer firstVertexID, Integer secondVertexID) {
        try {
            this.adjList.get(firstVertexID).add(secondVertexID);
        } catch (IndexOutOfBoundsException e) {
            this.adjList.add(firstVertexID, new ArrayList<Integer>());
            this.adjList.get(firstVertexID).add(secondVertexID);
        }
        try {
            this.adjList.get(secondVertexID).add(firstVertexID);
        } catch (IndexOutOfBoundsException e) {
            this.adjList.add(secondVertexID, new ArrayList<Integer>());
            this.adjList.get(secondVertexID).add(firstVertexID);
        }

    }

    public boolean isConnected(Integer firstVertexID, Integer secondVertexID) {
        return this.adjList.get(firstVertexID).contains(secondVertexID) &&
                this.adjList.get(secondVertexID).contains(firstVertexID);
    }


}
