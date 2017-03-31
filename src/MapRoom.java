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
 * MapRoom.java
 * A class for a single room on the map, containing loot, enemies, etc...
 */
public class MapRoom {
    private String roomEntryText;

    public MapRoom() {
        this.roomEntryText = "Default text on entering a room.";
    }

    public String getRoomEntryText() {
        return this.roomEntryText;
    }
}
