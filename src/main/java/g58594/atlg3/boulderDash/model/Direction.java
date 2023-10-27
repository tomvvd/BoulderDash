package g58594.atlg3.boulderDash.model;

/**
 * It is an enumeration whose values are directions.
 */
public enum Direction {
    SOUTH(0,1),
    NORD(0,-1),
    EAST(1,0),
    WEST(-1,0),
    SOUTH_EAST(1,1),
    SOUTH_WEST(-1,1);


    private int deltaColumn;
    private int deltaRow;

    /**
     * Constructor of the enumeration.
     * @param deltaColumn int type
     * @param deltaRow int type
     */
    Direction(int deltaColumn, int deltaRow) {
        this.deltaColumn = deltaColumn;
        this.deltaRow = deltaRow;
    }

    /**
     * Getter of the enumeration.
     * @return int type
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }

    /**
     * Getter of the enumeration.
     * @return int type
     */
    public int getDeltaRow() {
        return deltaRow;
    }
}
