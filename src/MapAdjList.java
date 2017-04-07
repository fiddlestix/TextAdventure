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

class MapAdjList {
    // ******************
    // ***** Fields *****
    // ******************
    private ArrayList<ArrayList<Integer>> adjList;

    // ************************
    // ***** Constructors *****
    // ************************
    MapAdjList() {
        // Create empty adjacency list
        this.adjList = new ArrayList<>();
    }

    MapAdjList(ArrayList<ArrayList<Integer>> newAdjList) {
        this.adjList = newAdjList;
    }

    // *******************
    // ***** Methods *****
    // *******************
    void addEdge(Integer firstVertexID, Integer secondVertexID) {
        try {
            this.adjList.get(firstVertexID).add(secondVertexID);
        } catch (IndexOutOfBoundsException e) {
            this.adjList.add(firstVertexID, new ArrayList<>());
            this.adjList.get(firstVertexID).add(secondVertexID);
        }
        try {
            this.adjList.get(secondVertexID).add(firstVertexID);
        } catch (IndexOutOfBoundsException e) {
            this.adjList.add(secondVertexID, new ArrayList<>());
            this.adjList.get(secondVertexID).add(firstVertexID);
        }

    }

    boolean isConnected(Integer firstVertexID, Integer secondVertexID) {
        return this.adjList.get(firstVertexID).contains(secondVertexID) &&
                this.adjList.get(secondVertexID).contains(firstVertexID);
    }


}
