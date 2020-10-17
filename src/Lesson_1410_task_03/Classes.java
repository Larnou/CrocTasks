package Lesson_1410_task_03;

import java.util.ArrayList;
import java.util.Random;

public class Classes {
    // 3 класса для устройств
    public static class Vinil {
        String name;
        public Vinil(String name) { this.name = name; }
    }

    public static class CDPlayer {
        String name;
        public CDPlayer(String name) {
            this.name = name;
        }
    }

    public static class Universal {
        String name;
        public Universal(String name) {
            this.name = name;
        }
    }
    // 3 класса для носителей и задания им плейлиста (генерируется рандомно)
    public static class vinilDisk {
        String name;
        ArrayList<String> playlist;

        public vinilDisk(String name, ArrayList<String> playlist) {
            this.name = name;
            ArrayList<String> tmp = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 3; i++) {
                tmp.add(playlist.get(random.nextInt(playlist.size())));
            }
            this.playlist = tmp;
        }
    }

    public static class cdDisk {
        String name;
        ArrayList<String> playlist;

        public cdDisk(String name, ArrayList<String> playlist) {
            this.name = name;
            ArrayList<String> tmp = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 6; i++) {
                tmp.add(playlist.get(random.nextInt(playlist.size())));
            }
            this.playlist = tmp;
        }
    }

    public static class uniDisk {
        String name;
        ArrayList<String> playlist;

        public uniDisk(String name, ArrayList<String> playlist) {
            this.name = name;
            ArrayList<String> tmp = new ArrayList<>();
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                tmp.add(playlist.get(random.nextInt(playlist.size())));
            }
            this.playlist = tmp;
        }
    }
    // весь пул песен доступных для прослушивания
    public static ArrayList<String> createPlayList() {
        ArrayList<String> globalPlayList = new ArrayList<>();
        globalPlayList.add("Hell Yeah - The BossHoss");
        globalPlayList.add("Quarantine - Tim Montana Mat Best");
        globalPlayList.add("Hypnodancer - Little Big");
        globalPlayList.add("Peeping Tom - Jamie Berry Rosie Harte");
        globalPlayList.add("Bad Reputation - Joan Jett");
        globalPlayList.add("Lion - Bakermat");
        globalPlayList.add("Thunder - Imagine Dragons");
        globalPlayList.add("Bon Ton Boogie - Bernies Champagne Band");
        globalPlayList.add("Boom Boom - Justice Crew");
        globalPlayList.add("I’m So Sorry - Imagine Dragons");
        globalPlayList.add("When You Know - Puggy");
        globalPlayList.add("What It Do - E-Dubble");
        globalPlayList.add("Sofia - Alvaro Soler");
        globalPlayList.add("Lolly Bomb - Little Big");
        globalPlayList.add("Lucky Strike - Maroon 5");
        globalPlayList.add("Battle Symphony - Linkin Park");
        globalPlayList.add("No Destination - Dikko");
        globalPlayList.add("Indian Summer - Jai Wolf");
        globalPlayList.add("99 Problems - Hugo");
        globalPlayList.add("4U - Aero Chord");
        globalPlayList.add("Yuve Yuve Yu - The Hu");
        globalPlayList.add("Fourth Of July - Fall Out Boy");
        globalPlayList.add("Juicy Wiggle - Redfoo");
        globalPlayList.add("Don't Look Down - Martin Garrix, Usher");
        globalPlayList.add("The Ocean - Mike Perry, Shy Martin");
        globalPlayList.add("Real Good Feeling - Oh The Larceny");
        globalPlayList.add("Shooting Stars - Bag Raiders");
        return globalPlayList;
    }
}
