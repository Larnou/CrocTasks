package Lesson_1410_task_03;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classes which are used for the Myzyafon-2077
 * @author <strong>Shubin Dmitry</strong>, made for Croc
 */
public class Classes {

    /**
     * Vinyl song-player device class
     */
    public static class Vinil {
        String name;

        /**
         * Constructor for making names of Vinyl type of song-player devices
         * @param name name of song-player devices
         */
        public Vinil(String name) {
            this.name = name;
        }
    }

    /**
     * CD song-player device class
     */
    public static class CDPlayer {
        String name;

        /**
         * Constructor for making names of CD type of song-player devices
         * @param name name of song-player devices
         */
        public CDPlayer(String name) {
            this.name = name;
        }
    }

    /**
     * Universal player
     */
    public static class Universal {
        String name;

        /**
         * Constructor for making names of FLash card type of song-player devices
         * @param name name of song-player devices
         */
        public Universal(String name) {
            this.name = name;
        }
    }

    /**
     * Vinyl record class
     */
    public static class vinilDisk {
        String name;
        ArrayList<String> playlist;

        /**
         * Constructor for making playlist, generates randomly
         * @param name name of the vinyl record
         * @param playlist playlist of the vinyl record
         */
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

    /**
     * CD disk class
     */
    public static class cdDisk {
        String name;
        ArrayList<String> playlist;

        /**
         * Constructor for making playlist, generates randomly
         * @param name name of the vinyl record
         * @param playlist playlist of the vinyl record
         */
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

    /**
     * Flash cards class
     */
    public static class uniDisk {
        String name;
        ArrayList<String> playlist;

        /**
         * Constructor for making playlist, generates randomly
         * @param name name of the vinyl record
         * @param playlist playlist of the vinyl record
         */
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

    /**
     * All song which are accessible for listening
     * @return Array with all songs
     */
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
