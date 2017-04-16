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
 * Wheel.java
 * A class that represents a wheel object in the world.
 * A wheel is a DirectionLock, able to lock access to a room
 * until the user turns the wheel.
 */

class Wheel extends DirectionLock {

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
