package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import sample.GameMechanics.GameLoop;
import sample.GameMechanics.KeyControl;
import sample.GameView.CharactersManager;
import sample.GameView.GameCamera;
import sample.GameView.ObjectsManager;
import sample.GameView.StatsViewManager;
import sample.objects.Floor;
import sample.player.Player;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Pane gameView;
    @FXML
    HBox statsView;
    @FXML
    HBox itemList;

    private GameLoop gameLoop;
    private KeyControl keyControl;
    private ArrayList<Floor> floors = new ArrayList<Floor>();
    private ObjectsManager objectsManager;
    private CharactersManager charactersManager;
    private int gameSpeed = 20;
    private GameCamera gameCamera;
    private Player player;
    private StatsViewManager svm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        objectsManager = new ObjectsManager(floors, gameView);
        objectsManager.setObjects();
        player = new Player(floors, gameSpeed, gameView);
        charactersManager = new CharactersManager(player, gameView, floors);
        charactersManager.setCharacters();
        svm = new StatsViewManager(statsView, player);
        gameCamera = new GameCamera(gameView, player, floors);
        gameLoop = new GameLoop(player, floors, gameSpeed, gameView, svm, gameCamera);
        keyControl = new KeyControl(player);
    }

    /// GETTERS ///
    public KeyControl getKeyControl(){ return this.keyControl;}

}
