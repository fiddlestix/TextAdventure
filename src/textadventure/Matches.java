package textadventure;

/**
 * Represents a box of matches, required to light fires and fireplaces.
 */
class Matches extends Item {

    /**
     * Creates a box of matches, which are required to light fires.
     */
    Matches() {
        this.setName("A small box of matches");
        this.setDescription("A small box of matches used for lighting fires.");
        this.setIdentifier("Matches");
    }
}
