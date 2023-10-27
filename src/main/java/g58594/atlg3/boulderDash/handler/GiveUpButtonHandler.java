package g58594.atlg3.boulderDash.handler;

import g58594.atlg3.boulderDash.controller.ControllerFX;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GiveUpButtonHandler implements EventHandler<ActionEvent> {
    private ControllerFX controller;

    public GiveUpButtonHandler(ControllerFX controller) {
        this.controller = controller;
    }

    @Override
    public void handle(ActionEvent t) {
        controller.giveUp();
    }
}
