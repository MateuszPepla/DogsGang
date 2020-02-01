package sample.GameMechanics;

import sample.GameView.GameCamera;
import sample.objects.Floor;
import sample.player.Player;

import java.util.ArrayList;

public class Gravitation {

    private Player player;
    private ArrayList<Floor> floors;
    private double gs; // gravitation speed
    private Collisions collisions;
    private int gameSpeed;
    private GameCamera gameCamera;

    public Gravitation(Player player, ArrayList<Floor> floors, int gameSpeed, GameCamera gameCamera){
        this.player = player;
        this.gameSpeed = gameSpeed;
        this.floors = floors;
        this.collisions = new Collisions();
        this.gameCamera = gameCamera;
        gs = 0.6 * gameSpeed;
    }

    public void gravitionTic(){
        if(!collisions.checkCollisionG(floors, player, gs) && player.getGrawitation() && player.getY() > 900){
            gameCamera.cameraMoveVertical(-gs );
        } else if(!collisions.checkCollisionG(floors, player, gs) && player.getGrawitation()){
            player.setY(player.getY() + gs );
        }
    }





}
