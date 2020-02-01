package sample.player;

import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import sample.Animations.ImageReader;
import sample.GameMechanics.Collisions;
import sample.GameView.GameCamera;
import sample.objects.Floor;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class PlayerMovement {

    private double ps;
    private double js;
    private Collisions collisions;
    private ArrayList<Floor> floors;
    private ImageReader ir;

    private boolean pressedW;
    private boolean pressedS;
    private boolean pressedD;
    private boolean pressedA;
    private Player player;
    private int gameSpeed;
    private GameCamera gameCamera;

    public PlayerMovement(double ps, ArrayList<Floor> floors, Player player, int gameSpeed, GameCamera gameCamera){

        this.gameSpeed = gameSpeed;
        this.ps = ps * gameSpeed;
        this.js = 1.2;
        this.floors = floors;
        this.player = player;
        this.collisions = new Collisions();
        this.gameCamera = gameCamera;
        this.pressedW = false;
        this.pressedS = false;
        this.pressedD = false;
        this.pressedA = false;
        ir = new ImageReader();

    }

    public void move() {

        if (pressedD && !collisions.chechCollisionHR(floors, player, ps) && player.getX() > 1760){
            gameCamera.cameraMoveHorizontal(-ps);
        }
        else if (pressedA && !collisions.chechCollisionHL(floors, player, ps) && player.getX() < 800){
            gameCamera.cameraMoveHorizontal(ps);
        }
        else if (pressedD && !collisions.chechCollisionHR(floors, player, ps)){
            player.setX(player.getX() + ps);
        }
        else if (pressedA && !collisions.chechCollisionHL(floors, player, ps)){
            player.setX(player.getX() - ps);
        }

        if(pressedW && player.getY() < 500 && !collisions.checkCollisionJ(floors, player, js * gameSpeed)){
            gameCamera.cameraMoveVertical(js * gameSpeed);
        } else if(pressedW && !collisions.checkCollisionJ(floors, player, js * gameSpeed)){
            player.setY(player.getY() - js * gameSpeed);
        } else if(pressedW && collisions.checkCollisionJ(floors, player, js * gameSpeed)){
            pressedW = false;
            player.setGrawitation(false);
            Timer timer1 = new Timer();
            timer1.schedule(new TimerTask() {
                @Override
                public void run() {
                    player.setGrawitation(true);
                    js = 1.2;
                }
            }, 150);
        }
    }

    public void setKeyP(KeyEvent e){

        switch (e.getCode()) {
            case W: jump(); break;
            case S: pressedS = true; break;
            case A: pressedA  = true; ir.readImage("sample/Images/playerImages/player-move-left.gif", player);break;
            case D: pressedD  = true; ir.readImage("sample/Images/playerImages/player-move-right.gif", player);break;
        }
    }

    public void setKeyR(KeyEvent e){

        switch (e.getCode()) {
            case S: pressedS = false; break;
            case A: if(pressedA)player.setImage(new Image("sample/Images/playerImages/player.png")); pressedA  = false; break;
            case D: if(pressedD)player.setImage(new Image("sample/Images/playerImages/player.png")); pressedD  = false; break;
        }
    }

    private void jump(){

       if(collisions.checkCollisionG(floors, player, 0.6 * gameSpeed)){
           pressedW = true;
           Timer timer = new Timer();
           timer.schedule(new TimerTask() {
               @Override
               public void run() {
                   pressedW = false;
                   player.setGrawitation(false);
                   Timer timer1 = new Timer();
                   timer1.schedule(new TimerTask() {
                       @Override
                       public void run() {
                           player.setGrawitation(true);
                           js = 1.2;
                       }
                   }, 150);
               }
           }, 300);
           Timer timer2 = new Timer();
           timer2.schedule(new TimerTask() {
               @Override
               public void run() {
                   js = 0.6;
               }
           }, 200);
       }}

       private void down(){

       }

}
