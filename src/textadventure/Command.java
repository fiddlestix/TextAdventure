package textadventure;

import java.util.Objects;
import textadventure.MapArea.roomConnectionDirection;

/**
 * Created by jeffs_000 on 4/14/2017.
 */

public class Command {

    private static Player player;

    Command(Player player) {
        this.player = player;
    }

    static void north() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTH) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTH));
        } else youCannotGoThatWay();
    }

    static void south() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTH) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTH));
        } else youCannotGoThatWay();
    }

    static void east() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_EAST) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_EAST));
        } else youCannotGoThatWay();
    }

    static void west() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_WEST) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_WEST));
        } else youCannotGoThatWay();
    }

    static void northwest() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTHWEST) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTHWEST));
        } else youCannotGoThatWay();
    }

    static void southeast() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTHEAST) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTHEAST));
        } else youCannotGoThatWay();
    }

    static void northeast() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTHEAST) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTHEAST));
        } else youCannotGoThatWay();
    }

    static void southwest() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTHWEST) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTHWEST));
        } else youCannotGoThatWay();
    }

    static void up() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_UP) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_UP));
        } else youCannotGoThatWay();
    }

    static void down() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_DOWN) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_DOWN));
        } else youCannotGoThatWay();
    }

    private static void youCannotGoThatWay() {
        System.out.println("You cannot go in that direction.");
    }

    static void quit() {
        System.out.println("Quitting game...");
        System.exit(0);
    }

    static void invalidCommand() {
        System.out.println("Command not recognized, enter 'help' to see a list of commands.");
    }

    static void help() {
        System.out.println("Commands:");
        System.out.println("Directional commands: n/north, s/south, e/east, w/west");
        System.out.println("ne/northeast, nw/northwest, se/southeast, sw/southwest");
        System.out.println("up, down");
        System.out.println("Other commands: inventory, take, drop, equip");
        System.out.println("                q/quit");
    }

    static void inventory() {
        System.out.println(" --- Inventory: ---");

        // Show equipped weapon/armor
        StringBuilder equippedWeaponString = new StringBuilder("");
        StringBuilder equippedArmorString = new StringBuilder("");
        if (player.getEquippedWeapon() == null) {
            equippedWeaponString.append("(none)");
        } else {
            equippedWeaponString.append(player.getEquippedWeapon().getName());
        }
        if (player.getEquippedArmor() == null) {
            equippedArmorString.append("(none)");
        } else {
            equippedArmorString.append(player.getEquippedArmor().getName());
        }

        System.out.println("Equipped weapon: " + equippedWeaponString);
        System.out.println("Equipped armor: " + equippedArmorString);
        System.out.println("");
        System.out.println("Items:");
        for (Item item : player.getInventory()) {
            System.out.println(item.getName());
        }
    }

    static void take(String inputString) {
        boolean itemFound = false;
        for(Item item : player.getCurrentMapRoom().getItemsInRoom()) {
            if (Objects.equals(inputString, item.getName().toLowerCase())) {
                player.addItemToInventory(item);
                player.getCurrentMapRoom().getItemsInRoom().remove(item);
                itemFound = true;
                System.out.println(item.getName() + " added to inventory."); // delete this notifaction later
                break;
            }
        }
        if (!itemFound) {
            System.out.println("No item called " + inputString + " found in current room.");
            // delete this notification later, find a better way to notify player
        }
    }

    static void drop(String inputString) {
        boolean itemFound = false;
        for (Item item : player.getInventory()) {
            if (Objects.equals(inputString, item.getName().toLowerCase())) {
                player.getCurrentMapRoom().getItemsInRoom().add(item);
                player.getInventory().remove(item);
                itemFound = true;
                System.out.println(item.getName() + " removed from inventory and added to current room.");
                break;
            }
        }
        if (!itemFound) {
            System.out.println("No item called " + inputString + " found in player's inventory.");
        }
    }

    static void equip(String inputString) {
        boolean itemFound = false;
        for (Item item : player.getInventory()) {
            if (Objects.equals(inputString, item.getName().toLowerCase())) {
                itemFound = true;
                if (item.getClass() == Weapon.class) {
                    System.out.println(player.getEquippedWeapon().getName() + " unequipped.");
                    player.equipWeapon((Weapon) item);
                    System.out.println(item.getName() + " equipped.");
                } else if (item.getClass() == Armor.class) {
                    System.out.println(player.getEquippedArmor().getName() + " unequipped.");
                    player.equipArmor((Armor) item);
                    System.out.println(item.getName() + " equipped.");
                } else {
                    System.out.println("Item is not a weapon or piece of armor. Try again.");
                }
                break;
            }
        }
        if (!itemFound) {
            System.out.println("No item called " + inputString + " found in player's inventory.");
        }
    }
}
