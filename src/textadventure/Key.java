package textadventure;

/**
 * Represents a key for a door lock.
 */
class Key extends Item {

    /**
     * The identifier for the key and it's lock.
     */
    private Integer keyID;

    /**
     * Creates a Key object using the given keyID and name.
     * @param keyID Identifier for the key/lock combo.
     * @param name A short description of the key.
     */
    Key(Integer keyID, String name) {
        this.setName(name);
        this.setDescription("A key used to unlock doors.");
        this.setIdentifier("Key");
        this.keyID = keyID;
    }

    Integer getKeyID() {
        return keyID;
    }
}
