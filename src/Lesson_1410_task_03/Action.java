package Lesson_1410_task_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * All actions are stored here
 * @author <strong>Shubin Dmitry</strong>, made for Croc
 */
public class Action {

    /**
     * Take the vinyl record and show playlist of this record, if user choose number of song which doesn't exist
     * Myzyafon will offer to chose another number, until this number exist. After it plays the chosen song
     * and close the Myzyafon
     * @param param one of the vinyl records
     * @throws IOException possible exception
     * @throws InterruptedException possible exception
     * @see Action#play()
     * @see Action#songError()
     */
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
                System.out.println("                    Спасибо за использование Музяфона-2077");
                System.out.println("                              Ждём вас снова");
                break;
            } else {
                songError();
            }
        }
    }

    /**
     * Take the cd disk and show playlist of this disk, if user choose number of song which doesn't exist
     * Myzyafon will offer to chose another number, until this number exist. After it plays the chosen song
     * and close the Myzyafon
     * @param param one of the CD disks
     * @throws IOException possible exception
     * @throws InterruptedException possible exception
     * @see Action#play()
     * @see Action#songError()
     */
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
                System.out.println("                    Спасибо за использование Музяфона-2077");
                System.out.println("                              Ждём вас снова");
                break;
            } else {
                songError();
            }
        }
    }

    /**
     * Take any device and show playlist of this device, if user choose number of song which doesn't exist
     * Myzyafon will offer to chose another number, until this number exist. After it plays the chosen song
     * and close the Myzyafon
     * @param param one of the flesh-cards
     * @throws IOException possible exception
     * @throws InterruptedException possible exception
     * @see Action#play()
     * @see Action#songError()
     */
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

    /**
     * Check if name of this device exist, if not will offer to input until it's done
     * @param param Array of the names existing devices to play songs
     * @return Choosen name of song-player device
     * @throws IOException possible exception
     * @see Action#errorMessage()
     */
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

    /**
     * Shows playlist of chosen device, user needs to chose the number of the song, if this number don't exist
     * user should input the number one more time
     * @param v1 vinyl record Vine for the evening
     * @param v2 vinyl record Vinyl of the last
     * @throws IOException possible exception
     * @throws InterruptedException possible exception
     * @see Action#choiceVinil(Classes.vinilDisk)
     * @see Action#errorDevice()
     */
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
                choiceVinil(v1);
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

    /**
     * Shows playlist of chosen device, user needs to chose the number of the song, if this number don't exist
     * user should input the number one more time
     * @param v1 cd disk For chill
     * @param v2 cd disk You have found, we are showing
     * @throws IOException possible exception
     * @throws InterruptedException possible exception
     * @see Action#choiceCD(Classes.cdDisk)
     * @see Action#errorDevice()
     */
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

    /**
     * Shows playlist of chosen device, user needs to chose the number of the song, if this number don't exist
     * @param v1 vinyl record Vine for the evening
     * @param v2 vinyl record Vinyl of the last
     * @param cd1 cd disk For chill
     * @param cd2 cd disk You have found, we are showing
     * @param u1 flesh card Top 10 of 2077
     * @param u2 flesh card More songs
     * @throws IOException possible exception
     * @throws InterruptedException possible exception
     * @see Action#choiceVinil(Classes.vinilDisk)
     * @see Action#choiceCD(Classes.cdDisk)
     * @see Action#choiceUniver(Classes.uniDisk)
     * @see Action#choiceError()
     */
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

    /**
     * Draw animation that song is "playing"
     * @throws InterruptedException possible exception
     */
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


    /**
     * Text output, if song with that number doesn't exist
     */
    public static void songError() {
        System.out.println();
        System.out.println("                      Песни под таким номером нет");
        System.out.println("                    Будьте внимательней. Спасибо :)");
        System.out.println();
    }

    /**
     * Text output, if device with that number doesn't exist
     */
    public static void choiceError() {
        System.out.println();
        System.out.println("                     Устройства под таким номером нет");
        System.out.println("                     Будьте внимательней. Спасибо :)");
        System.out.println();
    }

    /**
     * Greeting
     */
    public static void greetings() {
        System.out.println();
        System.out.println();
        System.out.println("             Добро пожаловать в межгалактический проигрователь Музяфон-2077" + '\n');
        System.out.println("         В вашем распоряжении имеются такие инструменты для воспроизведения как:" + '\n');
    }

    /**
     * Text output, if song-player device doesn't exist
     */
    public static void errorMessage() {
        System.out.println();
        System.out.println("          Такое устройство ещё не изобретено или уже устарело и не используется" + '\n'
                + "                           Пожалуйста выберите другое");
        System.out.println();
    }

    /**
     * Text output
     */
    public static void errorDevice() {
        System.out.println();
        System.out.println("                       Вы выбрали не то устройство" + '\n');
    }

    /**
     * Text output, after greetings
     */
    public static void offerMessage() {
        System.out.println();
        System.out.println("                       Выберите считывающие устройство:");
        System.out.println("                       Мы предлагаем вам такие варианты: " + '\n');
    }
}
