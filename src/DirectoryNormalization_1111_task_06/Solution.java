package DirectoryNormalization_1111_task_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        System.out.println(normalizer(path));
    }

    public static String normalizer(String path) {
        Stack<String> stringStack = new Stack<>();
        String[] strings = path.split("/");

        for (int i = 0; i < strings.length ; i++) {
            stringStack.push(strings[i]);
        }

        String shortPath = stringStack.pop();
        while (true) {
            if (stringStack.peek().equals("..")) {
                shortPath = stringStack.pop() + "/" + shortPath;
                break;
            }
            shortPath = stringStack.pop() + "/" + shortPath;
            if (stringStack.isEmpty()) {
                break;
            }
        }
        return shortPath.replaceAll("/./", "/");
    }
}
