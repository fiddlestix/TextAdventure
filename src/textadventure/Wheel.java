package textadventure;

/**
 * Represents a Wheel lock object, used to lock connections to other rooms.
 * Must be 'turned' to unlock.
 */
class Wheel extends DirectionLock {

    /**
     * Creates a default Wheel DirectionLock object.
     */
    Wheel() {
        this.setName("A wheel");
        this.setDescription("A wheel meant to be turned by hand.");
        this.setIdentifier("Wheel");
        this.setIsLocked(true);
    }

    /**
     * Unlocks the Wheel DirectionLock object.
     */
    void turn() {
        if(this.checkIsLocked()) {
            this.setIsLocked(false);
        }
    }
}
