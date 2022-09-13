package org.minerslore.stories;

import org.minerslore.Main;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;
import java.util.Scanner;

public class Story {
    private static final Scanner intScanner = new Scanner(System.in); // Scanner that takes int input
    private static Map<String, Object> obj;

    public void mainStory() {

        loadSplashYaml();

        loadStoryYaml();

        System.out.println(obj.get("Continue"));

        askQuestions();

        int minerDecision = intScanner.nextInt();

        playerChoices(minerDecision);

    }

    public static void playerChoices(int minerDecision) {

        switch (minerDecision) {
            case 1:
                System.out.println(obj.get(1));
                askQuestions();
                int minerDecision2 = intScanner.nextInt();
                playerChoices(minerDecision2);
                break;
            case 2:
                System.out.println(obj.get(2));
                break;
            case 3:
                System.out.println(obj.get(3));
                System.exit(0);
                break;
            default:
                System.out.println(obj.get(4));
                askQuestions();
                int minerDecision3 = intScanner.nextInt();
                playerChoices(minerDecision3);
        }
    }

    public static void askQuestions() {
        System.out.println(obj.get("Continue1"));
    }

    public static void loadSplashYaml() {
        ClassLoader cl = Main.class.getClassLoader();

        java.io.InputStream input = cl.getResourceAsStream("Splash.yaml");

        Yaml yaml = new Yaml();

        obj = yaml.load(input);

        System.out.println(obj.get("Splash1"));

    }

    public static void loadStoryYaml() {
        ClassLoader cl = Main.class.getClassLoader();

        java.io.InputStream input = cl.getResourceAsStream("Story.yaml");

        Yaml yaml = new Yaml();

        obj = yaml.load(input);

        System.out.println(obj.get("Start"));

    }

}