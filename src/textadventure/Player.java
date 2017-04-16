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
    private Weapon equippedWeapon;
    private Armor equippedArmor;

    // ************************
    // ***** Constructors *****
    // ************************
    Player(MapRoom startingMapRoom) {
        currentMapRoom = startingMapRoom;
        inventory = new ArrayList<>();
        equippedWeapon = null;
        equippedArmor = null;
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

    boolean equipWeapon(Weapon weapon) {
        if (this.inventory.contains(weapon)) {
            if (equippedWeapon == null) {
                this.equippedWeapon = weapon;
                this.getInventory().remove(weapon);
            } else {
                this.getInventory().add(equippedWeapon);
                this.equippedWeapon = weapon;
                this.getInventory().remove(weapon);
            }
            return true;
        }
        return false;
    }

    boolean equipArmor(Armor armor) {
        if (this.inventory.contains(armor)) {
            if (equippedArmor == null) {
                this.equippedArmor = armor;
                this.getInventory().remove(armor);
            } else {
                this.getInventory().add(equippedArmor);
                this.equippedArmor = armor;
                this.getInventory().remove(armor);
            }
            return true;
        }
        return false;
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

    Weapon getEquippedWeapon() {
        return this.equippedWeapon;
    }

    Armor getEquippedArmor() {
        return this.equippedArmor;
    }
}
