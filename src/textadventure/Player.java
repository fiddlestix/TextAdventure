package textadventure;

import java.util.ArrayList;

/**
 * Represents the user. Contains a reference to the player's current
 * location on the map and the items in their inventory.
 */
class Player {

    // ******************
    // ***** Fields *****
    // ******************
    private MapRoom currentMapRoom; // The player's current location
    private ArrayList<Item> inventory; // The player's current inventory

    // ************************
    // ***** Constructors *****
    // ************************

    /**
     * Creates a player object in the given location.
     * @param startingMapRoom The room in the map the player will start in.
     */
    Player(MapRoom startingMapRoom) {
        currentMapRoom = startingMapRoom;
        inventory = new ArrayList<>();
    }

    // *******************
    // ***** Methods *****
    // *******************

    /**
     * Moves a player to the given room, if that room is connected to the player's current room.
     * @param newMapRoom The room to move the player to.
     */
    void movePlayerToMapRoom(MapRoom newMapRoom) {
        if (this.currentMapRoom.getConnectedMapRooms().containsValue(newMapRoom)) {
            this.currentMapRoom = newMapRoom;
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
