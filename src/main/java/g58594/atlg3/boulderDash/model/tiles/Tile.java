package g58594.atlg3.boulderDash.model.tiles;

/**
 * This class represents an element on the board.
 */
public abstract class Tile {
    protected String name;
    protected boolean isDestructible;
    protected boolean isMovable;

    protected boolean canFall;

    /**
     * Constructor of the class
     * @param name String type
     * @param isDestructible boolean type
     * @param isMovable boolean type
     * @param canFall boolean type
     */
    public Tile(String name, boolean isDestructible, boolean isMovable, boolean canFall) {
        this.name = name;
        this.isDestructible = isDestructible;
        this.isMovable = isMovable;
        this.canFall = canFall;
    }

    /**
     * Getter of the class.
     * @return String type
     */
    public String getName() {
        return name;
    }

    /**
     * Getter of the class.
     * @return boolean type
     */
    public boolean isDestructible() {
        return isDestructible;
    }

    /**
     * Getter of the class.
     * @return boolean type
     */
    public boolean isMovable() {
        return isMovable;
    }

    /**
     * Getter of the class.
     * @return boolean type
     */
    public boolean isCanFall() {
        return canFall;
    }
}
