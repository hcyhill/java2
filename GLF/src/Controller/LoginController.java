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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    protected static String account ;
    protected static String privilege;
    protected  String password ;
    public void loginButton(ActionEvent actionEvent) throws SQLException, IOException {
        account = accountText.getText();
        password = passwordText.getText();
        privilege = memberLogin(account, password);
        if (privilege  != "null") {
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("MenuController.fxml"));
            currentStage.setScene(new Scene(root, 360, 348));
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

    public String memberLogin(String account, String password) throws SQLException {

        Statement stmt = dbCon.createStatement();
        ResultSet rs = stmt.executeQuery("select * from member");
        try {
            while (rs.next()) {// 從數據庫中，一行一行查找，直到沒有下一筆資料
                if (account.equals(rs.getString("mAccount")) && password.equals(rs.getString("mPassword"))) {// 判斷是否有登入資料
                    System.out.println("Login Successful!");
                    return  rs.getString("mPrivilege");
                } else {
                    if (rs.isLast()) {// 判斷是否為最後一筆資料
                        System.out.println("Unknown User Name or Bad Password !!");
                        return "null";
                    }
                }
            }
        } finally {
            try {
                stmt.close();
            } catch (SQLException error) {
                error.printStackTrace();
            }
        }
        return  "null";
    }
    
    public void memberSign(String name, String account, String password, String privilege) throws SQLException {
        Statement stmt = null;
        try {
            stmt = dbCon.createStatement();
            stmt.executeUpdate("insert into member (mName,mAccount,mPassword,mPrivilege) VALUES ('" + name + "','"
                    + account + "','" + password + "','" + privilege + "')");
            System.out.println("Sign-up Successful");
        } finally {
            try {
                stmt.close();
            } catch (SQLException error) {
                error.printStackTrace();
            }
        }
    }

}
