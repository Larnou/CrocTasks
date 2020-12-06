package Final_0212_task_07;

public class DatesRepeats {
    public String date;
    public int repeats;

    public DatesRepeats(String date, int repeats) {
        this.date = date;
        this.repeats = repeats;
    }

    public String getDate() {
        return date;
    }

    public int getRepeats() {
        return repeats;
    }

    @Override
    public String toString() {
        return "DatesRepeats{" +
                "date='" + date + '\'' +
                ", repeats=" + repeats +
                '}';
    }
}
