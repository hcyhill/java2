package Controller;

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

public class SignUpController extends LoginController{
    @FXML
    Button OKButton;
    @FXML
    Button backButton;
    @FXML
    TextField nameText;
    @FXML
    TextField accountText;
    @FXML
    TextField passwordText;
    @FXML
    TextField confirmPasswordText;
    private static Connection dbCon = DBConnect.getConnection(); // 連接DB

    public void OKButton(ActionEvent actionEvent) throws SQLException, IOException {
        String name = nameText.getText();
        String account = accountText.getText();
        String password = passwordText.getText();
        String confirmPassword = confirmPasswordText.getText();
        if (!account.startsWith("09"))
            System.out.println("Sign-up Failed");
        else if (account.length() != 10)
            System.out.println("Sign-up Failed");
        else if (!password.equals(confirmPassword))
            System.out.println("Sign-up Failed");
        else {
            String privilege = "false";
            memberSign(name, account, password, privilege);
            back(actionEvent);
        }
    }
    public void backButton(ActionEvent actionEvent) throws IOException {
        back(actionEvent);
    }

    private void back(ActionEvent actionEvent) throws IOException {
        Stage currentStage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("LoginController.fxml"));
        currentStage.setScene(new Scene(root,395,264));
    }


}
