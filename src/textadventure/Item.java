package textadventure;

/**
 * A superclass for all objects within the world. Objects can
 * be picked up and carried in the player's inventory, and used
 * in different ways.
 */

class Item {
    // ******************
    // ***** Fields *****
    // ******************
    private String name; // A short name for the item
    private String description; // A short description for the item
    private String identifier; // A one-word identifier for the item such as 'key' or 'idol'

    // ************************
    // ***** Constructors *****
    // ************************

    /**
     * Creates a default Item object.
     */
    Item() {
        this.name = "Default item name";
        this.description = "Default item description";
        this.identifier = "default";
    }

    /**
     * Creates an Item object using the given parameters.
     * @param newName Name for the item.
     * @param newDescription Description for the item.
     * @param newIdentifier Identifier for the item.
     */
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
