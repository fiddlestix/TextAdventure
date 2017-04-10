package textadventure;

/**
 * Created by jeffs_000 on 4/10/2017.
 */
public class Armor extends Item {
    // ******************
    // ***** Fields *****
    // ******************
    private Integer armorMinimum;
    private static final Integer DEFAULT_ARMOR_MINIMUM = 0;
    private Integer armorMaximum;
    private static final Integer DEFAULT_ARMOR_MAXIMUM = 1;

    // ************************
    // ***** Constructors *****
    // ************************
    Armor() {
        this.setName("Default armor name");
        this.setDescription("Default armor description");
        this.armorMinimum = DEFAULT_ARMOR_MINIMUM;
        this.armorMaximum = DEFAULT_ARMOR_MAXIMUM;
    }

    Armor(String newName, String newDescription, Integer newArmorMinimum, Integer newArmorMaximum) {
        this.setName(newName);
        this.setDescription(newDescription);
        this.armorMinimum = newArmorMinimum;
        this.armorMaximum = newArmorMaximum;
    }

    // *******************
    // ***** Methods *****
    // *******************
    Integer getArmorMinimum() {
        return this.armorMinimum;
    }

    Integer getArmorMaximum() {
        return this.armorMaximum;
    }


}
