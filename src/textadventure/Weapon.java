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
 * Weapon.java
 * An Item that can be equipped and used to damage enemies.
 */

class Weapon extends Item {
    // ******************
    // ***** Fields *****
    // ******************
    private Integer damageMinimum;
    private static final Integer DEFAULT_DAMAGE_MINIMUM = 0;
    private Integer damageMaximum;
    private static final Integer DEFAULT_DAMAGE_MAXIMUM = 3;
    private Double chanceToHit;
    private static final Double DEFAULT_CHANCE_TO_HIT = 1.0; // 100% chance to hit

    // ************************
    // ***** Constructors *****
    // ************************
    Weapon() {
        this.setName("Default weapon name");
        this.setDescription("Default weapon description");
        this.damageMinimum = DEFAULT_DAMAGE_MINIMUM;
        this.damageMaximum = DEFAULT_DAMAGE_MAXIMUM;
        this.chanceToHit = DEFAULT_CHANCE_TO_HIT;
    }

    Weapon(String newName, String newDescription, Integer newDamageMinimum, Integer newDamageMaximum, Double newChanceToHit) {
        this.setName(newName);
        this.setDescription(newDescription);
        this.damageMinimum = newDamageMinimum;
        this.damageMaximum = newDamageMaximum;
        this.chanceToHit = newChanceToHit;
    }

    // *******************
    // ***** Methods *****
    // *******************
    Integer getDamageMinimum() {
        return this.damageMinimum;
    }

    Integer getDamageMaximum() {
        return this.damageMaximum;
    }

    Double getChanceToHit() {
        return this.chanceToHit;
    }
}
