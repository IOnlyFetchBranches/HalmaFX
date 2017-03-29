import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static Tools.PrintTools.*;


public class mainApp extends Application{
    public static List<Point2D> player1Start,player2Start;




    public void start(Stage primaryStage) {
        try {
            Parent root = new FXMLLoader().load(this.getClass().getResource("Resources/main.fxml"));
            Scene scene=new Scene(root);

            primaryStage.setTitle("HalmaFX");
            primaryStage.setAlwaysOnTop(true);
            primaryStage.setScene(scene);

            primaryStage.show();

        } catch (IOException e) {
            errprint(e.getLocalizedMessage());
        }
    }
    private void readFiles(){


        //Check Resources;
        mainApp ref=new mainApp();


        File cords=new File(ref.getClass().getResource("Resources/CordData.txt").getPath());
        if(!cords.exists()){
            errprint("Resource "+cords.getName()+" was not found! Should be in Resources/CordData.txt");
        }

        //Read Cords;
        try {
            //Create list to store
            player1Start=new ArrayList<Point2D>();
            player2Start=new ArrayList<Point2D>();

            //Create Readers
            BufferedReader br = new BufferedReader(new FileReader(cords));
            String line; int cycle=0;

            //begin Reading
            while((line=br.readLine()) != null) {
                cycle++; //track the line;

                StringTokenizer st = new StringTokenizer(line, ":");
                st.nextToken();
                while(st.hasMoreTokens()){
                    String pos=st.nextToken();
                    String x=pos.trim().substring(0,pos.indexOf(",")-1);
                    String y=pos.trim().substring(pos.indexOf(","),pos.length()-1);

                    //store
                    if(cycle==1) {//first cycle is FirstPlayer
                        player1Start.add(new Point2D(Double.parseDouble(x), Double.parseDouble(y)));
                    }
                    else if(cycle==2) { //logically this is second player :P
                        player2Start.add(new Point2D(Double.parseDouble(x), Double.parseDouble(y)));
                    }
                }
            }

        }catch(IOException e){
            errprint(e.getLocalizedMessage());

        }
    }




























}
