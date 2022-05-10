package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RemoveController implements Initializable {
    @FXML
    private ListView<String> list;

    public RemoveController(){
    }

    @FXML
    void listListener(MouseEvent event) {
        int index = list.getSelectionModel().getSelectedIndex();

        if (index >= 0) {
            list.getItems().remove(index);
            Main.itemList.remove(index);
            Main.writeToFile();

        }

    }

    @FXML
    void backListener(MouseEvent event) throws IOException {
        list.getScene().getWindow().hide();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("SignIn");
        stage.setScene(new Scene(root1, 750,600));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(int i=0 ; i<Main.itemList.size() ; i++) {
            list.getItems().add(Main.itemList.get(i).getId() + " "+ Main.itemList.get(i).getName() + " "+ Main.itemList.get(i).getPrice() + " "+ Main.itemList.get(i).getQuantity());
        }
    }
}
