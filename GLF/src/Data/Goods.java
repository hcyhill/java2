package Data;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Goods {
    private String id,name, quantity, weight,write;

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
    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setQuantity(String quantity){
        this.quantity = quantity;
    }
    public void setWeight(String weight){
        this.weight = weight;
    }
    public void setWrite(String write){
        this.write = write;
    }

}
