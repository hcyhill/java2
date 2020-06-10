package Controller;

import Data.DBConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddController extends MenuController{
    @FXML
    Button OKButton;
    @FXML
    Button backButton;
    @FXML
    TextField goodsText;
    @FXML
    TextField quantityText;
    @FXML
    TextField weightText;
    @FXML
    CheckBox writeBox;

    private static Connection dbCon = DBConnect.getConnection();
    public void OKButton(ActionEvent actionEvent) throws IOException, SQLException {
        String goodsName = goodsText.getText();
        String goodsQuantity = quantityText.getText();
        String goodsWeight = weightText.getText();
        String goodsWrite = handleWriteBox();
        addProduct(goodsName,goodsQuantity,goodsWeight,goodsWrite);
        back(actionEvent);
    }
    public void backButton(ActionEvent actionEvent) throws IOException {
        back(actionEvent);

    }
    private void back(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MenuController.fxml"));
        currentStage.setScene(new Scene(root,360,348));
    }
    @FXML
    private String handleWriteBox(){
        if (writeBox.isSelected()){
            return "true";
        }
        return "false";
    }

    public void addProduct(String goodsName,String goodsQuantity,String goodsWeight,String goodsWrite) throws SQLException {
        Statement stmt = dbCon.createStatement();
        try {
            stmt.executeUpdate("insert into goods(gName,gQuantity,gWeight,gWrite) values ('" + goodsName + "','"
                    + goodsQuantity + "','" + goodsWeight + "','" + goodsWrite + "')");
        } finally {
            try {
                stmt.close();
            } catch (SQLException error) {
                error.printStackTrace();
            }
        }
    }
}
