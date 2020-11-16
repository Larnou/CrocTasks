package Threads_2810_task_05;

import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Showtime {

    public static Set<Seat> getFreeSeats() {
        Set<Seat> openSeats = new HashSet<>();
        int[][] room = new int[Zal.rows][Zal.seats];

        for (int i = 0; i < Zal.rows; i++) {
            for (int j = 0; j < Zal.seats; j++) {
                room[i][j] = Zal.cinemaRoom[i][j];
            }
        }

        for (int i = 0; i < Zal.rows; i++) {
            for (int j = 0; j < Zal.seats; j++) {
                if (room[i][j] == 0) {
                    openSeats.add(new Seat(i, j));
                }
            }
        }
        return openSeats;
    }

    public static void showOpenToBookSeats(Set<Seat> availableSeats) {
        System.out.println("Доступные для посадки места");
        for (Seat s : availableSeats) {
            System.out.println(s.toString());
        }
    }

    public static boolean bookSeat(Seat seat) {

        int seatToBook = seat.getSeat();
        int rowToBook = seat.getRow();
        if (Zal.cinemaRoom[rowToBook][seatToBook] == 0) {
            Zal.cinemaRoom[rowToBook][seatToBook] = 1;
            System.out.println("Ваш билет стоит: " + seat.getCost());
            Zal.AVAILABLE_PLACES--;
            System.out.println("Было куплено место: ряд - " + (rowToBook + 1) + ", место - " + (seatToBook + 1) + ". Осталось: " + Zal.AVAILABLE_PLACES);
            return true;
        } else {
            return false;
        }
    }

    public static Seat tryToBook() throws IOException {

        Zal.showMap(Zal.cinemaRoom); // вывод через массивы, во всяком случае выглядит как в кинотеатре в отличии от сета
        //showOpenToBookSeats(getFreeSeats()); // вывод через сет, но нужно ли так?

        Random random = new Random();
        int row = random.nextInt(7) + 1;
        int seat = random.nextInt(8) + 1;

        // ручной ввод:
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выберте ваше место для брони:");
        System.out.println("Ваш ряд?");
        int row = Integer.parseInt(reader.readLine());

        System.out.println("Ваше место в ряду?");
        int seat = Integer.parseInt(reader.readLine());*/

        Seat iWantThis = new Seat(row - 1, seat - 1);
        System.out.println("Вы выбрали: Ряд под номером: " + row + " и местом под номером " + seat);
        return iWantThis;
    }

    public static void booking() throws IOException {
        if (bookSeat(tryToBook())) {
            System.out.println("Поздравляем с покупкой, приятного просмотра");
        } else {
            System.out.println("Изивините, но это место уже занято, выберите другое!");
        }
    }
}

