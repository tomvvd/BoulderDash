package g58594.atlg3.boulderDash.model;

import g58594.atlg3.boulderDash.model.tiles.Tile;

/**
 * This class represents a level.
 */
public class Level {
    private String name;
    private int nbDiamonds;
    private int nbDiamondsEaten;
    private int nbDiamondsRemaining;
    private Board board;
    private Position posPlayer;
    private Position posExit;
    private boolean isDead;

    /**
     * Constructor of the class
     *
     * @param name                String type
     * @param nbDiamonds          int type
     * @param nbDiamondsRemaining int type
     * @param board               Board type
     * @param posPlayer           Position type
     * @param posExit             Position type
     */
    public Level(String name, int nbDiamonds, int nbDiamondsRemaining, Board board, Position posPlayer, Position posExit) {
        this.name = name;
        this.nbDiamonds = nbDiamonds;
        this.nbDiamondsEaten = 0;
        this.nbDiamondsRemaining = nbDiamondsRemaining;
        this.board = board;
        this.posPlayer = posPlayer;
        this.posExit = posExit;
        isDead = false;
    }

    /**
     * This method allows to get an element at a given position.
     * @param pos Position type
     * @return Tile type
     */
    Tile getTile(Position pos){
        return board.getTile(pos);
    }

    /**
     * This method changes an element at a given position.
     * @param element Tile type
     * @param pos Position type
     */
    void setTile(Tile element, Position pos){
        board.setTile(element,pos);
    }

    /**
     * Getter of the class.
     * @return String type
     */
    String getName() {
        return name;
    }

    /**
     * Getter of the class.
     * @return int type
     */
    int getNbDiamonds() {
        return nbDiamonds;
    }

    /**
     * Getter of the class.
     * @return int type
     */
    int getNbDiamondsEaten() {
        return nbDiamondsEaten;
    }

    /**
     * Getter of the class.
     * @return int type
     */
    int getNbDiamondsRemaining() {
        return nbDiamondsRemaining;
    }

    /**
     * Getter of the class.
     * @return int type
     */
    int getHeight() {
        return board.getHeight();
    }

    /**
     * Getter of the class.
     * @return int type
     */
    int getWidth() {
        return board.getWidth();
    }

    /**
     * Getter of the class.
     * @return Position type
     */
    Position getPosPlayer() {
        return posPlayer;
    }

    /**
     * Getter of the class.
     * @return Position type
     */
    Position getPosExit() {
        return posExit;
    }

    /**
     * Getter of the class.
     * @return boolean type
     */
    boolean isDead() {
        return isDead;
    }

    /**
     * Defensive copy of the board attribute.
     * @return Board type
     */
    Board getBoard() {
        return new Board(this.board);
    }

    /**
     * Setter of the class.
     * @param nbDiamondsEaten int type
     */
    void setNbDiamondsEaten(int nbDiamondsEaten) {
        this.nbDiamondsEaten = nbDiamondsEaten;
    }

    /**
     * Setter of the class.
     * @param nbDiamondsRemaining int type
     */
    void setNbDiamondsRemaining(int nbDiamondsRemaining) {
        this.nbDiamondsRemaining = nbDiamondsRemaining;
    }

    /**
     * Setter of the class.
     * @param board Board type
     */
    void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Setter of the class.
     * @param posPlayer Position type
     */
    void setPosPlayer(Position posPlayer) {
        this.posPlayer = posPlayer;
    }

    /**
     * Setter of the class.
     * @param dead boolean type
     */
    void setDead(boolean dead) {
        isDead = dead;
    }

    @Override
    public String toString() {
        return name;
    }
}
