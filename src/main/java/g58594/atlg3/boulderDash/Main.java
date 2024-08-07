package g58594.atlg3.boulderDash;

import g58594.atlg3.boulderDash.controller.Controller;
import g58594.atlg3.boulderDash.view.View;
import g58594.atlg3.boulderDash.model.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Model model = new Model();
        View view = new View(stage);
        Controller controller = new Controller(model,view);

        view.addHandlerStartButton(controller);
    }

    public static void main(String[] args) {
        launch(args);
    }
}