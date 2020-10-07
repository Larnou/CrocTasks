package FuzzBuzz_task_01;

public class FuzzBuzz {
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            if ((i % 3 == 0) && (i % 5 == 0))
                System.out.printf("Число %s: кратно 3 и кратно 5, ответ: FuzzBuzz \n", i);
            else
                if (i % 3 == 0)
                    System.out.printf("Число %s: кратно 3, но не кратно 5, ответ: Fuzz \n", i);
                else
                    if (i % 5 == 0)
                        System.out.printf("Число %s: не кратно 3, но кратно 5, ответ: Buzz \n", i);
        }
    }
}
