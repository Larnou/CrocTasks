package Threads_2810_task_05;

import java.io.IOException;

public class Customers extends Thread{

    private static final Object lock = new Object();

    @Override
    public void run() {
        while (Zal.AVAILABLE_PLACES > 12) {
            try {
                synchronized (lock) {

                    Showtime.booking();
                    Thread.sleep(150);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
