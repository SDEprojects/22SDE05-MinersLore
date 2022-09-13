package org.minerslore;

import org.minerslore.mapping.GameMap;
import org.minerslore.stories.PrintStoriesToConsole;
import org.minerslore.stories.Story;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<String, Object> obj;

    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        Story.loadSplashYaml();
//        ArrayList<Interact_Objects> mapObjectList=new ArrayList<Interact_Objects>();
//
//        CommandsDict.addToMap(mapObjectList,new Point(2,3),'&');
//        System.out.println(mapObjectList);
        GameMap map = new GameMap();

        Scanner reader = new Scanner(System.in);  // Reading from System.in

        char command = ' ';
        while (command != 'Q') {

            map.displayMap();

            obj = PrintStoriesToConsole.parseYaml();
            System.out.println(obj.get(7));

            command = reader.next().toUpperCase().charAt(0);
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