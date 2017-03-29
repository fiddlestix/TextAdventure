import java.util.ArrayList;

/**
 * Created by jeffs_000 on 3/29/2017.
 *
 * (Might have to add a removeEdge() function later to simulate doors locking behind
 * players or paths being blocked.)
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
