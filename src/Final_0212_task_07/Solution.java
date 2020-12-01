package Final_0212_task_07;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.codehaus.jackson.*;


public class Solution {

    public static void main(String[] args) throws IOException, ParseException {

        ObjectMapper objectMapper = new ObjectMapper();

        List<Item> itemList = new ArrayList<>();

        itemList.add(new Item("tea Tess", 12));
        itemList.add(new Item("Chocolate Milka", 13));
        itemList.add(new Item("Chocolate Alpen Gold", 17));
        itemList.add(new Item("Milk Baikalskoe", 23));
        itemList.add(new Item("Cards Bicycle Steampunk", 26));
        itemList.add(new Item("Book Lagom", 32));
        itemList.add(new Item("Puzzles Hatber", 45));

        String itemFilePath = "src\\Final_0212_task_07\\jsons\\items.json";
        objectMapper.writeValue(new FileOutputStream(itemFilePath), itemList);

        // ========================================

        List<Seller> sellerList = new ArrayList<>();

        sellerList.add(new Seller("Dima", "Shubin", 1));
        sellerList.add(new Seller("Artur", "Yakimchuk", 2));
        sellerList.add(new Seller("Alexandr", "Miroshnichenko", 3));

        String sellerFilePath = "src\\Final_0212_task_07\\jsons\\sellers.json";
        objectMapper.writeValue(new FileOutputStream(sellerFilePath), sellerList);

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
        objectMapper.writeValue(new FileOutputStream(existanceFilePath), existenceList);

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
        objectMapper.writeValue(new FileOutputStream(salesFilePath), salesList);

        // данные заполнили теперь начинаем играть с xml
        //==============================================

        // 2 задание кароч, первое я не понимаю а со строками какая-то фигня

        Sales[] sales = objectMapper.readValue(new FileInputStream(salesFilePath), Sales[].class);

        List<String> sale = new ArrayList<>();
        List<String> dates = new ArrayList<>();
        for (int i = 0; i < sales.length; i++) {
            sale.add(String.valueOf(sales[i]));
            dates.add(String.valueOf(sales[i]).split("date=\'")[1].split("\'")[0]);
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
        List<Date> actualDates = new ArrayList<>();
        for (int i = 0; i < sales.length; i++) {
            Date date = formatter.parse(dates.get(i));
            actualDates.add(date);
        }

        // and now we going to count time   <date = >
        //                                  <counts = >

        List<Integer> counts = new ArrayList<>();
        int el = 0;
        for (int i = 0; i < actualDates.size(); i++) {
            for (int j = 0; j < actualDates.size(); j++) {
                if (actualDates.get(i).getTime() == actualDates.get(j).getTime()) {
                    el++;
                }
            }
            counts.add(el);
            el = 0;
        }

        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < actualDates.size(); i++) {
            tmp.add("date = " + formatter.format(actualDates.get(i)) + ", repeats = " + counts.get(i));
        }
        Set<String> secondTask = new HashSet<>(tmp);


        XML xml = new XML();
        xml.ConstructorsForXML(secondTask);


        // Тут я сильно запутался и не понял как перевести из JSON в объект List'a выдаёт ошибки постоянно.
        // Поэтому пришлось делать костыльно через строки *грустный смайлик* :-(

        //List<Item> participantJsonList = objectMapper.readValue(Arrays.toString(items), new TypeReference<List<Item>>(){});
        //System.out.println(participantJsonList);
        //String formattedString = Arrays.toString(items).trim().replaceAll("\uFFFD", "");
        // List<Item> ppl2 = Arrays.asList(objectMapper.readValue(formattedString, Item[].class));
        //participantJsonList.forEach(System.out::println);
    }
}
