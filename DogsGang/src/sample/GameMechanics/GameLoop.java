package sample.GameMechanics;

import javafx.scene.layout.Pane;
import sample.GameView.GameCamera;
import sample.GameView.StatsViewManager;
import sample.objects.Floor;
import sample.player.Player;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameLoop {

    private Timer gameTimer;
    private Player player;
    private Gravitation gravitation;
    private ArrayList<Floor> floors;
    private int gameSpeed;
    private Pane gameView;
    private StatsViewManager svm;
    private GameCamera gameCamera;

    public GameLoop(Player player, ArrayList<Floor> floors, int gameSpeed, Pane gameView, StatsViewManager svm, GameCamera gameCamera){
        this.floors = floors;
        this.player = player;
        this.gameView = gameView;
        this.gameSpeed = gameSpeed;
        this.svm = svm;
        this.gameCamera = gameCamera;
        gravitation = new Gravitation(player, this.floors, gameSpeed, gameCamera);
        setGameTimer();
    }

    private void setGameTimer(){
        gameTimer = new Timer();
        gameTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.move();
                gravitation.gravitionTic();
                svm.refresh();
            }}, gameSpeed, gameSpeed);
    }
}
