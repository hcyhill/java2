package Data;

public class Order {
    private String id,account;

    public  Order(String id){
        this.id = id;
    }
    public  Order(String id,String account){
        this.id = id;
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
