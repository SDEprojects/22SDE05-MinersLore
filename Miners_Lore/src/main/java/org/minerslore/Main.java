package org.minerslore;


import org.minerslore.mapping.GameMap;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
//        ArrayList<Interact_Objects> mapObjectList=new ArrayList<Interact_Objects>();
//
//        CommandsDict.addToMap(mapObjectList,new Point(2,3),'&');
//        System.out.println(mapObjectList);
        GameMap map = new GameMap();


        Scanner reader = new Scanner(System.in);  // Reading from System.in

        char Command = ' ';
        while (Command!='q') {

            map.displayMap();

            System.out.println("Enter");
            Command = reader.next().toUpperCase().charAt(0);

            // Clear Screen
            clearConsole();

            map.handleCommand(Command);
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