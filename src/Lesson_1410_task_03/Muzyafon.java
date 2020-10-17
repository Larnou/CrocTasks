package Lesson_1410_task_03;

import java.io.IOException;
import java.util.ArrayList;

import static Lesson_1410_task_03.Classes.*;

public class Muzyafon {
    public static void main(String[] args) throws IOException, InterruptedException {
        Classes.Vinil vinil = new Classes.Vinil("Винилон-752");
        Classes.CDPlayer cdplayer = new Classes.CDPlayer("Сидишка-26");
        Classes.Universal universal = new Classes.Universal("Швейцарский-нож");

        ArrayList<String> musicInstruments = new ArrayList<>();
        musicInstruments.add(vinil.name);
        musicInstruments.add(cdplayer.name);
        musicInstruments.add(universal.name);

        Classes.vinilDisk v1 = new Classes.vinilDisk("Виниловая пластинка: Винишко под вечер", createPlayList());
        Classes.vinilDisk v2 = new Classes.vinilDisk("Виниловая пластинка: Винил прошлого", createPlayList());
        Classes.cdDisk cd1 = new Classes.cdDisk("CD: Для отдыха", createPlayList());
        Classes.cdDisk cd2 = new Classes.cdDisk("CD: Вы нашли, мы показали", createPlayList());
        Classes.uniDisk u1 = new Classes.uniDisk("Универсал: 10 хитов 2077 года", createPlayList());
        Classes.uniDisk u2 = new Classes.uniDisk("Универсал: Ещё немного хитов", createPlayList());

        Action.greetings();

        System.out.println("                      " + vinil.name + " " + cdplayer.name + " " + universal.name + '\n');
        System.out.println("                             Выберите ваше устройство: " + '\n');

        ArrayList<String> justToKnow = Action.checkFirstInput(musicInstruments); // проверяем и запоминаем что ввёл юзер

        Action.offerMessage();

        if (justToKnow.get(0).equals(vinil.name)) {
            Action.outputDeviceVinil(v1, v2);  // тут просходит магия смотреть в классе Action (98 строка)
        }

        if (justToKnow.get(0).equals(cdplayer.name)) {
            Action.outputDeviceCD(cd1, cd2);  // по аналогии с примером выше (Action 128 строка)
        }

        if (justToKnow.get(0).equals(universal.name)) {
            Action.outputDeviceUnivers(v1, v2, cd1, cd2, u1, u2); // тоже самое но 6 параметров (Action 156 строка)
        }
    }
}
