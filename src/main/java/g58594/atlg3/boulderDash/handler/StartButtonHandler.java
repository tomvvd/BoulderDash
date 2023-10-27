package g58594.atlg3.boulderDash.handler;

import g58594.atlg3.boulderDash.controller.ControllerFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartButtonHandler implements EventHandler<ActionEvent> {
    private ControllerFX controller;

    public StartButtonHandler(ControllerFX controller) {
        this.controller = controller;
    }

    @Override
    public void handle(ActionEvent t) {
        controller.startGame();
        controller.addHandlers();
    }
}
