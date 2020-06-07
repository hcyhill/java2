package Controller;

import Data.Goods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class MenuController extends LoginController{
    @FXML
    Button productsButton;
    @FXML
    Button shoppingCartButton;
    @FXML
    Button trackingOrderButton;
    @FXML
    Button addProductButton;
    @FXML
    Button checkingOrderButton;
    @FXML
    Button exitButton;

    Goods g = new Goods();


    public void productsButton(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ProductController.fxml"));
        currentStage.setScene(new Scene(root,600,410));
    }
    public void shoppingCartButton(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ShoppingCartController.fxml"));
        currentStage.setScene(new Scene(root,600,400));
    }
    public void trackingOrderButton(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("TrackingOrderController.fxml"));
        currentStage.setScene(new Scene(root,360,400));
    }
    public void addProductButton(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("AddController.fxml"));
        currentStage.setScene(new Scene(root,300,285));
    }
    public void checkingOrderButton(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("CheckingOrderController.fxml"));
        currentStage.setScene(new Scene(root,300,150));
    }
    public void exitButton(ActionEvent actionEvent){
        System.exit(0);
    }

}
