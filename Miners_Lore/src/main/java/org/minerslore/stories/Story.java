package org.minerslore.stories;
import org.minerslore.Main;
import org.yaml.snakeyaml.Yaml;
import java.util.Map;
import java.util.Scanner;

public class Story {

    public static Map<String, Object> splashMap;
    public static Map<String, Object> storyMap;
    public static Map<String, Object> randMap;

    static {
        ClassLoader cl = Main.class.getClassLoader();
        Yaml yaml = new Yaml();

        java.io.InputStream splashYaml = cl.getResourceAsStream("Splash.yaml");
        java.io.InputStream storyYAML = cl.getResourceAsStream("Story.yaml");
        java.io.InputStream randYAML = cl.getResourceAsStream("Rand.yaml");

        splashMap = yaml.load(splashYaml);
        storyMap = yaml.load(storyYAML);
        randMap = yaml.load(randYAML);
    }

    public static void beginStory() {
        System.out.println(splashMap.get("Splash1"));
        Scanner userInput = new Scanner(System.in);
        System.out.println("Any key to continue.");
        userInput.next().toUpperCase().charAt(0);
    }

    public static void mainStory() {
        System.out.println(storyMap.get("Continue"));
        System.out.println(storyMap.get("Continue1"));
        int minerDecision = getUserResponse();
        playerChoices(minerDecision);
    }

    public static int getUserResponse() {
        Scanner userInput = new Scanner(System.in);
        while (!userInput.hasNextInt()) {
            System.out.println("Input is not a number.");
            System.out.println(storyMap.get("Continue1"));
            userInput.nextLine();
            if (userInput.hasNextInt()){
                playerChoices(userInput.nextInt());
            }
        }
        return userInput.nextInt();
    }

    public static void playerChoices(int minerDecision) {

        switch (minerDecision) {
            case 1:
                System.out.println(storyMap.get(1));
                System.out.println(storyMap.get("Continue1"));
                int minerDecision2 = getUserResponse();
                playerChoices(minerDecision2);
                break;
            case 2:
                System.out.println(storyMap.get(2));
                break;
            case 3:
                System.out.println(storyMap.get(3));
                System.exit(0);
                break;
            default:
                System.out.println(storyMap.get("INVALID"));
                break;
        }
    }

}