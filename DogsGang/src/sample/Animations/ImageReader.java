package sample.Animations;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageReader {

    public ImageReader(){

    }

    public void readImage(String f, ImageView imgView){
    Image image = new Image(f);
    imgView.setImage(image);
    }

}
