package textadventure;

import java.util.Objects;
import textadventure.MapArea.roomConnectionDirection;

/**
 * Contains all the functionality for executing commands entered by the user.
 */
class Command {

    private static Player player; // A reference to the player, used for command execution

    // *******************
    // ***** Methods *****
    // *******************

    /**
     * Moves the player in the 'north' direction if there is an unlocked part of the map there.
     */
    static void north() {
            if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTH) != null) {
                if (!player.getCurrentMapRoom().isLocked(roomConnectionDirection.DIRECTION_NORTH)) {
                    if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTH).hasRoomBeenVisited()) {
                        reEnterRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTH).getRoomName());
                    }
                    player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTH));
                } else thatDirectionIsLocked();
            } else youCannotGoThatWay();
    }

    /**
     * Moves the player in the 'south' direction if there is an unlocked part of the map there.
     */
    static void south() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTH) != null) {
            if (!player.getCurrentMapRoom().isLocked(roomConnectionDirection.DIRECTION_SOUTH)) {
                if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTH).hasRoomBeenVisited()) {
                    reEnterRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTH).getRoomName());
                }
                player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTH));
            } else thatDirectionIsLocked();
        } else youCannotGoThatWay();
    }

    /**
     * Used to display text to the player when entering a room again.
     * @param roomName The room to enter.
     */
    private static void reEnterRoom(String roomName) {
        if (Objects.equals(roomName, "stairs")) {
            System.out.println("You use the stairs again.");
        } else {
            System.out.println("You walk back into the " + roomName);
        }
    }

    /**
     * Moves the player in the 'east' direction if there is an unlocked part of the map there.
     */
    static void east() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_EAST) != null) {
            if (!player.getCurrentMapRoom().isLocked(roomConnectionDirection.DIRECTION_EAST)) {
                if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_EAST).hasRoomBeenVisited()) {
                    reEnterRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_EAST).getRoomName());
                }
                player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_EAST));
            } else thatDirectionIsLocked();
        } else youCannotGoThatWay();
    }

    /**
     * Moves the player in the 'west' direction if there is an unlocked part of the map there.
     */
    static void west() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_WEST) != null) {
            if (!player.getCurrentMapRoom().isLocked(roomConnectionDirection.DIRECTION_WEST)) {
                if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_WEST).hasRoomBeenVisited()) {
                    reEnterRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_WEST).getRoomName());
                }
                player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_WEST));
            } else thatDirectionIsLocked();
        } else youCannotGoThatWay();
    }

    /**
     * Moves the player in the 'northwest' direction if there is an unlocked part of the map there.
     */
    static void northwest() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTHWEST) != null) {
            if (!player.getCurrentMapRoom().isLocked(roomConnectionDirection.DIRECTION_NORTHWEST)) {
                if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTHWEST).hasRoomBeenVisited()) {
                    reEnterRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTHWEST).getRoomName());
                }
                player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTHWEST));
            } else thatDirectionIsLocked();
        } else youCannotGoThatWay();
    }

    /**
     * Moves the player in the 'southeast' direction if there is an unlocked part of the map there.
     */
    static void southeast() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTHEAST) != null) {
            if (!player.getCurrentMapRoom().isLocked(roomConnectionDirection.DIRECTION_SOUTHEAST)) {
                if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTHEAST).hasRoomBeenVisited()) {
                    reEnterRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTHEAST).getRoomName());
                }
                player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTHEAST));
            } else thatDirectionIsLocked();
        } else youCannotGoThatWay();
    }

    /**
     * Moves the player in the 'northeast' direction if there is an unlocked part of the map there.
     */
    static void northeast() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTHEAST) != null) {
            if (!player.getCurrentMapRoom().isLocked(roomConnectionDirection.DIRECTION_NORTHEAST)) {
                if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTHEAST).hasRoomBeenVisited()) {
                    reEnterRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTHEAST).getRoomName());
                }
                player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_NORTHEAST));
            } else thatDirectionIsLocked();
        } else youCannotGoThatWay();
    }

    /**
     * Moves the player in the 'southwest' direction if there is an unlocked part of the map there.
     */
    static void southwest() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTHWEST) != null) {
            if (!player.getCurrentMapRoom().isLocked(roomConnectionDirection.DIRECTION_SOUTHWEST)) {
                if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTHWEST).hasRoomBeenVisited()) {
                    reEnterRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTHWEST).getRoomName());
                }
                player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_SOUTHWEST));
            } else thatDirectionIsLocked();
        } else youCannotGoThatWay();
    }

    /**
     * Moves the player in the 'up' direction if there is an unlocked part of the map there.
     */
    static void up() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_UP) != null) {
            if (!player.getCurrentMapRoom().isLocked(roomConnectionDirection.DIRECTION_UP)) {
                if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_UP).hasRoomBeenVisited()) {
                    reEnterRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_UP).getRoomName());
                }
                player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_UP));
            } else thatDirectionIsLocked();
        } else youCannotGoThatWay();
    }

    /**
     * Moves the player in the 'down' direction if there is an unlocked part of the map there.
     */
    static void down() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_DOWN) != null) {
            if (!player.getCurrentMapRoom().isLocked(roomConnectionDirection.DIRECTION_DOWN)) {
                if (player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_DOWN).hasRoomBeenVisited()) {
                    reEnterRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_DOWN).getRoomName());
                }
                player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(roomConnectionDirection.DIRECTION_DOWN));
            } else thatDirectionIsLocked();
        } else youCannotGoThatWay();
    }

    /**
     * Displays an error message to the player when there is not an accessible part of the map in the given direction.
     */
    private static void youCannotGoThatWay() {
        System.out.println("You cannot go in that direction.");
    }

    /**
     * Displays an error message to the player when the map is locked in the given direction.
     */
    private static void thatDirectionIsLocked() {
        System.out.println("You cannot go in that direction, the way is locked.");
    }

    /**
     * Quits the game and shuts down the application.
     */
    static void quit() {
        System.out.println("Quitting game...\nThanks for playing!");
        System.exit(0);
    }

    /**
     * Displays an error message to the player when entering an unrecognized command.
     */
    static void invalidCommand() {
        System.out.println("Command not recognized, type 'help' to see a list of commands.");
    }

    /**
     * Displays a list of commands in the game.
     */
    static void help() {
        System.out.println("Commands:");
        System.out.println("Directional commands: n/north, s/south, e/east, w/west");
        System.out.println("                      ne/northeast, nw/northwest, se/southeast,");
        System.out.println("                      sw/southwest, up, down");
        System.out.println("");
        System.out.println("Other commands: look/l, inventory, take, drop,");
        System.out.println("                turn, pull, light, say,");
        System.out.println("                unlock [direction], q/quit");
        System.out.println("");
    }

    /**
     * Displays the player's inventory
     */
    static void inventory() {
        System.out.println(" --- Inventory: ---");
        for (Item item : player.getInventory()) {
            System.out.println(item.getName());
        }
    }

    /**
     * Takes an item from a room and places it in the player's inventory.
     * @param inputString User input from the command line.
     */
    static void take(String inputString) {
        boolean itemFound = false;
        for(Item item : player.getCurrentMapRoom().getItemsInRoom()) {
            if (Objects.equals(item.getIdentifier().toLowerCase(), inputString.toLowerCase())) {
                player.addItemToInventory(item);
                player.getCurrentMapRoom().getItemsInRoom().remove(item);
                itemFound = true;

                System.out.println(item.getIdentifier() + " added to inventory."); // delete this notification later
                break;
            }
        }
        if (!itemFound) {
            System.out.println("No item called " + inputString + " found in current room.");
            // delete this notification later, find a better way to notify player
        }
    }

    /**
     * Removes an item from the player's inventory and places it in the current room.
     * @param inputString User input from the command line.
     */
    static void drop(String inputString) {
        boolean itemFound = false;
        for (Item item : player.getInventory()) {
            if (Objects.equals(inputString.toLowerCase(), item.getIdentifier().toLowerCase())) {
                player.getCurrentMapRoom().getItemsInRoom().add(item);
                player.getInventory().remove(item);
                itemFound = true;
                System.out.println(item.getIdentifier() + " removed from inventory and added to current room.");

                // Check for drop item puzzles
                for (roomConnectionDirection direction : roomConnectionDirection.values()) {
                    if (player.getCurrentMapRoom().getDirectionLock(direction) != null) {
                        if (player.getCurrentMapRoom().getDirectionLock(direction).getClass() == DropLock.class) {
                            DropLock lock = (DropLock) player.getCurrentMapRoom().getDirectionLock(direction);
                            if (Objects.equals(item.getIdentifier().toLowerCase(), lock.getKeyItemIdentifier().toLowerCase())) {
                                lock.open(item.getIdentifier());
                                player.getCurrentMapRoom().unlock(direction);
                                System.out.println("\nDropping the " + item.getIdentifier().toLowerCase() + " causes the " +
                                        MapArea.convertDirectionToString(direction) + " door to shake and rattle.");
                            }
                        }
                    }
                }

                break;
            }
        }
        if (!itemFound) {
            System.out.println("No item called " + inputString + " found in player's inventory.");
        }
    }

    /**
     * Turns a wheel DirectionLock
     * @param inputString User input from the command line.
     */
    static void turn(String inputString) {
        if (Objects.equals(inputString.toLowerCase(), "wheel")) {
            for (roomConnectionDirection direction : roomConnectionDirection.values()) {
                if (player.getCurrentMapRoom().getDirectionLock(direction) != null) {
                    if (player.getCurrentMapRoom().isLocked(direction) && player.getCurrentMapRoom().getDirectionLock(direction).getClass() == Wheel.class) {
                        Wheel wheel = (Wheel) player.getCurrentMapRoom().getDirectionLock(direction);
                        if (wheel.checkIsLocked()) {
                            wheel.turn();
                            player.getCurrentMapRoom().unlock(direction);
                            System.out.println(FileIO.formatTextForConsole("You turn the wheel until it stops, and as you do you can feel something in the " + MapArea.convertDirectionToString(direction) + " door move.", 100));
                        } else {
                            System.out.println("The wheel has already been turned all the way.");
                        }
                    } else {
                        System.out.println("There is no wheel to turn in this room.");
                    }
                }
            }
        }
    }

    /**
     * Pulls a Lever DirectionLock
     * @param inputString User input from the command line.
     */
    static void pull(String inputString) {
        if (Objects.equals(inputString.toLowerCase(), "lever")) {
            boolean leverFound = false;
            for (roomConnectionDirection direction : roomConnectionDirection.values()) {
                if (player.getCurrentMapRoom().getDirectionLock(direction) != null) {
                    if (player.getCurrentMapRoom().getDirectionLock(direction).getClass() == Lever.class) {
                        Lever lever = (Lever) player.getCurrentMapRoom().getDirectionLock(direction);
                        leverFound = true;
                        if (lever.checkIsLocked()) {
                            lever.pull();
                            player.getCurrentMapRoom().unlock(direction);
                            System.out.println("You pull the lever and the " + MapArea.convertDirectionToString(direction) + " door makes a loud clanking noise.");
                        } else {
                            System.out.println("The lever has already been pulled, and it is stuck.");
                        }
                    }
                }
            }
            if (!leverFound) {
                System.out.println("There is no lever in this room.");
            }
        }
    }

    /**
     * Unlocks a KeyLock in the given direction.
     * @param inputString User input from the command line.
     */
    static void unlock(String inputString) {
        roomConnectionDirection direction = MapArea.getDirectionFromString(inputString);
        if (player.getCurrentMapRoom().getDirectionLock(direction) != null) {
            if (player.getCurrentMapRoom().isLocked(direction)) {
                if (player.getCurrentMapRoom().getDirectionLock(direction).getClass() == KeyLock.class) {
                    KeyLock lock = (KeyLock) player.getCurrentMapRoom().getDirectionLock(direction);
                    if (lock.checkIsLocked()) {
                        Integer doorKeyID = lock.getKeyID();

                        // loop through player's inventory looking for the correct key
                        boolean keyFound = false;
                        for (Item item : player.getInventory()) {
                            if (item.getClass() == Key.class) {
                                Key key = (Key) item;
                                if (Objects.equals(key.getKeyID(), doorKeyID)) {
                                    lock.unlock(key.getKeyID());
                                    player.getCurrentMapRoom().unlock(direction);
                                    System.out.println("You unlock the door with your key.");
                                    keyFound = true;
                                }
                            }
                        }
                        if (!keyFound) {
                            System.out.println("You do not have the right key for that door.");
                        }
                    } else {
                        System.out.println("That door has already been unlocked.");
                    }
                } else {
                    System.out.println("That type of lock does not require a key.");
                }
            } else {
                System.out.println("That door is not locked.");
            }
        } else {
            System.out.println("There is no lock in that direction.");
        }
    }

    /**
     * Lights a Fireplace DirectionLock.
     * @param inputString User input from the command line.
     */
    static void light(String inputString) {
        if (Objects.equals(inputString.toLowerCase(), "fireplace") || Objects.equals(inputString.toLowerCase(), "fire")) {
            boolean fireFound = false;
            for (roomConnectionDirection direction : roomConnectionDirection.values()) {
                if (player.getCurrentMapRoom().getDirectionLock(direction) != null) {
                    if (player.getCurrentMapRoom().getDirectionLock(direction).getClass() == Fireplace.class) {
                        // check if player has matches in their inventory
                        boolean foundMatches = false;
                        for (Item item : player.getInventory()) {
                            if (item.getClass() == Matches.class) {
                                foundMatches = true;
                            }
                        }
                        if (foundMatches) {
                            Fireplace fireplace = (Fireplace) player.getCurrentMapRoom().getDirectionLock(direction);
                            fireFound = true;
                            if (fireplace.checkIsLocked()) {
                                fireplace.light();
                                player.getCurrentMapRoom().unlock(direction);
                                System.out.println("You light the fireplace, and as it burns you hear a soft clicking noise from the " + MapArea.convertDirectionToString(direction) + " door.");
                            } else {
                                System.out.println("The fireplace is already lit.");
                            }
                        } else {
                            System.out.println("You do not have anything to light it with.");
                            break;
                        }
                    }
                }
            }
            if (!fireFound) {
                System.out.println("There is nothing to light in this room.");
            }
        }
    }

    static void say(String inputString) {
        boolean riddleLockFound = false;
        boolean riddleLockUnlocked = false;
        for (roomConnectionDirection direction : roomConnectionDirection.values()) {
            if (player.getCurrentMapRoom().getDirectionLock(direction) != null) {
                if (player.getCurrentMapRoom().getDirectionLock(direction).getClass() == RiddleLock.class) {
                    RiddleLock lock = (RiddleLock) player.getCurrentMapRoom().getDirectionLock(direction);
                    riddleLockFound = true;
                    if (lock.checkIsLocked()) {
                        if (lock.open(inputString)) {
                            riddleLockUnlocked = true;
                            player.getCurrentMapRoom().unlock(direction);
                            System.out.println("The " + MapArea.convertDirectionToString(direction).toLowerCase() + " door makes a clicking noise after you say '" +
                                    inputString.toLowerCase() + "' out loud.");
                        }
                    }
                }
            }
        }
        if (!riddleLockFound || !riddleLockUnlocked) {
            System.out.println("Nothing happens when you say '" + inputString + "' out loud. You feel like a fool talking to yourself.");
        }
    }

    /**
     * Displays information about the player's current room.
     */
    static void lookAround() {
        MapRoom.lookAroundRoom(player.getCurrentMapRoom());
    }

    static void setPlayer(Player player) {
        Command.player = player;
    }
}
