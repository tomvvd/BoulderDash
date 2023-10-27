package g58594.atlg3.boulderDash.util;

import g58594.atlg3.boulderDash.model.Board;
import g58594.atlg3.boulderDash.model.Level;
import g58594.atlg3.boulderDash.model.Position;
import g58594.atlg3.boulderDash.model.tiles.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class loads and creates the levels for a game.
 */
public class LevelLoader {

    /**
     * Loads the level at the given number.
     * @param nb int type
     * @return Level type
     * @throws IOException
     */
    public Level loadLevel(int nb) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(LevelLoader.class.getResourceAsStream("/levels/level"+nb+".txt")));

        String name = bufferedReader.readLine();
        int nbDiamonds = Integer.parseInt(bufferedReader.readLine());

        List<String> levelList = new ArrayList<>();
        String line;
        while((line = bufferedReader.readLine()) != null){
            levelList.add(line);
        }

        int nbDiamondsRemaining = 0;
        int height = levelList.size();
        int width = levelList.get(0).length();
        Tile[][] tiles = new Tile[height][width];
        Position posPlayer = null;
        Position posExit = null;

        for (int i = 0; i < height; i++) {
            String l = levelList.get(i);
            for (int j = 0; j < width; j++) {
                char elem = l.charAt(j);
                Position pos = new Position(i,j);
                switch (elem) {
                    case 'D' -> {
                        tiles[i][j] = new Diamond();
                        nbDiamondsRemaining++;
                    }
                    case 'W' -> tiles[i][j] = new Wall();
                    case 'P' -> {
                        posPlayer = pos;
                        tiles[i][j] = new Player();
                    }
                    case 'S' -> tiles[i][j] = new Soil();
                    case 'E' -> {
                        posExit = new Position(i, j);
                        tiles[i][j] = new Wall();
                    }
                    case 'R' -> tiles[i][j] = new Rock();
                    case ' ' -> tiles[i][j] = new Nothing();
                }
            }
        }
        return new Level(name,nbDiamonds,nbDiamondsRemaining,new Board(tiles,height,width),posPlayer, posExit);
    }
}
