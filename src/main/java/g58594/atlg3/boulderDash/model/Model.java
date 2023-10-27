package g58594.atlg3.boulderDash.model;

import g58594.atlg3.boulderDash.model.tiles.*;
import g58594.atlg3.boulderDash.util.LevelLoader;
import g58594.atlg3.boulderDash.util.Observable;
import g58594.atlg3.boulderDash.util.Observer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the model's facade.
 */
public class Model implements Observable {
    private Level level;
    private List<Observer> observers = new ArrayList<>();
    private int nb;
    private CommandManager cmdMng;

    /**
     * Constructor of the class.
     * @throws IOException
     */
    public Model() throws IOException {
        this.nb = 1;
        LevelLoader levelLoader = new LevelLoader();
        level = levelLoader.loadLevel(nb);
        cmdMng = new CommandManager();
    }

    /**
     * This method allows to start a game by choosing the level
     * @param nb int type
     * @throws IOException
     */
    public void startLevel(int nb) throws IOException {
        this.nb = nb;
        LevelLoader levelLoader = new LevelLoader();
        level = levelLoader.loadLevel(nb);
        cmdMng = new CommandManager();
        notifyObservers();
    }

    /**
     * This method allows to get an element at a given position.
     * @param pos Position type
     * @return Tile type
     */
    public Tile getTile(Position pos) {
        return level.getTile(pos);
    }

    /**
     * This method allows to move the player.
     * @param dir Direction type
     */
    public void move(Direction dir) {
        Command command = new MoveCommand(level,dir);
        cmdMng.addCommand(command);
        notifyObservers();
    }

    /**
     * This method allows to know if the level is over.
     * @return boolean type
     */
    public boolean isLevelOver() { return level.getPosPlayer().equals(level.getPosExit());
    }

    /**
     * This method allows to know if the level is lost.
     * @return boolean type
     */
    public boolean isDead(){
        return level.isDead();
    }

    /**
     * Getter of the class
     * @return int type
     */
    public int getHeight() {
        return level.getHeight();
    }

    /**
     * Getter of the class
     * @return int type
     */
    public int getWidth() {
        return level.getWidth();
    }

    /**
     * Getter of the class
     * @return int type
     */
    public int getNbDiamonds() {
        return level.getNbDiamonds();
    }

    /**
     * Getter of the class
     * @return int type
     */
    public int getNbDiamondsEaten() {
        return level.getNbDiamondsEaten();
    }

    /**
     * Getter of the class
     * @return int type
     */
    public int getNb() {
        return nb;
    }

    /**
     * Getter of the class.
     * @return int type
     */
    public int getNbDiamondsRemaining() {
        return level.getNbDiamondsRemaining();
    }

    @Override
    public void register(Observer observer) {
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    /**
     * This method allows to warn the observers if there is a change.
     */
    private void notifyObservers() {
        for (Observer obs:observers){
            obs.update();
        }
    }

    /**
     * This method allows to undo a command.
     */
    public void undo(){
        cmdMng.undo();
        notifyObservers();
    }

    /**
     * This method allows to redo a command.
     */
    public void redo(){
        cmdMng.redo();
        notifyObservers();
    }
}
