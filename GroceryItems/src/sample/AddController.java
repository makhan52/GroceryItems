    package sample;

    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.FXMLLoader;
    import javafx.fxml.Initializable;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.control.Alert;
    import javafx.scene.control.Button;
    import javafx.scene.control.TextField;
    import javafx.scene.control.TextFormatter;
    import javafx.scene.input.InputMethodEvent;
    import javafx.scene.input.MouseEvent;
    import javafx.stage.Stage;
    import java.io.IOException;
    import java.net.URL;
    import java.util.ResourceBundle;

    public class AddController implements Initializable {
        @FXML
        private TextField name;

        @FXML
        private TextField quantity;

        @FXML
        private TextField price;

        @FXML
        private TextField id;

        @FXML
        private Button add;


        @FXML
        void idListener(InputMethodEvent event) {
        }

        @FXML
        void priceListener(ActionEvent event) {

        }

        @FXML
        void quantListener(ActionEvent event) {

        }

        @FXML
        void addListener(ActionEvent event) throws IOException {

        if(!id.getText().isEmpty() && !name.getText().isEmpty() && !price.getText().isEmpty() && !quantity.getText().isEmpty()){

            int id1 = Integer.parseInt(id.getText());
            int price1 = Integer.parseInt(price.getText());
            int quant1 = Integer.parseInt(quantity.getText());

            if(Main.status == 1){
                Main.itemList.set(Main.index,new Model(id1, name.getText(), quant1, price1));
                Main.status = 0;
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success!!");
                alert.setContentText("Item Updated Successfuly!");
                alert.showAndWait();
                Main.writeToFile();

                add.getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Update.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Update");
                stage.setScene(new Scene(root1, 750,600));
                stage.show();

            }
            else {
                Main.itemList.add(new Model(id1, name.getText(), quant1, price1));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success!!");
                alert.setContentText("Item Added Successfuly!");
                alert.showAndWait();
                Main.writeToFile();
            }

        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!!");
            alert.setContentText("Please fill all fields!");
            alert.showAndWait();
        }

        }

        @FXML
        void backListener(MouseEvent event) throws IOException {

        }
        @FXML
        void backPressed(MouseEvent event) throws IOException {
            add.getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Add Item");
            stage.setScene(new Scene(root1, 750,600));
            stage.show();
        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            if(Main.status == 1) {
                id.setText(Main.cacheModel.getId() + "");
                name.setText(Main.cacheModel.getName() + "");
                price.setText(Main.cacheModel.getPrice() + "");
                quantity.setText(Main.cacheModel.getQuantity() + "");
                add.setText("Update");
            }
                //lambda functions to restrict only numeric input data
            AddController.InnerUtilityClass inner = this.new InnerUtilityClass();
            inner.createNumericOnlyFields();

            }

        private class InnerUtilityClass {
            public void createNumericOnlyFields(){
                id.setTextFormatter(new TextFormatter<>(c -> {
                    if (!c.getControlNewText().matches("\\d*"))
                        return null;
                    else
                        return c;
                }
                ));
                price.setTextFormatter(new TextFormatter<>(c -> {
                    if (!c.getControlNewText().matches("\\d*"))
                        return null;
                    else
                        return c;
                }
                ));
                quantity.setTextFormatter(new TextFormatter<>(c -> {
                    if (!c.getControlNewText().matches("\\d*"))
                        return null;
                    else
                        return c;
                }
                ));
            }
        }

    }
