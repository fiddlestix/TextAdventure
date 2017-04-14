package textadventure;

import textadventure.Command;

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
    //private static Player player;

    // ************************
    // ***** Constructors *****
    // ************************
    //Parser(Player player) {
    //    this.player = player;
    //}

    // *******************
    // ***** Methods *****
    // *******************
    void parseCommand(String str) {
        // Split string by spaces to separate commands from params
        str = str.toLowerCase();
        String[] input = str.split(" ");

        switch (input[0]) {
            case "n": Command.north(); break;
            case "north": Command.north(); break;
            case "s": Command.south(); break;
            case "south": Command.south(); break;
            case "e": Command.east(); break;
            case "east": Command.east(); break;
            case "w": Command.west(); break;
            case "west": Command.west(); break;
            case "nw": Command.northwest(); break;
            case "northwest": Command.northwest(); break;
            case "ne": Command.northeast(); break;
            case "northeast": Command.northeast(); break;
            case "sw": Command.southwest(); break;
            case "southwest": Command.southwest(); break;
            case "se": Command.southeast(); break;
            case "southeast": Command.southeast(); break;
            case "u": Command.up(); break;
            case "up": Command.up(); break;
            case "d": Command.down(); break;
            case "down": Command.down(); break;
            case "q": Command.quit(); break;
            case "quit": Command.quit(); break;
            case "help": Command.help(); break;
            case "inventory": Command.inventory(); break;
            case "take":
                if (input.length  != 2) {
                    System.out.println("Missing or incorrect parameters. Try again.");
                    break;
                }
                Command.take(input[1]); break;
            case "drop":
                if (input.length  != 2) {
                    System.out.println("Missing or incorrect parameters. Try again.");
                    break;
                }
                Command.drop(input[1]); break;
            case "equip":
                if (input.length  != 2) {
                    System.out.println("Missing or incorrect parameters. Try again.");
                    break;
                }
                Command.equip(input[1]); break;
            default: Command.invalidCommand(); break;
        }
    }
}
