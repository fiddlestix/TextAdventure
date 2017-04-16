package textadventure;

/**
 * Created by jeffs_000 on 4/16/2017.
 */

public class Wheel extends DirectionLock {

    Wheel() {
        this.setName("A wheel");
        this.setDescription("A wheel meant to be turned by hand.");
        this.setIdentifier("Wheel");
        this.setIsLocked(true);
    }

    boolean turn() {
        if(this.checkIsLocked()) {
            this.setIsLocked(false);
            return true;
        } else {
            return false;
        }
    }
}
