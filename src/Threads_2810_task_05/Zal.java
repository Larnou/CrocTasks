package Threads_2810_task_05;

public class Zal {

    final  static int  rows = 7;
    final  static int  seats = 8;
    static int  AVAILABLE_PLACES = rows * seats;

    public static int[][] createZal() {
        int [][] places = new int[rows][seats];

        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < seats; j++) {
                places[i][j] = 0;
            }
        }
        return places;
    }

    static int[][] cinemaRoom = createZal();

    public static void showMap(int[][] places) {
        for (int i = 0; i < seats; i++) {
            System.out.print("     Место: " + (i + 1) + "     ");
        }
        System.out.println('\n');

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                System.out.print("|  " + places[i][j] + "  (" + Seat.getWholeCost(i, j) +  " руб)" + "  |");
            }
            System.out.println("     Ряд: " + (i + 1));
        }
    }
}
