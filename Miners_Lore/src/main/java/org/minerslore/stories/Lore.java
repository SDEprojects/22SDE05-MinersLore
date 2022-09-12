package org.minerslore.stories;

import org.minerslore.Main;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

public class Lore {

    static Scanner stringScanner = new Scanner(System.in); // Scanner that takes string input
    public static Scanner intScanner = new Scanner(System.in); // Scanner that takes int input
    static Map<String, Object> obj;
    static Map<String, Object> obj1;
    static Map<String, Object> obj2;

    public static void getYaml() {

        ClassLoader cl = Main.class.getClassLoader();
        InputStream input = cl.getResourceAsStream("Rand.yaml");
        Yaml yaml = new Yaml();
        obj = yaml.load(input);

    }

    public static void runOldMainStory() {


    }

    public static void runMainStory() {


    }
}
