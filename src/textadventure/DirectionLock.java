package textadventure;

/**
 * Represents a lock on the connection to another area of the map.
 * Blocks access to areas of the map and require interaction to unlock.
 */
class DirectionLock {
    private Boolean isLocked; // Whether or not the lock is currently locked
    private String name; // A short name for the lock
    private String description; // A short description of the lock
    private String identifier; // A one-word identifier for the lock

    /**
     * Creates a default DirectionLock object.
     */
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
