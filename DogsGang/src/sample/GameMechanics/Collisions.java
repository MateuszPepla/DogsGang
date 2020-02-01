package sample.GameMechanics;

import javafx.scene.image.ImageView;
import sample.objects.Floor;

import java.util.ArrayList;

public class Collisions {

    public Collisions(){

    }

    public boolean checkCollisionG(ArrayList<Floor> objects, ImageView object, double moveSpeed){
        for(int i=0; i<objects.size(); i++)
            if(objects.get(i).getY() - object.getImage().getHeight() - moveSpeed <= object.getY() &&
                    objects.get(i).getY() + objects.get(i).getImage().getHeight() - moveSpeed >= object.getY() &&
                    objects.get(i).getX() - object.getImage().getWidth() < object.getX() &&
                    objects.get(i).getX() + objects.get(i).getImage().getWidth() > object.getX()){
                return true;}

        return false;
    }

    public boolean checkCollisionJ(ArrayList<Floor> objects, ImageView object, double moveSpeed){
        for(int i=0; i<objects.size(); i++)
            if(objects.get(i).getY() + objects.get(i).getImage().getHeight() >= object.getY()- moveSpeed &&
               objects.get(i).getY() <= object.getY() + object.getImage().getHeight() - moveSpeed &&
               objects.get(i).getX() - object.getImage().getWidth() < object.getX() &&
               objects.get(i).getX() + objects.get(i).getImage().getWidth() > object.getX()){
                return true;}

        return false;
    }

    public boolean chechCollisionHR(ArrayList<Floor> objects, ImageView object, double moveSpeed){
        for(int i=0; i<objects.size(); i++)
                if(objects.get(i).getY() - object.getImage().getHeight() <= object.getY() &&
                   objects.get(i).getY() + objects.get(i).getImage().getHeight() >= object.getY() &&
                   objects.get(i).getX() - moveSpeed - object.getImage().getWidth() <= object.getX() &&
                        objects.get(i).getX() + objects.get(i).getImage().getWidth() > object.getX())
                    return true;
        return false;
    }

    public boolean chechCollisionHL(ArrayList<Floor> objects, ImageView object, double moveSpeed){
        for(int i=0; i<objects.size(); i++)
                if(objects.get(i).getY() - object.getImage().getHeight() <= object.getY() &&
                        objects.get(i).getY() + objects.get(i).getImage().getHeight() >= object.getY() &&
                        objects.get(i).getX() - object.getImage().getWidth() < object.getX() &&
                        objects.get(i).getX() + objects.get(i).getImage().getWidth() >= object.getX() - moveSpeed)
                    return true;
        return false;
    }




}
