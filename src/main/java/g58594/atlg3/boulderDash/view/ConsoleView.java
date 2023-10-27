package g58594.atlg3.boulderDash.view;

import g58594.atlg3.boulderDash.model.Model;
import g58594.atlg3.boulderDash.model.tiles.Player;
import g58594.atlg3.boulderDash.model.Position;
import g58594.atlg3.boulderDash.model.tiles.*;

public class ConsoleView {
    private Model model;

    public ConsoleView(Model model) {
        this.model = model;
    }

    public void displayIntro(){
        System.out.println("Bienvenue dans le jeu : BoulderDash !!!");
        System.out.println("");
    }

    public void displayHelp(){
        System.out.println("Pour vous déplacer, taper :");
        System.out.println("d pour droite");
        System.out.println("g pour gauche");
        System.out.println("h pour haut");
        System.out.println("b pour bas");
        System.out.println("Pour retourner en arrière, taper :");
        System.out.println("u pour undo");
        System.out.println("Pour revenir en avant, taper :");
        System.out.println("r pour redo");
        System.out.println("Pour arrêter, taper :");
        System.out.println("e pour exit");
        System.out.println("");
    }

    public void displayAsk(){
        System.out.println("Où voulez-vous aller ?");
    }

    public void displayBoard() {
        for (int i = 0; i < model.getHeight(); i++) {
            for (int j = 0; j < model.getWidth(); j++) {
                Position pos = new Position(i,j);
                Tile tile = model.getTile(pos);
                if(tile instanceof Wall){
                    System.out.print("\u001B[35m"+'W'+"\u001B[0m");
                } else if (tile instanceof Diamond) {
                    System.out.print("\u001B[34m"+'D'+"\u001B[0m");
                } else if (tile instanceof Soil) {
                    System.out.print('S');
                } else if (tile instanceof Nothing) {
                    System.out.print(' ');
                } else if (tile instanceof Player) {
                    System.out.print("\u001B[31m"+'$'+"\u001B[0m");
                } else if (tile instanceof Exit) {
                    System.out.print("\u001B[32m"+'#'+"\u001B[0m");
                } else {
                    System.out.print("\u001B[33m"+'R'+"\u001B[0m");
                }
            }
            System.out.println();
        }
        System.out.println("");
    }

    public void displayDiamonds(){
        System.out.println("Nombre de diamands à ramasser : "+model.getNbDiamonds());
        System.out.println("Nombre de diamands ramassés : "+model.getNbDiamondsEaten());
        System.out.println();
    }

    public void displayEnd(){
        System.out.println("Félicitations, vous avez terminé le jeu !");
    }

    public void displayDead() {
        System.out.println("Vous êtes mort :(");
    }
}
