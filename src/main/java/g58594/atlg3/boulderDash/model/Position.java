package g58594.atlg3.boulderDash.model;

import java.util.Objects;

/**
 * This class represents a position on the board.
 */
public class Position {
    private int row;
    private int column;

    /**
     * Constructor of the class
     * @param row int type
     * @param column int type
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Getter of the class.
     * @return int type
     */
    int getRow() {
        return row;
    }

    /**
     * Getter of the class.
     * @return int type
     */
    int getColumn() {
        return column;
    }

    /**
     * Method returning a new position,
     * obtained by moving in a given direction.
     * @param dir Direction type
     * @return Position type
     */
    Position next(Direction dir){
        int nRow = this.row + dir.getDeltaRow();
        int nCol = this.column + dir.getDeltaColumn();
        return new Position(nRow,nCol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
