package Final_0212_task_07;

import java.util.List;

public class Existance {

    public int sellerID;
    public int itemID;
    public int itemAmount;
    public int itemCost;


    public Existance(int sellerID, int itemID, int itemAmount, int itemCost) {
        this.sellerID = sellerID;
        this.itemID = itemID;
        this.itemAmount = itemAmount;
        this.itemCost = itemCost;
    }

    public int getSellerID() {
        return sellerID;
    }

    public int getItemID() {
        return itemID;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public int getItemCost() {
        return itemCost;
    }

    @Override
    public String toString() {
        return "Existance{" +
                "sellerID=" + sellerID +
                ", itemID=" + itemID +
                ", itemAmount=" + itemAmount +
                ", itemCost=" + itemCost +
                '}';
    }

    public Existance() {
    }
}
