package sample.GameView;

import javafx.scene.layout.Pane;
import sample.objects.Floor;
import sample.objects.GrassFloor;
import sample.objects.IronFootBridge;

import java.util.ArrayList;

public class ObjectsManager {

    private ArrayList<Floor> floors;
    private Pane gameView;

    public ObjectsManager(ArrayList<Floor> floors, Pane gameView){
        this.floors = floors;
        this.gameView = gameView;
    }


    public void setObjects(){
        for(int i=0; i<4; i++)
            this.floors.add(new GrassFloor());

        for(int i=0; i<2; i++)
        this.floors.add(new IronFootBridge());

        for(int i=0; i<this.floors.size(); i++)
            gameView.getChildren().add(this.floors.get(i));

        this.floors.get(0).setX(0);
        this.floors.get(0).setY(1200);

        this.floors.get(1).setX(1200);
        this.floors.get(1).setY(1100);

        this.floors.get(2).setX(1800);
        this.floors.get(2).setY(1000);

        this.floors.get(3).setX(-3500);
        this.floors.get(3).setY(1000);

        this.floors.get(4).setX(0);
        this.floors.get(4).setY(650);

        this.floors.get(5).setX(0);
        this.floors.get(5).setY(1050);


    }

}
