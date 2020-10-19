package Lesson_1410_task_03;

import java.io.IOException;
import java.util.ArrayList;

import static Lesson_1410_task_03.Classes.*;

/**
 * Necessary to develop the music system <p>Homework for 10.14.2020</p>
 * @author <strong>Shubin Dmitry</strong>, made for Croc
 */
public class Muzyafon {
    /**
     * Main class to run Myzyafon-2077
     * @param args basic params for main
     * @throws IOException possible exception
     * @throws InterruptedException possible exception
     */
    public static void main(String[] args) throws IOException, InterruptedException {

        /*
          Создание музыкальных устройств
         */
        Classes.Vinil vinil = new Classes.Vinil("Винилон-752");
        Classes.CDPlayer cdplayer = new Classes.CDPlayer("Сидишка-26");
        Classes.Universal universal = new Classes.Universal("Швейцарский-нож");

        /*
          Создание музыкальных носителей
         */
        Classes.vinilDisk v1 = new Classes.vinilDisk("Виниловая пластинка: Винишко под вечер", createPlayList());
        Classes.vinilDisk v2 = new Classes.vinilDisk("Виниловая пластинка: Винил прошлого", createPlayList());
        Classes.cdDisk cd1 = new Classes.cdDisk("CD: Для отдыха", createPlayList());
        Classes.cdDisk cd2 = new Classes.cdDisk("CD: Вы нашли, мы показали", createPlayList());
        Classes.uniDisk u1 = new Classes.uniDisk("Флешка: 10 хитов 2077 года", createPlayList());
        Classes.uniDisk u2 = new Classes.uniDisk("Флешка: Ещё немного хитов", createPlayList());

        /*
          Вступительные слова
         */
        Action.greetings();

        System.out.println("                      " + vinil.name + " " + cdplayer.name + " " + universal.name + '\n');
        System.out.println("                             Выберите ваше устройство: " + '\n');

        /*
          Проверка на правильность введённого устройства
          musicInstruments - массив в котором лежат доступные значения для выбора
          justToKnow в массив заносится название устройства выбранного пользователем
         */
        ArrayList<String> musicInstruments = new ArrayList<>();
        musicInstruments.add(vinil.name);
        musicInstruments.add(cdplayer.name);
        musicInstruments.add(universal.name);
        ArrayList<String> justToKnow = Action.checkFirstInput(musicInstruments);

        Action.offerMessage();

        if (justToKnow.get(0).equals(vinil.name)) {
            /*
              Если введённое имя устройства соответствует виниловому проигрывателю, то:
              Выводится список песен для пластинок
              v1 - Пластинка: Винишко под вечер
              v2 - Пластинка: Винил прошлого
             */
            Action.outputDeviceVinil(v1, v2);
        }

        if (justToKnow.get(0).equals(cdplayer.name)) {
            /*
              Если введённое имя устройства соответствует проигрывателю cd-дисков, то:
              Выводится список песен для CD-дисков
              cd1 - CD-диск: Для отдыха
              cd2 - CD-диск: Вы нашли, мы показали
             */
            Action.outputDeviceCD(cd1, cd2);
        }

        if (justToKnow.get(0).equals(universal.name)) {
            /*
              Если введённое имя устройства соответствует универсальному проигрывателю, то:
              Выводится список песен для пластинок
              v1 - пластинка Винишко под вечер
              v2 - пластинка Винил прошлого
              cd1 - CD-диск Для отдыха
              cd2 - CD-диск Вы нашли, мы показали
              u1 - Флешка 10 хитов 2077 года
              u2 - Флешка Ещё немного хитов
             */
            Action.outputDeviceUnivers(v1, v2, cd1, cd2, u1, u2);
        }
    }
}
