import java.util.ArrayList;

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
        switch (str) {
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
            default: invalidCommand(); break;
        }
    }

    /*
      There's gotta be a better way to do this right? I feel like there's a lot of repeated code for the directional commands
     */
    private void north() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTH.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTH.ordinal()));
        } else youCannotGoThatWay();
    }

    private void south() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTH.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTH.ordinal()));
        } else youCannotGoThatWay();
    }

    private void east() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_EAST.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_EAST.ordinal()));
        } else youCannotGoThatWay();
    }

    private void west() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_WEST.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_WEST.ordinal()));
        } else youCannotGoThatWay();
    }

    private void northwest() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTHWEST.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTHWEST.ordinal()));
        } else youCannotGoThatWay();
    }

    private void southeast() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTHEAST.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTHEAST.ordinal()));
        } else youCannotGoThatWay();
    }

    private void northeast() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTHEAST.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTHEAST.ordinal()));
        } else youCannotGoThatWay();
    }

    private void southwest() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTHWEST.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTHWEST.ordinal()));
        } else youCannotGoThatWay();
    }

    private void up() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_UP.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_UP.ordinal()));
        } else youCannotGoThatWay();
    }

    private void down() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_DOWN.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_DOWN.ordinal()));
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
        System.out.println("Other commands: q/quit");
    }
}
