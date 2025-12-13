package main;

import java.util.*;

public class Data {
    public static String currentUser = null;
    public static List<String> clubs = new ArrayList<>();
    public static List<String> events = new ArrayList<>();

    static {
        clubs.add("MU Robotics Club");
        clubs.add("Enigma MU");
        clubs.add("8Counts");
        clubs.add("Blockchain Club");
        clubs.add("Synolo: The Music Club");

        events.add("Aeon");
        events.add("Airo");
        events.add("Aether");
    }
}
