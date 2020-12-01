package Final_0212_task_07;

public class Item {

    public String itemName;
    public int itemId;

    public Item(String itemName, int itemId) {
        this.itemName = itemName;
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemId() {
        return itemId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemId=" + itemId +
                '}';
    }

    public Item() {
    }
}
