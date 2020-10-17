package Lesson_1410_task_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class Action {

    // показывает список песен выбранного носителя и завершает программу, для других классов по аналогии
    public static void choiceVinil(Classes.vinilDisk param) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            for (int i = 0; i < param.playlist.size(); i++) {
                System.out.printf("                     %s.  " + param.playlist.get(i) + '\n', i + 1);
            }
            System.out.println();
            System.out.println("                        Выберите цифру песни по списку" + '\n');
            int songNumber = Integer.parseInt(reader.readLine());
            if (songNumber <= param.playlist.size()) {
                System.out.println();
                System.out.println("                  Сейчас играет: " + param.name);
                System.out.println("                        " + param.playlist.get(songNumber - 1));
                play();
                System.out.println("                    Спасибо за использование Музяфона-2000");
                System.out.println("                              Ждём вас снова");
                break;
            } else {
                songError();
            }
        }
    }

    public static void choiceCD(Classes.cdDisk param) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            for (int i = 0; i < param.playlist.size(); i++) {
                System.out.printf("                     %s.  " + param.playlist.get(i) + '\n', i + 1);
            }
            System.out.println();
            System.out.println("                        Выберите цифру песни по списку" + '\n');
            int songNumber = Integer.parseInt(reader.readLine());
            if (songNumber <= param.playlist.size()) {
                System.out.println();
                System.out.println("                  Сейчас играет: " + param.name);
                System.out.println("                        " + param.playlist.get(songNumber - 1));
                play();
                System.out.println("                    Спасибо за использование Музяфона-2000");
                System.out.println("                              Ждём вас снова");
                break;
            } else {
                songError();
            }
        }
    }

    public static void choiceUniver(Classes.uniDisk param) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            for (int i = 0; i < param.playlist.size(); i++) {
                System.out.printf("                     %s.  " + param.playlist.get(i) + '\n', i + 1);
            }
            System.out.println();
            System.out.println("                        Выберите цифру песни по списку" + '\n');
            int songNumber = Integer.parseInt(reader.readLine());
            if (songNumber <= param.playlist.size()) {
                System.out.println();
                System.out.println("                  Сейчас играет: " + param.name);
                System.out.println("                        " + param.playlist.get(songNumber - 1));
                play();
                System.out.println("                    Спасибо за использование Музяфона-2077");
                System.out.println("                              Ждём вас снова");
                break;
            } else {
                songError();
            }
        }
    }
    // проверяет правильность введённого устройства для прослушивания
    public static ArrayList<String> checkFirstInput(ArrayList<String> param) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> array = new ArrayList<>();
        while (true) {
            String choiceOne = reader.readLine();
            if (param.contains(choiceOne)) {
                System.out.println();
                System.out.println("                           Вы выбрали: " + choiceOne + ".");
                array.add(choiceOne);
                break;
            } else {
                errorMessage();
            }
        }
        return array;
    }

    // пользователь выбирает номер устройства, проверяется существует ли такое устройство и показывается список
    // песен этого устройства
    public static void outputDeviceVinil(Classes.vinilDisk v1, Classes.vinilDisk v2)
            throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("                   1. " + v1.name);
        System.out.println("                   2. " + v2.name + '\n');
        System.out.println("                           Выберите цифру устройства" + '\n');
        while (true) {
            int num = Integer.parseInt(reader.readLine());
            if (num == 1) {
                System.out.println();
                System.out.println("                       Список песен выбранного устройства: " + '\n');
                choiceVinil(v1);  // 12 строка, вызывает метод для показа списка песен
                break;
            } else {
                if (num == 2) {
                    System.out.println();
                    System.out.println("                       Список песен выбранного устройства: " + '\n');
                    choiceVinil(v2);
                    break;
                } else {
                    errorDevice();
                    System.out.println("                           Выберите цифру устройства" + '\n');
                    System.out.println("                   1. " + v1.name);
                    System.out.println("                   2. " + v2.name + '\n');
                }
            }
        }
    }

    public static void outputDeviceCD(Classes.cdDisk v1, Classes.cdDisk v2) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("                   1. " + v1.name);
        System.out.println("                   2. " + v2.name + '\n');
        System.out.println("                           Выберите цифру устройства" + '\n');
        while (true) {
            int num = Integer.parseInt(reader.readLine());
            if (num == 1) {
                System.out.println();
                System.out.println("                       Список песен выбранного устройства: " + '\n');
                choiceCD(v1);
                break;
            } else {
                if (num == 2) {
                    System.out.println();
                    System.out.println("                       Список песен выбранного устройства: " + '\n');
                    choiceCD(v2);
                    break;
                } else {
                    errorDevice();
                    System.out.println("                           Выберите цифру устройства" + '\n');
                    System.out.println("                   1. " + v1.name);
                    System.out.println("                   2. " + v2.name + '\n');
                }
            }
        }
    }

    public static void outputDeviceUnivers(Classes.vinilDisk v1, Classes.vinilDisk v2, Classes.cdDisk cd1,
                                           Classes.cdDisk cd2, Classes.uniDisk u1, Classes.uniDisk u2)
            throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("                   1. " + v1.name);
        System.out.println("                   2. " + v2.name);
        System.out.println("                   3. " + cd1.name);
        System.out.println("                   4. " + cd2.name);
        System.out.println("                   5. " + u1.name);
        System.out.println("                   6. " + u2.name + '\n');
        System.out.println("                           Выберите цифру устройства");
        System.out.println();
        // пробовал через case, в итоге программа в конце предлагала ещё раз ввести строку, чего делать не нужно было
        // пришлось остаться на if'ах :(
        while (true) {
            int num = Integer.parseInt(reader.readLine());

            if (num == 1) {
                Action.choiceVinil(v1);
                break;
            } else {
                if (num == 2) {
                    Action.choiceVinil(v2);
                    break;
                }
                else {
                    if (num == 3) {
                        Action.choiceCD(cd1);
                        break;
                    }
                    else {
                        if (num == 4) {
                            Action.choiceCD(cd2);
                            break;
                        }
                        else {
                            if (num == 5) {
                                Action.choiceUniver(u1);
                                break;
                            }
                            else {
                                if (num == 6) {
                                    Action.choiceUniver(u2);
                                    break;
                                }
                                else {
                                    Action.choiceError();
                                    System.out.println("                   1. " + v1.name);
                                    System.out.println("                   2. " + v2.name);
                                    System.out.println("                   3. " + cd1.name);
                                    System.out.println("                   4. " + cd2.name);
                                    System.out.println("                   5. " + u1.name);
                                    System.out.println("                   6. " + u2.name + '\n');
                                    System.out.println("                           Выберите цифру устройства");
                                    System.out.println();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // рисует полоску во время "прослушивания" песни
    public static void play() throws InterruptedException {
        String inProgress = "                       >";
        System.out.print(inProgress);
        for (int i = 0; i < 35; i++) {
            Thread.sleep(250);
            System.out.print("-");
        }
        System.out.print("<");
        System.out.println();
        System.out.println();
    }

    // всякие текстовые выводы

    public static void songError() {
        System.out.println();
        System.out.println("                      Песни под таким номером нет");
        System.out.println("                    Будьте внимательней. Спасибо :)");
        System.out.println();
    }

    public static void choiceError() {
        System.out.println();
        System.out.println("                     Устройства под таким номером нет");
        System.out.println("                     Будьте внимательней. Спасибо :)");
        System.out.println();
    }

    public static void greetings() {
        System.out.println();
        System.out.println();
        System.out.println("             Добро пожаловать в межгалактический проигрователь Музяфон-2077" + '\n');
        System.out.println("         В вашем распоряжении имеются такие инструменты для воспроизведения как:" + '\n');
    }

    public static void errorMessage() {
        System.out.println();
        System.out.println("          Такое устройство ещё не изобретено или уже устарело и не используется" + '\n'
                + "                           Пожалуйста выберите другое");
        System.out.println();
    }

    public static void errorDevice() {
        System.out.println();
        System.out.println("                       Вы выбрали не то устройство" + '\n');
    }

    public static void offerMessage() {
        System.out.println();
        System.out.println("                       Выберите считывающие устройство:");
        System.out.println("                       Мы предлагаем вам такие варианты: " + '\n');
    }
}
