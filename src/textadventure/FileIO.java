package textadventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

/**
 * A class that contains all of the functionality for file input and output.
 */
class FileIO {

    // *******************
    // ***** Methods *****
    // *******************

    /**
     * Creates a MapArea object using data from a txt file.
     * The txt file is hard-coded into the application as 'map.txt'.
     * @return The MapArea object created from the data in the file.
     */
    static MapArea loadMapFromFile() {
        MapArea newMapArea = new MapArea();

        String fileName = "src" + File.separator + "map.txt";
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] tokensInLine = line.split("\\$"); // $ (dollar) symbol used to split parameters for room
                if (Objects.equals(tokensInLine[0].toLowerCase(), "room")) {
                    MapRoom newRoom = new MapRoom(tokensInLine[1], tokensInLine[2]);
                    newMapArea.addRoomToArea(newRoom);
                } else if (Objects.equals(tokensInLine[0].toLowerCase(), "connection")) {
                    MapRoom firstRoom = newMapArea.getRoomsInArea().get(Integer.parseInt(tokensInLine[1]));
                    MapRoom secondRoom = newMapArea.getRoomsInArea().get(Integer.parseInt(tokensInLine[2]));
                    MapArea.roomConnectionDirection connectionDirection = MapArea.getDirectionFromString(tokensInLine[3]);
                    newMapArea.connectRooms(firstRoom, secondRoom, connectionDirection);
                } else if (Objects.equals(tokensInLine[0].toLowerCase(), "item")) {
                    MapRoom room = newMapArea.getRoomsInArea().get(Integer.parseInt(tokensInLine[1]));
                    String itemName = tokensInLine[2];
                    String itemDescription = tokensInLine[3];
                    String itemIdentifier = tokensInLine[4];
                    Item item = new Item(itemName, itemDescription, itemIdentifier);
                    room.getItemsInRoom().add(item);
                } else if (Objects.equals(tokensInLine[0].toLowerCase(), "lock")) {
                    MapRoom room = newMapArea.getRoomsInArea().get(Integer.parseInt(tokensInLine[1]));
                    String lockType = tokensInLine[2];
                    MapArea.roomConnectionDirection direction = MapArea.getDirectionFromString(tokensInLine[3]);
                    if (Objects.equals(lockType.toLowerCase(), "wheel")) {
                        room.addLockToDirection(direction, new Wheel());
                    } else if (Objects.equals(lockType.toLowerCase(), "lever")) {
                        room.addLockToDirection(direction, new Lever());
                    } else if (Objects.equals(lockType.toLowerCase(), "fireplace")) {
                        room.addLockToDirection(direction, new Fireplace());
                    }
                } else if (Objects.equals(tokensInLine[0].toLowerCase(), "keylock")) {
                    MapRoom room = newMapArea.getRoomsInArea().get(Integer.parseInt(tokensInLine[1]));
                    MapArea.roomConnectionDirection direction = MapArea.getDirectionFromString(tokensInLine[2]);
                    Integer doorKeyID = Integer.parseInt(tokensInLine[3]);
                    room.addLockToDirection(direction, new KeyLock(doorKeyID));
                } else if (Objects.equals(tokensInLine[0].toLowerCase(), "key")) {
                    MapRoom room = newMapArea.getRoomsInArea().get(Integer.parseInt(tokensInLine[1]));
                    Integer keyID = Integer.parseInt(tokensInLine[2]);
                    room.getItemsInRoom().add(new Key(keyID, tokensInLine[3]));
                } else if (Objects.equals(tokensInLine[0].toLowerCase(), "matches")) {
                    MapRoom room = newMapArea.getRoomsInArea().get(Integer.parseInt(tokensInLine[1]));
                    room.getItemsInRoom().add(new Matches());
                } else if (Objects.equals(tokensInLine[0].toLowerCase(), "droplock")) {
                    MapRoom room = newMapArea.getRoomsInArea().get(Integer.parseInt(tokensInLine[1]));
                    room.addLockToDirection(MapArea.getDirectionFromString(tokensInLine[2]), new DropLock(tokensInLine[3]));
                } else if (Objects.equals(tokensInLine[0].toLowerCase(), "riddlelock")) {
                    MapRoom room = newMapArea.getRoomsInArea().get(Integer.parseInt(tokensInLine[1]));
                    MapArea.roomConnectionDirection direction = MapArea.getDirectionFromString(tokensInLine[2]);
                    String riddleAnswer = tokensInLine[3];
                    room.addLockToDirection(direction, new RiddleLock(riddleAnswer));
                } else if (Objects.equals(tokensInLine[0].toLowerCase(), "storytext")) {
                    MapRoom room = newMapArea.getRoomsInArea().get(Integer.parseInt(tokensInLine[1]));
                    room.setRoomEntryStoryText(tokensInLine[2]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return newMapArea;
    }

    /**
     * Splits a string into multiple lines if they exceed the given character limit.
     * @param text String to break up.
     * @param lineLimit Character limit to stop line at.
     * @return Formatted string split up into multiple lines.
     */
    static String formatTextForConsole(String text, Integer lineLimit) {
        int lineLength = 0;
        String formattedText = "";
        String[] textWords = text.split(" ");

        for (String word : textWords) {
            if (lineLength > lineLimit) {
                formattedText = formattedText + "\n" + word + " ";
                lineLength = 0;
            } else {
                formattedText = formattedText + word + " ";
                lineLength = lineLength + word.length();
            }
        }
        return formattedText;
    }
}
