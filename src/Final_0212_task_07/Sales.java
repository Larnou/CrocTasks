package Final_0212_task_07;

public class Sales {

    public int salesID;
    public int sellerID;
    public int itemID;
    public int sold;
    public String date;

    public Sales(int salesID, int sellerID, int itemID, int sold, String date) {
        this.salesID = salesID;
        this.sellerID = sellerID;
        this.itemID = itemID;
        this.sold = sold;
        this.date = date;
    }

    public int getSalesID() {
        return salesID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public int getItemID() {
        return itemID;
    }

    public int getSold() {
        return sold;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "salesID=" + salesID +
                ", sellerID=" + sellerID +
                ", itemID=" + itemID +
                ", sold=" + sold +
                ", date='" + date + '\'' +
                '}';
    }

    public Sales() {
    }
}
