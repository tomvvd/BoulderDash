package g58594.atlg3.boulderDash.handler;

import g58594.atlg3.boulderDash.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UndoButtonHandler implements EventHandler<ActionEvent> {
    private Controller controller;

    public UndoButtonHandler(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void handle(ActionEvent t) {
        controller.undo();
    }
}
