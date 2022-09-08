package org.minerslore.stories;

import org.minerslore.Main;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class Story {

    static Scanner stringScanner = new Scanner(System.in); // Scanner that takes string input
    public static Scanner intScanner = new Scanner(System.in); // Scanner that takes int input
    static Map<String, Object> obj;

    public void mainStory() throws IOException {
        loadStoryYaml();
        askQuestions();
        int minerDecision = intScanner.nextInt();
        System.out.println(minerDecision);
        playerChoices(minerDecision);

    }

    public static void playerChoices(int minerDecision) throws IOException {

        switch (minerDecision) {
            case 1:
                System.out.println
                        ("Miner: Hey what did you mean in case I dont make it out?" + "\n\n" +
                                "Old Man: That's because most of you greedy folks get eaten up by the TommyKnocker. " + "\n\n" +
                                "Narrator/Miner: He let out a creepy cackle... Hahahaha...cough....hahah. No more questions Sonny. " +
                                "\n\n" +
                                "Narrator: Then he limped off into the hot desert air and disappeared into the distance." + "\n\n\n"
                        );
                askQuestions();
                int minerDecision2 = intScanner.nextInt();
                playerChoices(minerDecision2);
                break;
            case 2:
                System.out.println("You've entered the store. Please select your items." + "\n\n\n");
                break;
            case 3:
                System.out.println("GAME OVER! GOODBYE!" + "\n");
                System.exit(0);
                break;
            default:
                System.out.println("Please enter a valid number." + "\n\n\n");
        }
    }

    public static void askQuestions() {
        System.out.println
                ("What would you like to do next?" + "\n" +
                        "-------------------------------" + "\n" +
                        "1. Ask the old man what he meant by his sullen words. " + "\n" +
                        "2. Enter the store to collect your necessities. " + "\n" +
                        "3. Exit the game." + "\n");
    }

    public static void loadSplashYaml() {
        ClassLoader cl = Main.class.getClassLoader();

        java.io.InputStream input = cl.getResourceAsStream("Splash.yaml");

        Yaml yaml = new Yaml();

        Map<String, Object> obj = yaml.load(input);

        BufferedReader in = new BufferedReader(new StringReader(obj.get("Splash1").toString()));

        System.out.println(obj.get("Splash1"));

    }

    public static void loadStoryYaml() {
        ClassLoader cl = Main.class.getClassLoader();

        java.io.InputStream input = cl.getResourceAsStream("Story.yaml");

        Yaml yaml = new Yaml();

        obj = yaml.load(input);

        BufferedReader in = new BufferedReader(new StringReader(obj.get("STORY").toString()));
        System.out.println(obj.get("Start"));

    }

}