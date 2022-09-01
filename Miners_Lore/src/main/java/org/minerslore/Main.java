package org.minerslore;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
//        Story.mainStory();


        Map map = new Map();

        Scanner reader = new Scanner(System.in);  // Reading from System.in

        String Command = "";
        while (!Command.equals("quit")) {

            // The Code below should clear the terminal window screen, although it does not work in Intellij.
//            System.out.print("\033[H\033[2J");
//            System.out.flush();

            map.displayMap();

            System.out.println("Enter");
            Command = reader.next();

            map.moveMiner(Command);
        }


    }
}