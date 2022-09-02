package org.minerslore;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws Exception {

        File file = new File(Main.class.getClassLoader().getResource("Story.yaml").getFile());
        Yaml yaml = new Yaml();
        InputStream input = new FileInputStream(file);
        java.util.Map<String, Object> obj = yaml.load(input);
        System.out.println(obj.get("STORY"));


        GameMap map = new GameMap();

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