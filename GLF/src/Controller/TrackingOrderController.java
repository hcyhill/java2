package Controller;

import Data.DBConnect;
import Data.MemberData;
import Data.Order;
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

public class TrackingOrderController extends MenuController implements Initializable {
    @FXML
    Button OKButton;
    @FXML
    Button backButton;
    @FXML
    TextField input;
    @FXML
    TableView<Order> orderTable;
    @FXML
    TableColumn<Order,String> col_Id;

    ObservableList<Order> data = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            Connection dbCon = DBConnect.getConnection();
            ResultSet rs = dbCon.createStatement().executeQuery("select * from ordersearch");
            while (rs.next()){
                data.add(new Order(rs.getString("search")));
            }
        } catch (SQLException e) {

        }
        col_Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        orderTable.setItems(data);
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

