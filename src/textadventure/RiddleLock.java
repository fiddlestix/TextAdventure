package textadventure;

import java.util.Objects;

/**
 * Created by jeffs_000 on 4/22/2017.
 */
public class RiddleLock extends DirectionLock {
    private String riddleAnswer;

    RiddleLock(String riddleAnswer) {
        this.setName("A lock on a door");
        this.setDescription("A lock on a door that is opened by speaking the answer to a riddle out loud.");
        this.setIdentifier("RiddleLock");
        this.setIsLocked(true);
        this.riddleAnswer = riddleAnswer;
    }

    boolean open(String riddleAnswer) {
        if(this.checkIsLocked()) {
            if (Objects.equals(riddleAnswer, this.riddleAnswer)) {
                this.setIsLocked(false);
                return true;
            } else return false;
        } else return false;
    }
}
