package Threads_2810_task_05;

public class Solution {

    public static void main(String[] args) throws InterruptedException {

        Customers t1 = new Customers();
        Customers t2 = new Customers();
        t1.start();
        Thread.sleep(30);
        t2.start();
        Thread.sleep(30);
    }
}
