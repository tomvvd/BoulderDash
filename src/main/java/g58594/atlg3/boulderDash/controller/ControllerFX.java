package g58594.atlg3.boulderDash.controller;

import g58594.atlg3.boulderDash.model.Direction;
import g58594.atlg3.boulderDash.model.Model;
import g58594.atlg3.boulderDash.view.BoulderDashView;

import java.io.IOException;

public class ControllerFX {
    private Model model;
    private BoulderDashView view;

    public ControllerFX(Model model, BoulderDashView view) {
        this.model = model;
        this.view = view;
        model.register(view);
    }

    //pas besoin d'une méthode initialize
    // étant donné qu'il ne faut pas de données du modèle pour créer la page d'accueil

    public void startGame() {
        try {
            view.showGame(model);
            model.startLevel(view.getLevelChoice());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void move(Direction dir){
        model.move(dir);
        try {
            if (model.isDead()) {
                model.startLevel(model.getNb());
            }
            if (model.isLevelOver()) {
                if(model.getNb()<3) {
                    model.startLevel(model.getNb() + 1);
                }else{
                    view.showEnd();
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void reflect() {
        view.reflect(model);
    }

    public void giveUp() {
        view.showHome();
    }

    public void redo() {
        model.redo();
    }

    public void undo() {
        model.undo();
    }

    public void addHandlers() {
        view.addHandlerScene(this);
        view.addHandlerGiveUpButton(this);
        view.addHandlerRedoButton(this);
        view.addHandlerUndoButton(this);
    }
}
