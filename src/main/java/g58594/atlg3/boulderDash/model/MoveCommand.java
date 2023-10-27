package g58594.atlg3.boulderDash.model;

import g58594.atlg3.boulderDash.model.tiles.*;

/**
 * This class represents the move command.
 */
public class MoveCommand implements Command{
    private Board copyBoard;
    private Level level;
    private Direction dir;
    private int nbEaten;
    private int nbRemaining;
    private Position posPlayer;

    /**
     * Constructor of the class.
     * @param level Level type
     * @param dir Direction type
     */
    public MoveCommand(Level level,Direction dir) {
        this.copyBoard = level.getBoard();
        this.level = level;
        this.dir = dir;
        this.nbEaten = level.getNbDiamondsEaten();
        this.nbRemaining = level.getNbDiamondsRemaining();
        this.posPlayer = new Position(level.getPosPlayer().getRow(),level.getPosPlayer().getColumn());
    }

    @Override
    public void execute() {
        this.copyBoard = level.getBoard();
        Position newPos = posPlayer.next(dir);
        Tile target = level.getTile(newPos);
        if(target.isDestructible()){
            if(target instanceof Diamond){
                level.setNbDiamondsEaten(nbEaten+1);
                level.setNbDiamondsRemaining(nbRemaining-1);
            }
            level.setTile(new Player(),newPos);
            level.setTile(new Nothing(),posPlayer);
            level.setPosPlayer(newPos);
        }else if (target.isMovable() && (dir == Direction.EAST || dir == Direction.WEST)){
            Position newNewpos = newPos.next(dir);
            if (level.getTile(newNewpos) instanceof Nothing){
                level.setTile(target,newNewpos);
                level.setTile(new Player(),newPos);
                level.setTile(new Nothing(),posPlayer);
                level.setPosPlayer(newPos);
            }
        }
        if (level.getNbDiamondsEaten()>=level.getNbDiamonds()){
            level.setTile(new Exit(),level.getPosExit());
        }
        while (fall()){}
    }

    /**
     * This method allows stones and diamonds to fall.
     * @return boolean type
     */
    private boolean fall(){
        for (int i = 0; i < level.getHeight(); i++) {
            for (int j = 0; j < level.getWidth(); j++) {
                Position pos = new Position(i,j);
                Tile target = level.getTile(pos);
                if (target.isCanFall()){
                    Position posS = pos.next(Direction.SOUTH);
                    if (level.getTile(posS) instanceof Nothing){
                        level.setTile(new Nothing(),pos);
                        level.setTile(target,posS);
                        if(level.getTile(posS.next(Direction.SOUTH)) instanceof Player){
                            level.setDead(true);
                        }
                        return true;
                    }
                    Position posSW = pos.next(Direction.SOUTH_WEST);
                    if (level.getTile(posS).isCanFall() && level.getTile(posSW) instanceof Nothing && level.getTile(pos.next(Direction.WEST)) instanceof Nothing){
                        level.setTile(new Nothing(),pos);
                        level.setTile(target,pos.next(Direction.WEST));
                        if(level.getTile(posSW.next(Direction.SOUTH)) instanceof Player){
                            level.setDead(true);
                        }
                        return true;
                    }
                    Position posSE = pos.next(Direction.SOUTH_EAST);
                    if (level.getTile(posS).isCanFall() && level.getTile(posSE) instanceof Nothing && level.getTile(pos.next(Direction.EAST)) instanceof Nothing){
                        level.setTile(new Nothing(),pos);
                        level.setTile(target,pos.next(Direction.EAST));
                        if(level.getTile(posSE.next(Direction.SOUTH)) instanceof Player){
                            level.setDead(true);
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void unexecute() {
        level.setBoard(copyBoard);
        level.setNbDiamondsEaten(nbEaten);
        level.setNbDiamondsRemaining(nbRemaining);
        level.setPosPlayer(posPlayer);
    }
}
