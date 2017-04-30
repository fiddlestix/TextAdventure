package textadventure;

/**
 * Represents a Lever object, used to lock connections to other rooms.
 * Must be 'pulled' to unlock.
 */
class Lever extends DirectionLock {

    /**
     * Creates a default Lever DirectionLock object.
     */
    Lever() {
        this.setName("A lever");
        this.setDescription("A lever meant to be pulled or pushed.");
        this.setIdentifier("Lever");
        this.setIsLocked(true);
    }

    /**
     * Unlocks the lever DirectionLock object.
     */
    void pull() {
        if(this.checkIsLocked()) {
            this.setIsLocked(false);
        } else {
        }
    }
}
