package g58594.atlg3.boulderDash.handler;

import g58594.atlg3.boulderDash.controller.Controller;
import g58594.atlg3.boulderDash.model.Direction;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyPressHandler implements EventHandler<KeyEvent> {
    private Controller controller;

    public KeyPressHandler(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
                controller.move(Direction.NORD);
                break;
            case DOWN:
                controller.move(Direction.SOUTH);
                break;
            case LEFT:
                controller.move(Direction.WEST);
                break;
            case RIGHT:
                controller.move(Direction.EAST);
                break;
        }
    }
}
