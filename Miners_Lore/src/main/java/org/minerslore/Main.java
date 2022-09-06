package org.minerslore;
import java.io.*;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws Exception {

        GameMap map = new GameMap();


        Scanner reader = new Scanner(System.in);  // Reading from System.in

        String Command = "";
        while (!Command.equals("q")) {

            // Clear Screen
            clearConsole();



            map.displayMap();

            System.out.println("Enter");
            Command = reader.next();

            map.moveMiner(Command);
        }





    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {}
    }


}