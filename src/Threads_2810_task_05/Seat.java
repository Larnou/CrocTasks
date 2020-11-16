package Threads_2810_task_05;

public class Seat {

    private final int row;

    private final int seat;

    private final int cost;

    public Seat(int row, int seat) {
        this.row = row;
        this.seat = seat;
        this.cost = getWholeCost(row, seat);
    }

    public static int getWholeCost(int row, int seat) {
        if (row + 1 <= 2) {
            return 140;
        } else if (row + 1 >= 6) {
            return 250;
        } else {
            if (seat + 1 <= 2 || seat + 1 >= 6) {
                return 230;
            } else {
                return 340;
            }
        }
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Можно сесть тут: место: " + (seat + 1) + ", ряд: " + (row + 1) + ", стоимость билета: " + cost;
    }
}

