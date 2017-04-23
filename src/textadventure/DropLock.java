package textadventure;

import java.util.Objects;

/**
 * Created by jeffs_000 on 4/22/2017.
 */
public class DropLock extends DirectionLock {

    private String keyItemIdentifier;

    DropLock(String keyItemIdentifier) {
        this.setName("A lock on a door");
        this.setDescription("A lock on a door that is opened by dropping an item.");
        this.setIdentifier("Droplock");
        this.setIsLocked(true);
        this.keyItemIdentifier = keyItemIdentifier;
    }

    boolean open(String keyItemIdentifier) {
        if(this.checkIsLocked()) {
            if (Objects.equals(keyItemIdentifier, this.keyItemIdentifier)) {
                this.setIsLocked(false);
                return true;
            } else return false;
        } else return false;
    }

    public String getKeyItemIdentifier() {
        return keyItemIdentifier;
    }
}
