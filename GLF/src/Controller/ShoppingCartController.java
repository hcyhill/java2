package Controller;

import Data.DBConnect;
import Data.Goods;
import Data.ShoppingCart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ShoppingCartController extends MenuController implements Initializable {
    @FXML
    Button buyButton;
    @FXML
    Button backButton;
    @FXML
    TableView<ShoppingCart> shoppingCartTable;
    @FXML
    TableColumn<ShoppingCart,String> col_goods;
    @FXML
    TableColumn<ShoppingCart,String> col_unit;
    @FXML
    TableColumn<ShoppingCart,String> col_price;

    ObservableList<ShoppingCart> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection dbCon = DBConnect.getConnection();
            ResultSet rs = dbCon.createStatement().executeQuery("select * from shoppingcart");
            while (rs.next()){
                data.add(new ShoppingCart(rs.getString("goods"),rs.getString("num"),rs.getString("price")));
            }
        } catch (SQLException e) {

        }
        col_goods.setCellValueFactory(new PropertyValueFactory<>("goods"));
        col_unit.setCellValueFactory(new PropertyValueFactory<>("num"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        shoppingCartTable.setItems(data);

    }


    public void buyButton(ActionEvent actionEvent){

    }

    public void backButton(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MenuController.fxml"));
        currentStage.setScene(new Scene(root,360,348));
    }

}
