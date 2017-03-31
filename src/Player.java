/**
 * Created by jeffs_000 on 3/31/2017.
 */
public class Player {
    private MapRoom currentMapRoom;

    public Player(MapRoom startingMapRoom) {
        currentMapRoom = startingMapRoom;
    }

    public MapRoom getCurrentMapRoom() {
        return this.currentMapRoom;
    }

    public boolean movePlayerToMapRoom(MapRoom newMapRoom) {
        if (this.currentMapRoom.getConnectedMapRooms().contains(newMapRoom)) {
            this.currentMapRoom = newMapRoom;
            System.out.println(newMapRoom.getRoomEntryText()); // 'enter' the room, change this later!
            return true;
        } else {
            System.out.println("You cannot move there"); // change this later!
            return false;
        }
    }
}
