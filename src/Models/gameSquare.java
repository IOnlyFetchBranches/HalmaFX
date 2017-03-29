package Models;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class gameSquare extends Rectangle {
    public gameSquare(Color color){
        this.setWidth(18);
        this.setHeight(18);
        this.setFill(color);
    }


}
