package g58594.atlg3.boulderDash;

import g58594.atlg3.boulderDash.controller.ControllerFX;
import g58594.atlg3.boulderDash.view.BoulderDashView;
import g58594.atlg3.boulderDash.model.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Model model = new Model();
        BoulderDashView view = new BoulderDashView(stage);
        ControllerFX controller = new ControllerFX(model,view);

        view.addHandlerStartButton(controller);
    }

    public static void main(String[] args) {
        launch(args);
    }

    /**public static void main(String[] args) throws IOException {
     Model model = new Model();
     ConsoleView consoleView = new ConsoleView(model);
     ConsoleController controller = new ConsoleController(model,consoleView);
     controller.play();
     }**/
}