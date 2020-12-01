package Final_0212_task_07;

public class Seller {

    public String sellerName;
    public String sellerSecondName;
    public int sellerID;

    public Seller(String sellerName, String sellerSecondName, int sellerID) {
        this.sellerName = sellerName;
        this.sellerSecondName = sellerSecondName;
        this.sellerID = sellerID;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getSellerSecondName() {
        return sellerSecondName;
    }

    public int getSellerID() {
        return sellerID;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerName='" + sellerName + '\'' +
                ", sellerSecondName='" + sellerSecondName + '\'' +
                ", sellerID=" + sellerID +
                '}';
    }

    public Seller() {
    }
}
