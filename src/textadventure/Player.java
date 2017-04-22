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
 * Player.java
 * A class representing the user.
 */

class Player {
    // ******************
    // ***** Fields *****
    // ******************
    private MapRoom currentMapRoom;
    private ArrayList<Item> inventory;

    // ************************
    // ***** Constructors *****
    // ************************
    Player(MapRoom startingMapRoom) {
        currentMapRoom = startingMapRoom;
        inventory = new ArrayList<>();
    }

    // *******************
    // ***** Methods *****
    // *******************
    boolean movePlayerToMapRoom(MapRoom newMapRoom) {
        if (this.currentMapRoom.getConnectedMapRooms().containsValue(newMapRoom)) {
            this.currentMapRoom = newMapRoom;
            return true;
        } else {
            return false;
        }
    }

    // *******************************
    // ***** Getters and Setters *****
    // *******************************
    MapRoom getCurrentMapRoom() {
        return this.currentMapRoom;
    }

    ArrayList<Item> getInventory() {
        return this.inventory;
    }

    void addItemToInventory(Item newItem) {
        this.inventory.add(newItem);
    }
}
