package CountWords_2110_task_04;

import java.io.*;
import java.util.Scanner;

public class TextReader {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        //String fileName = "src\\CountWords_2110_task_04\\Words.txt"; // путь до файла

        File f = new File(fileName);
        int amount = wordsCounter(f);
        if (amount != -1) {
            System.out.println("Всего в файле: " + amount + " слов");
        }
    }

    public static int wordsCounter(File f) {
        int words = -1;
        try (Scanner scanner = new Scanner(f)) {
            words=0;

            String test;
            while (scanner.hasNext()) {
                test = scanner.next();
                if (isThatAWord(test)) {
                    words++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Директория введена неверно, такого файла не существует");
        }
        return words;
    }

    public static boolean isThatAWord(String word) {
        return (word.matches(".*[А-яЁё].*") || word.matches(".*[a-zA-Z].*")) &&
                !word.matches(".*[0-9].*");
    }
}
