package textadventure;

import java.util.Objects;

/**
 * Represents a standard key lock for a door. Requires a specific key to unlock.
 */
class KeyLock extends DirectionLock {

    /**
     * The identifier for the key and its lock.
     */
    private Integer keyID;

    /**
     * Creates a KeyLock object using the given keyID
     * @param keyID The identifier for the key/lock combo
     */
    KeyLock(Integer keyID) {
        this.setName("A locked door");
        this.setDescription("A lock that requires a key.");
        this.setIdentifier("Lock");
        this.setIsLocked(true);
        this.keyID = keyID;
    }

    /**
     * Checks for the correct keyID and unlocks the lock.
     * @param keyID The attempted keyID
     * @return True if the keyID is correct and the lock is unlocked, false if it is not.
     */
    boolean unlock(Integer keyID) {
        if(this.checkIsLocked()) {
            if (Objects.equals(keyID, this.keyID)) {
                this.setIsLocked(false);
                return true;
            } else return false;
        } else {
            return false;
        }
    }

    Integer getKeyID() {
        return keyID;
    }
}
