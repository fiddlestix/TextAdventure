package textadventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by jeffs_000 on 4/13/2017.
 */

public class FileIO {

    // *******************
    // ***** Methods *****
    // *******************

    static MapArea loadMapFromFile(String filePath) {
        MapArea newMapArea = new MapArea();
        File file = new File(filePath);
        try {
            Scanner scanner = new Scanner(file);
            String line = "";
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                /* I'll have to do this differently later, because the room descriptions will likely use
                 * commas (so they can't be used as a delimiter for splitting the string) */
                String[] tokensInLine = line.split(",");

                if (Objects.equals(tokensInLine[0].toLowerCase(), "room")) {
                    MapRoom newRoom = new MapRoom(tokensInLine[1], tokensInLine[2]);
                    newMapArea.addRoomToArea(newRoom);
                } else if (Objects.equals(tokensInLine[0].toLowerCase(), "connection")) {
                    MapRoom firstRoom = newMapArea.getRoomsInArea().get(Integer.parseInt(tokensInLine[1]));
                    MapRoom secondRoom = newMapArea.getRoomsInArea().get(Integer.parseInt(tokensInLine[2]));
                    MapArea.roomConnectionDirection connectionDirection = MapArea.getDirectionFromString(tokensInLine[3]);
                    newMapArea.connectRooms(firstRoom, secondRoom, connectionDirection);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return newMapArea;
    }
}
