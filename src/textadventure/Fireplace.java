package textadventure;

/**
 * Created by J on 4/22/2017.
 */

public class Fireplace extends DirectionLock {

    Fireplace() {
        this.setName("A fireplace");
        this.setDescription("A large stone fireplace.");
        this.setIdentifier("Fireplace");
        this.setIsLocked(true);
    }

    void light() {
        this.setIsLocked(false);
    }
}
