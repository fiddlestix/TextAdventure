import java.util.ArrayList;
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
public class Parser {
    // ******************
    // ***** Fields *****
    // ******************
    private Player player;
    private ArrayList<MapRoom> connectedMapRooms;

    // ************************
    // ***** Constructors *****
    // ************************
    public Parser(Player player) {
        this.player = player;
        this.connectedMapRooms = player.getCurrentMapRoom().getConnectedMapRooms();
    }

    // *******************
    // ***** Methods *****
    // *******************
    public void parseCommand(String str) {
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
        }
    }

    public void north() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTH.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTH.ordinal()));
        } else youCannotGoThatWay();
    }

    public void south() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTH.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTH.ordinal()));
        } else youCannotGoThatWay();
    }

    public void east() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_EAST.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_EAST.ordinal()));
        } else youCannotGoThatWay();
    }

    public void west() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_WEST.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_WEST.ordinal()));
        } else youCannotGoThatWay();
    }

    public void northwest() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTHWEST.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTHWEST.ordinal()));
        } else youCannotGoThatWay();
    }

    public void southeast() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTHEAST.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTHEAST.ordinal()));
        } else youCannotGoThatWay();
    }

    public void northeast() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTHEAST.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_NORTHEAST.ordinal()));
        } else youCannotGoThatWay();
    }

    public void southwest() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTHWEST.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_SOUTHWEST.ordinal()));
        } else youCannotGoThatWay();
    }

    public void up() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_UP.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_UP.ordinal()));
        } else youCannotGoThatWay();
    }

    public void down() {
        if (player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_DOWN.ordinal()) != null) {
            player.movePlayerToMapRoom(player.getCurrentMapRoom().getConnectedMapRooms().get(MapArea.roomConnectionDirection.DIRECTION_DOWN.ordinal()));
        } else youCannotGoThatWay();
    }

    public void youCannotGoThatWay() {
        System.out.println("You cannot go in that direction.");
    }

    public void quit() {
        System.out.println("Quitting game...");
        System.exit(0);
    }
    // *******************************
    // ***** Getters and Setters *****
    // *******************************
}
