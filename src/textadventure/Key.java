package textadventure;

/**
 * Created by J on 4/21/2017.
 */
public class Key extends Item {

    private Integer keyID;

    Key(Integer keyID) {
        this.setName("A Key");
        this.setDescription("A key used to unlock doors.");
        this.setIdentifier("key");
        this.keyID = keyID;
    }

    public Integer getKeyID() {
        return keyID;
    }
}
