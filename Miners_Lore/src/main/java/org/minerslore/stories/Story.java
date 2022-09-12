package org.minerslore.stories;

import org.minerslore.Main;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Story {

    static Scanner stringScanner = new Scanner(System.in); // Scanner that takes string input
    public static Scanner intScanner = new Scanner(System.in); // Scanner that takes int input
    static Map<String, Object> obj;

    public void mainStory() throws IOException {

        ClassLoader cl = Main.class.getClassLoader();
        java.io.InputStream input = cl.getResourceAsStream("Rand.yaml");
        Yaml yaml = new Yaml();
        obj = yaml.load(input);

        loadSplashYaml();
        loadStoryYaml();

        System.out.println(obj.get("Continue"));

        askQuestions();
        int minerDecision = intScanner.nextInt();

        playerChoices(minerDecision);

    }

    public static void playerChoices(int minerDecision) throws IOException {

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
                System.out.println(obj.get("INVALID")); //TODO: CANNOT FIGURE THIS PART OUT
        }
    }

    public static void askQuestions() {
        System.out.println(obj.get("Continue1"));
    }

    public static void loadSplashYaml() {
        ClassLoader cl = Main.class.getClassLoader();

        java.io.InputStream input = cl.getResourceAsStream("Splash.yaml");

        Yaml yaml = new Yaml();

        Map<String, Object> obj = yaml.load(input);

//        BufferedReader in = new BufferedReader(new StringReader(obj.get("Splash1").toString()));

        System.out.println(obj.get("Splash1"));

    }

    public static void loadStoryYaml() {
        ClassLoader cl = Main.class.getClassLoader();

        java.io.InputStream input = cl.getResourceAsStream("Story.yaml");

        Yaml yaml = new Yaml();

        obj = yaml.load(input);

//        BufferedReader in = new BufferedReader(new StringReader(obj.get("STORY").toString()));
        System.out.println(obj.get("Start"));

    }

}