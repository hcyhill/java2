package Controller;

import Data.MemberData;
import Data.DBConnect;
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
import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {
    @FXML
    Button loginButton;
    @FXML
    Button registerButton;
    @FXML
    Button exitButton;
    @FXML
    TextField accountText;
    @FXML
    TextField passwordText;
    private static Connection dbCon = DBConnect.getConnection(); // 連接DB
    private String account ;
    private String password ;
    MemberData memberdata = new MemberData();
    public void loginButton(ActionEvent actionEvent) throws SQLException, IOException {
        account = accountText.getText();
        password = passwordText.getText();
        String x = memberdata.memberLogin(account,password);
        if (x == "FALSE"){
            Stage currentStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("MenuController.fxml"));
            currentStage.setScene(new Scene(root,360,348));
        }else if (x == "TRUE"){
            Stage currentStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("MenuController.fxml"));
            currentStage.setScene(new Scene(root,360,348));
        }
    }
    public void registerButton(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("SignUpController.fxml"));
        currentStage.setScene(new Scene(root,395,264));
    }

    public void exitButton(){
        System.exit(0);
    }


}
