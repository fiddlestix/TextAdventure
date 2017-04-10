package textadventure;

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
 * Item.java
 * A superclass for items and objects.
 */

public class Item {
    // ******************
    // ***** Fields *****
    // ******************
    private String name;
    private String description;

    // ************************
    // ***** Constructors *****
    // ************************
    Item() {
        this.name = "Default item name";
        this.description = "Default item description";
    }

    Item(String newName, String newDescription) {
        this.name = newName;
        this.description = newDescription;
    }

    // *******************************
    // ***** Getters and Setters *****
    // *******************************
    String getName() {
        return this.name;
    }

    void setName(String newName) {
        this.name = newName;
    }

    String getDescription() {
        return this.description;
    }

    void setDescription(String newDescription) {
        this.description = newDescription;
    }
}
