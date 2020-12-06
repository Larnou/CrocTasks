package Final_0212_task_07;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.util.DefaultPrettyPrinter;


public class Solution {

    public static void main(String[] args) throws IOException, ParseException {

        /*
            Исправлен вывод json-файла, теперь он красивый :)
            Исправлено чтение из json в объект Java
            Выполнено первое и второе задание, правда императивным методом. Тема стримом пока кажется сликшмо сложной, но
            буду знать что такая вещь в Java есть и обязательно постараюсь её выучить и разобраться.
        */

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());

        List<Item> itemList = new ArrayList<>();

        itemList.add(new Item("tea Tess", 12));
        itemList.add(new Item("Chocolate Milka", 13));
        itemList.add(new Item("Chocolate Alpen Gold", 17));
        itemList.add(new Item("Milk Baikalskoe", 23));
        itemList.add(new Item("Cards Bicycle Steampunk", 26));
        itemList.add(new Item("Book Lagom", 32));
        itemList.add(new Item("Puzzles Hatber", 45));

        String itemFilePath = "src\\Final_0212_task_07\\jsons\\items.json";
        writer.writeValue(new FileOutputStream(itemFilePath), itemList);

        // ========================================

        List<Seller> sellerList = new ArrayList<>();

        sellerList.add(new Seller("Dima", "Shubin", 1));
        sellerList.add(new Seller("Artur", "Yakimchuk", 2));
        sellerList.add(new Seller("Alexandr", "Miroshnichenko", 3));

        String sellerFilePath = "src\\Final_0212_task_07\\jsons\\sellers.json";
        writer.writeValue(new FileOutputStream(sellerFilePath), sellerList);

        //=================================================

        List<Existance> existenceList = new ArrayList<>();

        existenceList.add(new Existance(sellerList.get(0).getSellerID(), itemList.get(0).getItemId(), 69, 50));
        existenceList.add(new Existance(sellerList.get(0).getSellerID(), itemList.get(1).getItemId(), 420, 314));
        existenceList.add(new Existance(sellerList.get(0).getSellerID(), itemList.get(2).getItemId(), 1620, 78));

        existenceList.add(new Existance(sellerList.get(1).getSellerID(), itemList.get(2).getItemId(), 1320, 80));
        existenceList.add(new Existance(sellerList.get(1).getSellerID(), itemList.get(3).getItemId(), 532, 108));

        existenceList.add(new Existance(sellerList.get(2).getSellerID(), itemList.get(4).getItemId(), 4, 970));
        existenceList.add(new Existance(sellerList.get(2).getSellerID(), itemList.get(5).getItemId(), 2, 670));
        existenceList.add(new Existance(sellerList.get(2).getSellerID(), itemList.get(6).getItemId(), 12, 590));

        String existanceFilePath = "src\\Final_0212_task_07\\jsons\\existance.json";
        writer.writeValue(new FileOutputStream(existanceFilePath), existenceList);

        //=======================================================

        List<Sales> salesList = new ArrayList<>();

        salesList.add(new Sales(200100, sellerList.get(0).getSellerID(), itemList.get(0).getItemId(), 20, "02 12 2020"));
        salesList.add(new Sales(200101, sellerList.get(0).getSellerID(), itemList.get(1).getItemId(), 220, "02 12 2020"));

        salesList.add(new Sales(200102, sellerList.get(1).getSellerID(), itemList.get(2).getItemId(), 400, "08 05 2020"));
        salesList.add(new Sales(200103, sellerList.get(1).getSellerID(), itemList.get(3).getItemId(), 90, "09 11 2020"));

        salesList.add(new Sales(200104, sellerList.get(2).getSellerID(), itemList.get(4).getItemId(), 2, "30 06 2020"));
        salesList.add(new Sales(200105, sellerList.get(2).getSellerID(), itemList.get(5).getItemId(), 1, "12 09 2019"));
        salesList.add(new Sales(200106, sellerList.get(2).getSellerID(), itemList.get(6).getItemId(), 4, "12 09 2019"));
        salesList.add(new Sales(200107, sellerList.get(2).getSellerID(), itemList.get(6).getItemId(), 3, "26 08 2017"));

        String salesFilePath = "src\\Final_0212_task_07\\jsons\\sales.json";
        writer.writeValue(new FileOutputStream(salesFilePath), salesList);

        // данные заполнили теперь начинаем играть с xml
        //==============================================

        // 1 задание:
        // Для каждого товара вывести в файл продавца, у которого в наличии наибольшее количество этого товара,
        // и само количество этого товара у него в наличии

        List<Existance> existances = objectMapper.readValue(new File(existanceFilePath), new TypeReference<List<Existance>>(){});

        int maxAmount;
        Map<Integer, Integer> mapAmount = new HashMap<>();
        for (int i = 0; i < existances.size(); i++) {
            maxAmount = existances.get(i).getItemAmount();
            for (Existance existance : existances) {
                if (existance.getItemAmount() > maxAmount && existance.getItemID() == existances.get(i).getItemID()) {
                    maxAmount = existance.getItemAmount();
                }
            }
            mapAmount.put(existances.get(i).getItemID(), maxAmount);
        }

        List<SellerHasItem> hasItems = new ArrayList<>();
        for (Map.Entry<Integer, Integer> el : mapAmount.entrySet()) {
            hasItems.add(new SellerHasItem(getSellerNameByID(el.getKey(), el.getValue(), sellerFilePath, existanceFilePath),
                    getItemByID(el.getKey(), itemFilePath), el.getValue()));
        }

        task1XML xml1 = new task1XML();
        xml1.ConstructorsForXML(hasItems);


        // 2 задание:
        // Вывести в файл распределение общего количества продаж по датам
        List<Sales> sales = objectMapper.readValue(new File(salesFilePath), new TypeReference<List<Sales>>(){});
        List<Date> dates = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");

        for (Sales sale : sales) {
            dates.add(formatter.parse(sale.date));
        }

        List<DatesRepeats> datesRepeats = new ArrayList<>();
        Map<Date, Integer> map = new HashMap<>();
        int el = 0;
        for (int i = 0; i < dates.size(); i++) {
            for (Date date : dates) {
                if (dates.get(i).equals(date)) {
                    el++;
                }
            }
            map.put(dates.get(i), el);
            el = 0;
        }

        for (Map.Entry<Date, Integer> m : map.entrySet()) {
            datesRepeats.add(new DatesRepeats(formatter.format(m.getKey()), m.getValue()));
        }

        task2XML xml2 = new task2XML();
        xml2.ConstructorsForXML(datesRepeats);
    }

    public static String getItemByID(int ID, String Path) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        List<Item> items = objectMapper.readValue(new File(Path), new TypeReference<List<Item>>(){});
        for (Item item : items) {
            if (ID == item.getItemId()) {
                return item.getItemName();
            }
        }
        return Path;
    }

    public static String getSellerNameByID(int itemID, int itemAmount,  String sellerPath, String existPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Seller> sellers = objectMapper.readValue(new File(sellerPath), new TypeReference<List<Seller>>(){});
        List<Existance> existances = objectMapper.readValue(new File(existPath), new TypeReference<List<Existance>>(){});
        int selID;
        for (Existance exist : existances) {
            if (exist.getItemID() == itemID && exist.getItemAmount() == itemAmount) {
                selID = exist.getSellerID();
                for (Seller seller : sellers) {
                    if (selID == seller.getSellerID()) {
                        return seller.getSellerName() + " " + seller.getSellerSecondName();
                    }
                }
            }
        }
        return sellerPath;
    }
}
