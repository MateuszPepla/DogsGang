package sample.GameMechanics;

import javafx.scene.input.KeyEvent;
import sample.player.Player;

public class KeyControl {
    private Player player;

    public KeyControl(Player player){
        this.player = player;
    }

    public void keyPressed(KeyEvent e){
        player.setKeyP(e);
    }

    public void keyReleased(KeyEvent e) {
        player.setKeyR(e);
    }
}
