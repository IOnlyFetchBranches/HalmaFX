package Resources;

import java.net.URL;
import java.util.ResourceBundle;

import Models.gameSquare;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class mainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane board;

    @FXML
    void initialize() {
        assert board != null : "fx:id=\"board\" was not injected: check your FXML file 'main.fxml'.";

        colorBoard();




    }

    private void colorBoard(){
        for(int row=0;row<16;row++){

            if(row%2==0) {
                for (int col = 0; col < 16; col++) {
                    if (col % 2 == 0) {
                        board.add(new gameSquare(Color.GRAY),col,row);
                    }
                    else{
                        board.add(new gameSquare(Color.PEACHPUFF),col,row);
                    }


                }
            }

            if(row%2!=0) {
                for (int col = 0; col < 16; col++) {
                    if (col % 2 == 0) {
                        board.add(new gameSquare(Color.PEACHPUFF),col,row);
                    }
                    else{
                        board.add(new gameSquare(Color.GRAY),col,row);
                    }


                }
            }




        }
    }

}