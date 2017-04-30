package textadventure;

import java.util.Objects;

/**
 * Represents a DirectionLock that requires dropping a specific item to unlock.
 */
class DropLock extends DirectionLock {

    /**
     * The one-word identifier of the required key-item.
     */
    private String keyItemIdentifier;

    /**
     * Creates a DropLock object with the given identifier.
     * @param keyItemIdentifier The item identifier required to unlock the DropLock.
     */
    DropLock(String keyItemIdentifier) {
        this.setName("A lock on a door");
        this.setDescription("A lock on a door that is opened by dropping an item.");
        this.setIdentifier("Droplock");
        this.setIsLocked(true);
        this.keyItemIdentifier = keyItemIdentifier;
    }

    /**
     * Checks if the correct item identifier is given and unlocks the DropLock.
     * @param keyItemIdentifier The item identifier of the dropped item.
     * @return True if the item identifier is correct for the DropLock and unlocks it, false if it is not.
     */
    boolean open(String keyItemIdentifier) {
        if(this.checkIsLocked()) {
            if (Objects.equals(keyItemIdentifier, this.keyItemIdentifier)) {
                this.setIsLocked(false);
                return true;
            } else return false;
        } else return false;
    }

    String getKeyItemIdentifier() {
        return keyItemIdentifier;
    }
}
