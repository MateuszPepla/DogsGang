package sample.GameView;

import javafx.scene.layout.Pane;
import sample.objects.Floor;
import sample.player.Player;

import java.util.ArrayList;


public class CharactersManager {

    private Player player;
    private ArrayList<Floor> floors;
    private Pane gameView;

    public CharactersManager(Player player, Pane gameView, ArrayList<Floor> floors){
        this.gameView = gameView;
        this.floors = floors;
        this.player = player;
    }

    public void setCharacters(){
        this.gameView.getChildren().add(this.player);
        this.player.setX(1900);
        this.player.setY(800);
    }

}
