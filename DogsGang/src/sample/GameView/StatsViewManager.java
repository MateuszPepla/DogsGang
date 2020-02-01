package sample.GameView;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import sample.player.Player;



public class StatsViewManager {

    private HBox statsView;
    private Player player;

    private Label hp;
    private ImageView hpImg;
    private Label defense;
    private ImageView defenseImg;
    private Label critStrike;
    private ImageView csImg;
    private Label damage;
    private ImageView damageIng;
    private Label money;
    private ImageView moneyImg;

    public StatsViewManager(HBox statsView, Player player){
        this.player = player;
        this.statsView = statsView;
        setImages();
        setLabels();
        setStatsView();
        statsView.toFront();
    }

    private void setStatsView(){

        statsView.getChildren().add(hpImg);
        statsView.getChildren().add(hp);
        statsView.getChildren().add(defenseImg);
        statsView.getChildren().add(defense);
        statsView.getChildren().add(csImg);
        statsView.getChildren().add(critStrike);
        statsView.getChildren().add(damageIng);
        statsView.getChildren().add(damage);
        statsView.getChildren().add(moneyImg);
        statsView.getChildren().add(money);
    }

    private void setLabels(){
        hp = new Label();
        defense = new Label();
        critStrike = new Label();
        damage = new Label();
        money = new Label();
        setLabel(hp);
        setLabel(defense);
        setLabel(critStrike);
        setLabel(damage);
        setLabel(money);
        hp.setMinWidth(230);
        hp.setMinWidth(230);
    }

    private void setImages(){
        hpImg = new ImageView();
        defenseImg = new ImageView();
        csImg = new ImageView();
        damageIng = new ImageView();
        moneyImg = new ImageView();
        setImage(0, 0, hpImg, "sample/Images/statsViewImages/hp.png");
        setImage(200, 0, defenseImg, "sample/Images/statsViewImages/armor.png");
        setImage(400, 0, csImg, "sample/Images/statsViewImages/crit.png");
        setImage(600, 0, damageIng, "sample/Images/statsViewImages/damage.png");
        setImage(800, 0, moneyImg, "sample/Images/statsViewImages/money.png");
    }

    private void setImage(int x, int y, ImageView img, String f){
        img.setX(x);
        img.setY(y);
        img.setImage(new Image(f));
    }

    private void setLabel(Label l){
    l.setFont(new Font("Arial", 50));
    l.setAlignment(Pos.CENTER);
    l.setWrapText(true);
    l.setMaxHeight(100);
    l.setMinHeight(100);
    l.setMaxWidth(100);
    l.setMinWidth(100);
    }

    public void refresh(){
     hp.setText(Integer.toString(player.getHP()) + " / " + Integer.toString(player.getMaxHP()));
     defense.setText(Integer.toString(player.getDefense()));
     critStrike.setText(Integer.toString(player.getCritStrike()));
     damage.setText(Integer.toString(player.getMaxDamage()));
     money.setText(Integer.toString(player.getMoney()));
    }

}
