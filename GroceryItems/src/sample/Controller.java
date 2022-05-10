package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private Button add;

    @FXML
    private Button remove;

    @FXML
    private Button update;

    @FXML
    void addListener(ActionEvent event) throws IOException {
        add.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Add.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Add Item");
        stage.setScene(new Scene(root1, 750,600));
        stage.show();
    }

    @FXML
    void removeListener(ActionEvent event) throws IOException {
        remove.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Remove.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Remove Item");
        stage.setScene(new Scene(root1, 750,600));
        stage.show();
    }

    @FXML
    void updateListener(ActionEvent event) throws IOException {
        remove.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Update.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Update Item");
        stage.setScene(new Scene(root1, 750,600));
        stage.show();
    }
}
