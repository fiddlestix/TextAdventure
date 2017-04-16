package textadventure;

/**
 * Created by jeffs_000 on 4/16/2017.
 */

public class Lever extends DirectionLock {

    Lever() {
        this.setName("A lever");
        this.setDescription("A lever meant to be pulled or pushed.");
        this.setIdentifier("Lever");
        this.setIsLocked(true);
    }

    boolean pull() {
        if(this.checkIsLocked()) {
            this.setIsLocked(false);
            return true;
        } else {
            return false;
        }
    }
}
