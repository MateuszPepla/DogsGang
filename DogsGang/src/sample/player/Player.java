package sample.player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import sample.GameView.GameCamera;
import sample.objects.Floor;

import java.util.ArrayList;

public class Player extends ImageView {

    private Image image;
    private ArrayList<Floor> floors;
    private boolean grawitation;
    private int gameSpeed;
    private Pane gameView;
    private GameCamera gamecamera;
    private double ps; // player speed
    private PlayerMovement pm;


    private int maxHP;
    private int HP;
    private int defense;
    private int critStrike;
    private int maxDamage;
    private int minDamage;
    private int money;




    public Player(ArrayList<Floor> floors, int gameSpeed, Pane gameView) {
        this.gameView = gameView;
        this.gameSpeed = gameSpeed;
        this.floors = floors;
        setPlayer();
    }

    private void setPlayer(){
        setPlayersMechanics();
        setPlayerStats();
    }

    private void setPlayersMechanics(){
        this.image = new Image("sample/Images/playerImages/player-move-left.gif");
        this.setImage(this.image);
        this.gamecamera = new GameCamera(gameView, this, floors);
        grawitation = true;
        ps = 0.4;
        pm = new PlayerMovement(ps, floors, this, gameSpeed, gamecamera);
    }

    private void setPlayerStats(){
        maxHP = 100;
        HP = 100;
        maxDamage = 15;
        minDamage = 5;
        defense = 0;
        critStrike = 0;
    }

    public void move() {
       pm.move();
    }

    public void setKeyP(KeyEvent e){
        pm.setKeyP(e);
    }

    public void setKeyR(KeyEvent e){
      pm.setKeyR(e);
    }

    /// Getters ///
    public boolean getGrawitation(){return grawitation;}
    public int getMaxHP(){return maxHP;}
    public int getDefense() { return defense; }
    public int getCritStrike() { return critStrike; }
    public int getHP() { return HP; }
    public int getMaxDamage() { return maxDamage; }
    public int getMinDamage() { return minDamage; }
    public int getMoney() { return money; }

    /// Setters ///
    public void setGrawitation(boolean g){grawitation = g;}

    public void setCritStrike(int critStrike) { this.critStrike = critStrike; }
    public void setDefense(int defense) { this.defense = defense; }
    public void setHP(int HP) { this.HP = HP; }
    public void setMaxDamage(int maxDamage) { this.maxDamage = maxDamage; }
    public void setMaxHP(int maxHP) { this.maxHP = maxHP; }
    public void setMinDamage(int minDamage) { this.minDamage = minDamage; }
    public void setMoney(int money) { this.money = money; }
}

