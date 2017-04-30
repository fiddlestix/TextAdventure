package textadventure;

/**
 * A class used to parse user input and execute commands accordingly.
 * Breaks a string entered by the user into 'tokens' which are used as
 * parameters for commands.
 */
class Parser {

    // *******************
    // ***** Methods *****
    // *******************

    /**
     * Parses a string given as input from the user and executes the command accordingly.
     * Gets command parameters from user input, and warns the user if commands are entered
     * incorrectly.
     * @param str User input from the command line.
     */
    static void parseCommand(String str) {
        // Split string by spaces to separate commands from params
        str = str.toLowerCase();
        String[] tokens = str.split(" ");

        switch (tokens[0].toLowerCase()) {
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
            case "l":
                Command.lookAround();
                break;
            case "look":
                Command.lookAround();
                break;
            case "take":
                if (tokens.length == 2) {
                    Command.take(tokens[1]);
                } else {
                    System.out.println("Missing or incorrect parameters. Command format:'take [item]'");
                }
                break;
            case "drop":
                if (tokens.length == 2) {
                    Command.drop(tokens[1]);
                } else {
                    System.out.println("Missing or incorrect parameters. Command format: 'drop [item]'");
                }
                break;
            case "turn":
                if (tokens.length == 2) {
                    Command.turn(tokens[1]);
                } else System.out.println("Missing or incorrect parameters. Command format: 'turn [world object]'");
                break;
            case "pull":
                if (tokens.length == 2) {
                    Command.pull(tokens[1]);
                } else System.out.println("Missing or incorrect parameters. Command format: 'pull [world object]'");
                break;
            case "unlock":
                if (tokens.length == 2) {
                    Command.unlock(tokens[1]);
                } else System.out.println("Missing or incorrect parameters. Command format: 'unlock [room direction]'");
                break;
            case "light":
                if (tokens.length == 2) {
                    Command.light(tokens[1]);
                } else System.out.println("Missing or incorrect parameters. Command format: 'light [world object]'");
                break;
            case "say":
                if (tokens.length == 2) {
                    Command.say(tokens[1]);
                } else System.out.println("Missing or incorrect parameters. Command format: 'say [word]'");
                break;
            default:
                Command.invalidCommand();
                break;

        }
    }
}
