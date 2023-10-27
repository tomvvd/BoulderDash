package g58594.atlg3.boulderDash.view;

import g58594.atlg3.boulderDash.model.Model;
import g58594.atlg3.boulderDash.model.Position;
import g58594.atlg3.boulderDash.model.tiles.Tile;
import g58594.atlg3.boulderDash.util.Observer;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ReflectView extends GridPane implements Observer {

    private Model model;

    public ReflectView(Model model){
        this.model = model;
        for (int i = 0; i < model.getHeight(); i++) {
            for (int j = 0; j < model.getWidth(); j++) {

                Position pos = new Position(i, j);
                Tile tile = model.getTile(pos);

                Image image = new Image("File:src/main/resources/image/"+tile.getName()+".png",20,20,true,true);
                this.add(new ImageView(image),j,i);
            }
        }
    }
    @Override
    public void update() {
        for (int i = 0; i < model.getHeight(); i++) {
            for (int j = 0; j < model.getWidth(); j++) {

                Position pos = new Position(i, j);
                Tile tile = model.getTile(pos);
                String name = tile.getName();

                ImageView iv = getNode(i,j,this);
                String url = iv.getImage().getUrl();

                if(!url.contains(name)){
                    iv.setImage(new Image("File:src/main/resources/image/"+tile.getName()+".png",20,20,true,true));
                }
            }
        }
    }
    private ImageView getNode(int row, int column, GridPane gridPane) {
        ImageView result = null;
        ObservableList<Node> children = gridPane.getChildren();

        for (Node node : children) {
            if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = (ImageView) node;
                break;
            }
        }

        return result;
    }
}
