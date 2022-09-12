package org.minerslore;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        actionMap map = new actionMap();

        char command = 0;

        while (command != 'Q') {

            map.displayMap();

            System.out.println("Enter");
            command = reader.next().toUpperCase().charAt(0);

            // Clear Screen
            clearConsole();

            map.handleCommand(command);

        }

    }

    private final static void clearConsole() {
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