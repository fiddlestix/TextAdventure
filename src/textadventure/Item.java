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
    private String identifier;

    // ************************
    // ***** Constructors *****
    // ************************
    Item() {
        this.name = "Default item name";
        this.description = "Default item description";
        this.identifier = "default";
    }

    Item(String newName, String newDescription, String newIdentifier) {
        this.name = newName;
        this.description = newDescription;
        this.identifier = newIdentifier;
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

    String getIdentifier() {
        return this.identifier;
    }

    void setIdentifier(String newIdentifier) {
        this.identifier = newIdentifier;
    }
}
