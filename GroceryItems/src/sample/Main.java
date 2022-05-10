package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static List<Model> itemList = new ArrayList<Model>();
    public static Model cacheModel;
    public static int status = 0;
    public static int index = -1;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        primaryStage.setTitle("Home");
        primaryStage.setScene(new Scene(root, 750, 600));
        primaryStage.show();

    }

    public static void writeToFile(){
        try {
            FileWriter myWriter = new FileWriter("Data.txt");
            for(int i=0 ; i<Main.itemList.size() ; i++) {
                myWriter.write(Main.itemList.get(i).getId() + " "+ Main.itemList.get(i).getName() + " "+ Main.itemList.get(i).getPrice() + " "+ Main.itemList.get(i).getQuantity()+"\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred in opening the file.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
