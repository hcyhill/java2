package Data;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Goods {
    private String id,name, quantity, weight,write;
    private static Connection dbCon = DBConnect.getConnection();

    public Goods(){

    }

    public Goods(String gName, String gQuantity, String gWeight) {
        this.name = gName;
        this.quantity = gQuantity;
        this.weight = gWeight;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getQuantity() {
        return quantity;
    }
    public String getWeight() {
        return weight;
    }
    public String getWrite() {
        return write;
    }
    public void setId(){
        this.id = id;
    }
    public void setName(){
        this.name = name;
    }
    public void setQuantity(){
        this.quantity = quantity;
    }
    public void setWeight(){
        this.weight = weight;
    }
    public void setWrite(){
        this.write = write;
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
