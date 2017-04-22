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
 * Parser.java
 * A class to parse console commands and execute them.
 */

class Parser {
    // ******************
    // ***** Fields *****
    // ******************

    // ************************
    // ***** Constructors *****
    // ************************

    // *******************
    // ***** Methods *****
    // *******************
    static void parseCommand(String str) {
        // Split string by spaces to separate commands from params
        str = str.toLowerCase();
        String[] tokens = str.split(" ");

        if (tokens.length == 1) {
            switch (tokens[0]) {
                case "n":
                    Command.north();
                    break;
                case "north":
                    Command.north();
                    break;
                case "s":
                    Command.south();
                    break;
                case "south":
                    Command.south();
                    break;
                case "e":
                    Command.east();
                    break;
                case "east":
                    Command.east();
                    break;
                case "w":
                    Command.west();
                    break;
                case "west":
                    Command.west();
                    break;
                case "nw":
                    Command.northwest();
                    break;
                case "northwest":
                    Command.northwest();
                    break;
                case "ne":
                    Command.northeast();
                    break;
                case "northeast":
                    Command.northeast();
                    break;
                case "sw":
                    Command.southwest();
                    break;
                case "southwest":
                    Command.southwest();
                    break;
                case "se":
                    Command.southeast();
                    break;
                case "southeast":
                    Command.southeast();
                    break;
                case "u":
                    Command.up();
                    break;
                case "up":
                    Command.up();
                    break;
                case "d":
                    Command.down();
                    break;
                case "down":
                    Command.down();
                    break;
                case "q":
                    Command.quit();
                    break;
                case "quit":
                    Command.quit();
                    break;
                case "help":
                    Command.help();
                    break;
                case "inventory":
                    Command.inventory();
                    break;
                default:
                    Command.invalidCommand();
                    break;

            }
        } else if (tokens.length > 1) {
            switch (tokens[0]) {
                case "take":
                    if (tokens.length == 2) {
                        Command.take(tokens[1]);
                    }  else {
                        System.out.println("Missing or incorrect parameters. Try again.");
                    }
                    break;
                case "drop":
                    if (tokens.length == 2) {
                        Command.drop(tokens[1]);
                    } else {
                        System.out.println("Missing or incorrect parameters. Try again.");
                    }
                    break;
                case "turn":
                    if (tokens.length == 2) {
                        Command.turn(tokens[1]);
                    } else System.out.println("Missing or incorrect parameters. Try again.");
                    break;
                case "pull":
                    if (tokens.length == 2) {
                        Command.pull(tokens[1]);
                    } else System.out.println("Missing or incorrect parameters. Try again.");
                    break;
                case "unlock":
                    if (tokens.length == 2) {
                        Command.unlock(tokens[1]);
                    } else System.out.println("Missing or incorrect parameters. Try again.");
                    break;
                case "light":
                    if (tokens.length == 2) {
                        Command.light(tokens[1]);
                    } else System.out.println("Missing or incorrect parameters. Try again.");
                    break;
                default:
                    Command.invalidCommand();
                    break;
            }
        }
    }
}
