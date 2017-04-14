package textadventure;

import textadventure.MapArea.roomConnectionDirection;
import java.util.Objects;

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
 * Parser.java
 * A class to parse console commands and execute them.
 */

class Parser {
    // ******************
    // ***** Fields *****
    // ******************
    private Player player;

    // ************************
    // ***** Constructors *****
    // ************************
    Parser(Player player) {
        this.player = player;
    }

    // *******************
    // ***** Methods *****
    // *******************
    void parseCommand(String str) {
        // Split string by spaces to separate commands from params
        str = str.toLowerCase();
        String[] input = str.split(" ");

        switch (input[0]) {
            case "n": north(); break;
            case "north": north(); break;
            case "s": south(); break;
            case "south": south(); break;
            case "e": east(); break;
            case "east": east(); break;
            case "w": west(); break;
            case "west": west(); break;
            case "nw": northwest(); break;
            case "northwest": northwest(); break;
            case "ne": northeast(); break;
            case "northeast": northeast(); break;
            case "sw": southwest(); break;
            case "southwest": southwest(); break;
            case "se": southeast(); break;
            case "southeast": southeast(); break;
            case "u": up(); break;
            case "up": up(); break;
            case "d": down(); break;
            case "down": down(); break;
            case "q": quit(); break;
            case "quit": quit(); break;
            case "help": help(); break;
            case "inventory": inventory(); break;
            case "take":
                if (input.length  != 2) {
                    System.out.println("Missing or incorrect parameters. Try again.");
                    break;
                }
                take(input[1]); break;
            case "drop":
                if (input.length  != 2) {
                    System.out.println("Missing or incorrect parameters. Try again.");
                    break;
                }
                drop(input[1]); break;
            case "equip":
                if (input.length  != 2) {
                    System.out.println("Missing or incorrect parameters. Try again.");
                    break;
                }
                equip(input[1]); break;
            default: invalidCommand(); break;
        }
    }

    /*
      There's gotta be a better way to do this right? I feel like there's a lot of repeated code for the directional commands
     */
    private void north() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTH) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTH));
        } else youCannotGoThatWay();
    }

    private void south() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTH) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTH));
        } else youCannotGoThatWay();
    }

    private void east() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_EAST) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_EAST));
        } else youCannotGoThatWay();
    }

    private void west() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_WEST) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_WEST));
        } else youCannotGoThatWay();
    }

    private void northwest() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTHWEST) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTHWEST));
        } else youCannotGoThatWay();
    }

    private void southeast() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTHEAST) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTHEAST));
        } else youCannotGoThatWay();
    }

    private void northeast() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTHEAST) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTHEAST));
        } else youCannotGoThatWay();
    }

    private void southwest() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTHWEST) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTHWEST));
        } else youCannotGoThatWay();
    }

    private void up() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_UP) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_UP));
        } else youCannotGoThatWay();
    }

    private void down() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_DOWN) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_DOWN));
        } else youCannotGoThatWay();
    }

    private void youCannotGoThatWay() {
        System.out.println("You cannot go in that direction.");
    }

    private void quit() {
        System.out.println("Quitting game...");
        System.exit(0);
    }

    private void invalidCommand() {
        System.out.println("Command not recognized, enter 'help' to see a list of commands.");
    }

    private void help() {
        System.out.println("Commands:");
        System.out.println("Directional commands: n/north, s/south, e/east, w/west");
        System.out.println("ne/northeast, nw/northwest, se/southeast, sw/southwest");
        System.out.println("up, down");
        System.out.println("Other commands: inventory, take, drop, equip");
        System.out.println("                q/quit");
    }

    private void inventory() {
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

    private void take(String inputString) {
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

    private void drop(String inputString) {
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

    private void equip(String inputString) {
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
