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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProductController extends MenuController implements Initializable {
    @FXML
    Button OKButton;
    @FXML
    Button backButton;
    @FXML
    TextField input;
    @FXML
    TableView<Goods> goodsTable;
    @FXML
    TableColumn<Goods,String> col_Goods;
    @FXML
    TableColumn<Goods,String> col_Quantity;
    @FXML
    TableColumn<Goods,String> col_Weight;

    ObservableList<Goods> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection dbCon = DBConnect.getConnection();
            ResultSet rs = dbCon.createStatement().executeQuery("select * from goods");
            while (rs.next()){
                data.add(new Goods(rs.getString("gName"),rs.getString("gQuantity"),rs.getString("gWeight")));
            }
        } catch (SQLException e) {

        }
        col_Goods.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_Quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        col_Weight.setCellValueFactory(new PropertyValueFactory<>("weight"));
        goodsTable.setItems(data);
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
