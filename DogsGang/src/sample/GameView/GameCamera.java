package sample.GameView;

import javafx.scene.layout.Pane;
import sample.objects.Floor;
import sample.player.Player;

import java.util.ArrayList;

public class GameCamera {

    private Pane GameView;
    private Player player;
    private ArrayList<Floor> floors;

    public GameCamera(Pane gameView, Player player, ArrayList<Floor> floors){
        this.floors = floors;
        this.GameView = gameView;
        this.player = player;
    }


    public void cameraMoveHorizontal(double moveSpeed){
        for(int i=0; i<floors.size(); i++)
            floors.get(i).setX(floors.get(i).getX() + moveSpeed);
    }

    public void cameraMoveVertical(double moveSpeed){
        for(int i=0; i<floors.size(); i++)
            floors.get(i).setY(floors.get(i).getY() + moveSpeed);
    }


}
