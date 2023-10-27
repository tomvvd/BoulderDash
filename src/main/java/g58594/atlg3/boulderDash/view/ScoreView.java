package g58594.atlg3.boulderDash.view;

import g58594.atlg3.boulderDash.model.Model;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ScoreView extends HBox {
    private Model model;
    private Label nbDiamonds;
    private Label nbDiamondsEaten;
    private Label nbDiamondsRemaining;
    private boolean autorisation;

    public ScoreView(Model model){
        super(20); //espace de 20 entre les labels
        this.model = model;

        nbDiamonds = new Label(Integer.toString(model.getNbDiamonds()));
        nbDiamonds.setTextFill(Color.WHITE);
        nbDiamonds.setFont(new Font("Britannic Bold",20));

        nbDiamondsEaten = new Label(Integer.toString(model.getNbDiamondsEaten()));
        nbDiamondsEaten.setTextFill(Color.WHITE);
        nbDiamondsEaten.setFont(new Font("Britannic Bold",20));

        nbDiamondsRemaining = new Label(Integer.toString(model.getNbDiamondsRemaining()));
        nbDiamondsRemaining.setTextFill(Color.WHITE);
        nbDiamondsRemaining.setFont(new Font("Britannic Bold",20));

        autorisation = true;

        this.getChildren().addAll(nbDiamondsEaten,nbDiamonds,nbDiamondsRemaining);
    }

    public void update(){
        nbDiamonds.setText(Integer.toString(model.getNbDiamonds()));
        nbDiamondsEaten.setText(Integer.toString(model.getNbDiamondsEaten()));
        nbDiamondsRemaining.setText(Integer.toString(model.getNbDiamondsRemaining()));

        if(model.getNbDiamonds()==model.getNbDiamondsEaten() && autorisation){
            Image esc = new Image(ScoreView.class.getResourceAsStream("/image/escape.png"),20,20,true,true);
            this.getChildren().add(new ImageView(esc));
            autorisation = false;
        }
    }
}
