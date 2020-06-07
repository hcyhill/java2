package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckingOrderController {
    @FXML
    Button OKButton;
    @FXML
    Button backButton;
    @FXML
    TextField input;



    public void initialize(){


    }
    public void OKButton(ActionEvent actionEvent){
        String goods = input.getText();
    }

    public void backButton(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MenuController.fxml"));
        currentStage.setScene(new Scene(root,360,348));
    }
}
