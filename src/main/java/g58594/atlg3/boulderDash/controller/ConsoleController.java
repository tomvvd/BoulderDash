package g58594.atlg3.boulderDash.controller;

import g58594.atlg3.boulderDash.model.Model;
import g58594.atlg3.boulderDash.model.Direction;
import g58594.atlg3.boulderDash.view.ConsoleView;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleController {
    private Model model;
    private ConsoleView consoleView;

    public ConsoleController(Model model, ConsoleView consoleView) {
        this.model = model;
        this.consoleView = consoleView;
    }

    public void play() throws IOException {
        Scanner clavier = new Scanner(System.in);

        consoleView.displayIntro();
        consoleView.displayHelp();

        try{
            while(!model.isDead()) {
                if (!model.isLevelOver()) {
                    consoleView.displayDiamonds();
                    consoleView.displayBoard();
                    consoleView.displayAsk();

                    try {
                        String res = clavier.nextLine();
                        switch (res) {
                            case "d":
                                model.move(Direction.EAST);
                                break;
                            case "g":
                                model.move(Direction.WEST);
                                break;
                            case "h":
                                model.move(Direction.NORD);
                                break;
                            case "b":
                                model.move(Direction.SOUTH);
                                break;
                            case "u":
                                model.undo();
                                break;
                            case "r":
                                model.redo();
                                break;
                            case "e":
                                return;
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }else {
                    model.startLevel(model.getNb() + 1);
                }
            }
            consoleView.displayDead();
        }catch (NullPointerException e){
            consoleView.displayEnd();
        }
    }
}
