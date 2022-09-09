package org.minerslore;

import org.minerslore.mapping.GameMap;
import org.minerslore.stories.Story;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;


public class Main {

    static Map<String, Object> obj;

    public static void main(String[] args) throws Exception {

        ClassLoader cl = Main.class.getClassLoader();
        java.io.InputStream input = cl.getResourceAsStream("Rand.yaml");
        Yaml yaml = new Yaml();
        obj = yaml.load(input);

        Story.loadSplashYaml();
//        ArrayList<Interact_Objects> mapObjectList=new ArrayList<Interact_Objects>();
//
//        CommandsDict.addToMap(mapObjectList,new Point(2,3),'&');
//        System.out.println(mapObjectList);
        GameMap map = new GameMap();


        Scanner reader = new Scanner(System.in);  // Reading from System.in

        char command = ' ';
        while (command!='Q') {

            map.displayMap();

            System.out.println("Enter");
            command=reader.next().toUpperCase().charAt(0);
            // Clear Screen
            clearConsole();
            map.handleCommand(command);

        }

    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

}