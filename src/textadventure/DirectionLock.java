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
 * DirectionLock.java
 * A class to lock room connections and block access to rooms.
 */

class DirectionLock {
    private Boolean isLocked;
    private String name;
    private String description;
    private String identifier;

    DirectionLock(String newName, String newDescription, String newIdentifier) {
        this.name = newName;
        this.description = newDescription;
        this.identifier = newIdentifier;
        this.isLocked = false;
    }

    DirectionLock() {
        this.name = "Default lock name";
        this.description = "Default lock description";
        this.identifier = "lock";
        this.isLocked = false;
    }

    Boolean checkIsLocked() {
        return isLocked;
    }

    void setIsLocked(Boolean locked) {
        isLocked = locked;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String getIdentifier() {
        return identifier;
    }

    void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
