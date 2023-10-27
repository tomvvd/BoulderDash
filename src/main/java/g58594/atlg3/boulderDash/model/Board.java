package g58594.atlg3.boulderDash.model;

import g58594.atlg3.boulderDash.model.tiles.*;

/**
 * This class represents the map with its elements.
 */
public class Board {
    private Tile[][] tiles;
    private int height;
    private int width;

    /**
     * Constructor of the class.
     */
    public Board(Tile[][] tiles, int height, int width) {
        this.tiles = tiles;
        this.height = height;
        this.width = width;
    }

    //constructeur par copie défensive
    public Board(Board board){
        this.height = board.height;
        this.width = board.width;
        this.tiles = new Tile[this.height][this.width];
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                switch (board.tiles[i][j].getName()) {
                    case "diamond" -> this.tiles[i][j] = new Diamond();
                    case "rock" -> this.tiles[i][j] = new Rock();
                    case "player" -> this.tiles[i][j] = new Player();
                    case "nothing" -> this.tiles[i][j] = new Nothing();
                    case "exit" -> this.tiles[i][j] = new Exit();
                    case "soil" -> this.tiles[i][j] = new Soil();
                    case "wall" -> this.tiles[i][j] = new Wall();
                }
            }
        }
    }

    /**
     * Method that checks if the given position is on the board.
     * @param pos Position type
     * @return true if the position is on the board and false otherwise
     */
    boolean contains(Position pos){
        return pos.getRow()< height && pos.getRow()>=0
                && pos.getColumn()<width && pos.getColumn()>=0;
    }

    /**
     * Getter of the class
     * @param pos Position type
     * @return the element at the given position
     */
    Tile getTile(Position pos){
        if (!(contains(pos))){
            throw new IllegalArgumentException("La position donnée est hors du plateau de jeu");
        }

        return tiles[pos.getRow()][pos.getColumn()];
    }

    /**
     * Setter of the class. Changes an element at a given position.
     * @param element Tile type
     * @param pos Position type
     */
    void setTile(Tile element, Position pos){
        if (!(contains(pos))){
            throw new IllegalArgumentException(
                    "La position donnée est hors du plateau de jeu");
        }

        tiles[pos.getRow()][pos.getColumn()] = element;
    }

    /**
     * Getter of the class.
     * @return int type
     */
    int getHeight() {
        return height;
    }

    /**
     * Getter of the class.
     * @return int type
     */
    int getWidth() {
        return width;
    }
}
