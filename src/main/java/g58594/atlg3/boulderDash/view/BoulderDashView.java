package g58594.atlg3.boulderDash.view;

import g58594.atlg3.boulderDash.controller.ControllerFX;
import g58594.atlg3.boulderDash.handler.*;
import g58594.atlg3.boulderDash.model.*;
import g58594.atlg3.boulderDash.util.Observer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class BoulderDashView implements Observer{

    private Stage stage;
    private Scene scene;
    private VBox root;
    private CaveView caveView;
    private ScoreView scoreView;
    private Button startButton;
    private ChoiceBox<Integer> levelChoice;
    private Button giveUpButton;
    private Button undoButton;
    private Button redoButton;

    public BoulderDashView(Stage stage) {
        this.stage = stage;
        stage.setTitle("Boulder Dash");

        //afin d'éviter de créer une nouvelle instance à chaque appel de showHome() via le bouton giveup
        // et perdre le comportement du bouton
        startButton = new Button("start");
        showHome();
    }

    public void showHome(){
        root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        Image logo = new Image(BoulderDashView.class.getResourceAsStream("/image/logo.png"));

        Label choiceLabel = new Label("Faites votre choix de niveau :");
        choiceLabel.setTextFill(Color.WHITE);
        choiceLabel.setFont(new Font("Britannic Bold",20));

        levelChoice = new ChoiceBox<>();
        levelChoice.getItems().addAll(1,2,3);
        levelChoice.setValue(1);

        root.getChildren().addAll(new ImageView(logo),choiceLabel,levelChoice, startButton);

        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public int getLevelChoice(){
        return levelChoice.getValue();
    }

    public void addHandlerStartButton(ControllerFX controller) {
        StartButtonHandler startButtonHandler = new StartButtonHandler(controller);
        startButton.setOnAction(startButtonHandler);
    }

    public void showGame(Model model) throws IOException {
        root = new VBox();
        root.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY)));

        scoreView = new ScoreView(model);
        caveView = new CaveView(model);

        HBox options = new HBox(20);

        undoButton = new Button("undo");
        undoButton.setFocusTraversable(false);

        redoButton = new Button("redo");
        redoButton.setFocusTraversable(false);

        giveUpButton = new Button("give up");
        giveUpButton.setFocusTraversable(false);

        options.getChildren().addAll(undoButton,redoButton,giveUpButton);

        root.getChildren().addAll(scoreView,caveView,options);

        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public void addHandlerScene(ControllerFX controller){
        KeyPressHandler keyPressHandler = new KeyPressHandler(controller);
        scene.setOnKeyPressed(keyPressHandler);
    }

    public void addHandlerUndoButton(ControllerFX controller){
        UndoButtonHandler undoButtonHandler = new UndoButtonHandler(controller);
        undoButton.setOnAction(undoButtonHandler);
    }

    public void addHandlerRedoButton(ControllerFX controller){
        RedoButtonHandler redoButtonHandler = new RedoButtonHandler(controller);
        redoButton.setOnAction(redoButtonHandler);
    }

    public void addHandlerGiveUpButton(ControllerFX controller){
        GiveUpButtonHandler giveUpButtonHandler = new GiveUpButtonHandler(controller);
        giveUpButton.setOnAction(giveUpButtonHandler);
    }

    public void showEnd() {
        root = new VBox(20);

        Image end = new Image(BoulderDashView.class.getResourceAsStream("/image/end.png"));

        root.getChildren().addAll(new ImageView(end));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void update() {
        caveView.update();
        scoreView.update();
    }
}
