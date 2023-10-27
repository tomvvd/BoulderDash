/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58594.atlg3.boulderDash.model;

import g58594.atlg3.boulderDash.model.tiles.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author thoma
 */
public class ModelTest {

    private Model model;

    @BeforeEach     // Exécutée avant chaque test
    public void setUp() throws IOException {
        model = new Model();
    }

    // **************** testContains *****************

    /**
     * Test of startLevel method, of class Model.
     */
    @Test
    public void testStartLevel_Not_Exist() {
        int nb = -1;
        assertThrows(NullPointerException.class, () -> model.startLevel(nb));
    }

    /**
     * Test of startLevel method, of class Model.
     */
    @Test
    public void testStartLevel_0() throws Exception {
        int nb = 0;
        model.startLevel(nb);
        // D WPSER
        // exit est un objet Wall lors du chargement et change en Exit lorsque les conditions sont remplies
        boolean result = true;
        String[][] tilesName = {{"diamond","nothing","wall","player","soil","wall","rock"}};
        for (int i = 0; i < model.getHeight() && result; i++) {
            for (int j = 0; j < model.getWidth() && result; j++) {
                Tile target = model.getTile(new Position(i,j));
                result = (target.getName()).equals(tilesName[i][j]);
            }
        }
        assertTrue(result);
    }

    /**
     * Test of startLevel method, of class Model.
     */
    @Test
    public void testStartLevel_1() throws Exception {
        int nb = 1;
        model.startLevel(nb);
        //WWWWWW
        //W ESRW
        //WDSSPW
        //WWWWWW
        boolean result = true;
        String[][] tilesName = {{"wall","wall","wall","wall","wall","wall"},
                {"wall","nothing","wall","soil","rock","wall"},
                {"wall","diamond","soil","soil","player","wall"},
                {"wall","wall","wall","wall","wall","wall"}};
        for (int i = 0; i < model.getHeight() && result; i++) {
            for (int j = 0; j < model.getWidth() && result; j++) {
                Tile target = model.getTile(new Position(i,j));
                result = (target.getName()).equals(tilesName[i][j]);
            }
        }
        assertTrue(result);
    }

    /**
     * Test of move method, of class Model.
     */
    @Test
    public void testMove_Out_Of_Map() throws IOException {
        int nb = 2;
        model.startLevel(nb);
        //P
        assertThrows(IllegalArgumentException.class, () -> model.move(Direction.SOUTH));
    }

    /**
     * Test of move method, of class Model.
     */
    @Test
    public void testMove_Blocked_By_Walls() throws IOException {
        int nb = 3;
        model.startLevel(nb);
        //WWW
        //WPW
        //WWW
        model.move(Direction.NORD);
        model.move(Direction.SOUTH);
        model.move(Direction.WEST);
        model.move(Direction.EAST);
        boolean result = true;
        String[][] tilesName = {{"wall","wall","wall"},
                {"wall","player","wall"},
                {"wall","wall","wall"}};
        for (int i = 0; i < model.getHeight() && result; i++) {
            for (int j = 0; j < model.getWidth() && result; j++) {
                Tile target = model.getTile(new Position(i,j));
                result = (target.getName()).equals(tilesName[i][j]);
            }
        }
        assertTrue(result);
    }

    /**
     * Test of move method, of class Model.
     */
    @Test
    public void testMove_Rock_Diamond() throws IOException {
        int nb = 4;
        model.startLevel(nb);
        //WWWWWWW
        //WSRSRSW
        //W DPR W
        //WRR RRW
        //WWWWWWW
        model.move(Direction.EAST);
        model.move(Direction.EAST);
        model.move(Direction.WEST);
        model.move(Direction.WEST);
        //WWWWWWW
        //WS S SW
        //WRP RRW
        //WRRDRRW
        //WWWWWWW
        boolean result = true;
        String[][] tilesName = {{"wall","wall","wall","wall","wall","wall","wall"},
                {"wall","soil","nothing","soil","nothing","soil","wall"},
                {"wall","rock","player","nothing","rock","rock","wall"},
                {"wall","rock","rock","diamond","rock","rock","wall"},
                {"wall","wall","wall","wall","wall","wall","wall"}};
        for (int i = 0; i < model.getHeight() && result; i++) {
            for (int j = 0; j < model.getWidth() && result; j++) {
                Tile target = model.getTile(new Position(i,j));
                result = (target.getName()).equals(tilesName[i][j]);
            }
        }
        assertTrue(result);
    }

    /**
     * Test of undo method, of class Model.
     */
    @Test
    public void testUndo() throws IOException {
        int nb = 5;
        model.startLevel(nb);
        //WWWWWWW
        //WPSDR W
        //WWWWWWW
        for (int i = 0; i < 3; i++) {
            model.move(Direction.EAST);
        }
        for (int i = 0; i < 3; i++) {
            model.undo();
        }
        boolean result = true;
        String[][] tilesName = {{"wall","wall","wall","wall","wall","wall","wall"},
                {"wall","player","soil","diamond","rock","nothing","wall"},
                {"wall","wall","wall","wall","wall","wall","wall"}};
        for (int i = 0; i < model.getHeight() && result; i++) {
            for (int j = 0; j < model.getWidth() && result; j++) {
                Tile target = model.getTile(new Position(i,j));
                result = (target.getName()).equals(tilesName[i][j]);
            }
        }
        assertTrue(result);
    }

    /**
     * Test of redo method, of class Model.
     */
    @Test
    public void testRedo() throws IOException {
        int nb = 5;
        model.startLevel(nb);
        //WWWWWWW
        //WPSDR W
        //WWWWWWW
        for (int i = 0; i < 3; i++) {
            model.move(Direction.EAST);
        }
        for (int i = 0; i < 3; i++) {
            model.undo();
        }
        for (int i = 0; i < 3; i++) {
            model.redo();
        }
        //WWWWWWW
        //W   PRW
        //WWWWWWW
        boolean result = true;
        String[][] tilesName = {{"wall","wall","wall","wall","wall","wall","wall"},
                {"wall","nothing","nothing","nothing","player","rock","wall"},
                {"wall","wall","wall","wall","wall","wall","wall"}};
        for (int i = 0; i < model.getHeight() && result; i++) {
            for (int j = 0; j < model.getWidth() && result; j++) {
                Tile target = model.getTile(new Position(i,j));
                result = (target.getName()).equals(tilesName[i][j]);
            }
        }
        assertTrue(result);
    }
    
}
