package textadventure;

import java.util.Objects;

/**
 * Created by J on 4/21/2017.
 */

public class KeyLock extends DirectionLock {

    private Integer keyID;

    KeyLock(Integer keyID) {
        this.setName("A locked door");
        this.setDescription("A lock that requires a key.");
        this.setIdentifier("Lock");
        this.setIsLocked(true);
        this.keyID = keyID;
    }

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
