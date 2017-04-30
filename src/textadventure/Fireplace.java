package textadventure;

/**
 * Represents a fireplace in the world that locks a direction
 * in a room, and unlocks when it is lit.
 */
class Fireplace extends DirectionLock {

    /**
     * Creates a Fireplace DirectionLock object.
     */
    Fireplace() {
        this.setName("A fireplace");
        this.setDescription("A large stone fireplace.");
        this.setIdentifier("Fireplace");
        this.setIsLocked(true);
    }

    /**
     * Unlocks the DirectionLock
     */
    void light() {
        this.setIsLocked(false);
    }
}
