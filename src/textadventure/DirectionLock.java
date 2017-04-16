package textadventure;

/**
 * Created by jeffs_000 on 4/16/2017.
 */

public class DirectionLock {
    private Boolean isLocked;
    private String name;
    private String description;
    private String identifier;

    DirectionLock(String newName, String newDescription, String newIdentifier) {
        this.name = newName;
        this.description = newDescription;
        this.identifier = newIdentifier;
        this.isLocked = false;
    }

    public DirectionLock() {
        this.name = "Default lock name";
        this.description = "Default lock description";
        this.identifier = "lock";
        this.isLocked = false;
    }

    public Boolean checkIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean locked) {
        isLocked = locked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
