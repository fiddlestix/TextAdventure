package textadventure;

/**
 * Text-based Adventure Game
 *
 * A project for CMSC 495 7982
 * Trends and Projects in Computer Science
 * University of Maryland University College
 *
 * Jeff Schouw
 * Mansukh Saini
 * Lionel Rockymore
 *
 * Lever.java
 * A class that represents a lever object in the world.
 * A lever is a DirectionLock, able to lock access to a room
 * until the user pulls the lever.
 */

class Lever extends DirectionLock {

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
