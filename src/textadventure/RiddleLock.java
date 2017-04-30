package textadventure;

import java.util.Objects;

/**
 * Represents a Riddle lock object, used to lock connections to other rooms.
 * The riddle must be answered to unlock.
 */
class RiddleLock extends DirectionLock {

    /**
     * The answer the player is required to 'say' to unlock the RiddleLock.
     */
    private String riddleAnswer;

    /**
     * Creates a RiddleLock object with the given answer.
     * @param riddleAnswer The answer to the riddle required to unlock the DirectionLock
     */
    RiddleLock(String riddleAnswer) {
        this.setName("A lock on a door");
        this.setDescription("A lock on a door that is opened by speaking the answer to a riddle out loud.");
        this.setIdentifier("RiddleLock");
        this.setIsLocked(true);
        this.riddleAnswer = riddleAnswer;
    }

    /**
     * Checks for the correct answer to the riddle and unlocks the lock.
     * @param riddleAnswer The attempted answer to the riddle.
     * @return True if the answer was correct and the lock unlocked, false if it was incorrect.
     */
    boolean open(String riddleAnswer) {
        if(this.checkIsLocked()) {
            if (Objects.equals(riddleAnswer, this.riddleAnswer)) {
                this.setIsLocked(false);
                return true;
            } else return false;
        } else return false;
    }
}
