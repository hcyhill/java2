package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberData {
    private String name,account,password,privilege;
    private static Connection dbCon = DBConnect.getConnection(); // 連接DB

    public MemberData() {
         this.name = "";
         this.account = "";
         this.password = "";
         this.privilege = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String memberLogin(String account, String password) throws SQLException {
        this.account = account;
        this.password = password;
        Statement stmt = dbCon.createStatement();
        ResultSet rs = stmt.executeQuery("select * from member");
        try {
            while (rs.next()) {// 從數據庫中，一行一行查找，直到沒有下一筆資料
                if (this.account.equals(rs.getString("mAccount")) && this.password.equals(rs.getString("mPassword"))) {// 判斷是否有登入資料
                    System.out.println("Login Successful!");
                    return  rs.getString("mPrivilege");
                    /*if (rs.getString("mPrivilege") == "FALSE") { // 判斷是否為員工
                        // 消費者模式
                        System.out.println("Login Successful!");
                        System.out.println(rs.getString("mPrivilege"));
                        return  rs.getString("mPrivilege");
                    } else {
                        // 員工模式
                        System.out.println("Login Successful!");
                        System.out.println(rs.getString("mPrivilege"));
                        return rs.getString("mPrivilege");
                    }*/
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
        this.name = name;
        this.account = account;
        this.password = password;
        this.privilege = privilege;
        Statement stmt = null;
        try {
            stmt = dbCon.createStatement();
            stmt.executeUpdate("insert into member (mName,mAccount,mPassword,mPrivilege) VALUES ('" + this.name + "','"
                    + this.account + "','" + this.password + "','" + this.privilege + "')");
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
