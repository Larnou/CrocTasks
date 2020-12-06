package Final_0212_task_07;

public class SellerHasItem {

    public String sellerName;
    public String nameOfItem;
    public int amountOfItem;

    public SellerHasItem(String sellerName, String nameOfItem, int amountOfItem) {
        this.sellerName = sellerName;
        this.nameOfItem = nameOfItem;
        this.amountOfItem = amountOfItem;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public int getAmountOfItem() {
        return amountOfItem;
    }

    @Override
    public String toString() {
        return "SellerHasItem{" +
                "sellerID=" + sellerName +
                ", nameOfItem='" + nameOfItem + '\'' +
                ", amountOfItem=" + amountOfItem +
                '}';
    }
}
