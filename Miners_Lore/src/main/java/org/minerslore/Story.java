package org.minerslore;

import java.util.Scanner;

public class Story {

    // variables
    static Scanner stringScanner = new Scanner(System.in); // Scanner that takes string input
    static Scanner intScanner = new Scanner(System.in); // Scanner that takes int input

    public static void mainStory() {
        System.out.println("\n\n" + "^^^^^^^^^^^^^^^^^^^^^^^^^^WELCOME TO MINERS LORE^^^^^^^^^^^^^^^^^^^^^^^^^^" +
                "^^^^^^^^^^^^^^^");
        System.out.println("\n\n");
        System.out.println("\n" + "You approach the mine store and see an old, decrepit man leaning against the " +
                "entrance..." + "\n");
        System.out.println("You try to step past him but he stops you by blocking you with his cane." + "\n");
        System.out.println("He says, Sonny you aint getting in here without telling me your name, now let me here it."
                + "\n");
        System.out.println("Please enter your name" + "\n");
        String minerName = stringScanner.nextLine();
        System.out.println("\n" + "Welcome to the spooky, miner cave store " + minerName + ". I'm gonna put you on my " +
                "" +
                "list. ");
        System.out.println("You think to yourself, what a weird interaction." + "\n");
        System.out.println("What would you like to do next?");
        System.out.println("-------------------------------" + "\n");
        System.out.println("1. Ask the old man what he meant by his sullen words. " + "\n"
                            + "2. Enter the store to collect your necessities. " + "\n"
                            + "3. Exit the game." + "\n");
        int minerDecision = intScanner.nextInt();

        if (minerDecision == 1) {
            System.out.println("Hey what did you mean in case I dont make it out?" + "\n");
            System.out.println("That's because most of you greedy folks get eaten up by the TommyKnocker. " +
                    "He let out a creepy cackle... Hahahaha...cough....hahah. No more questions Sonny. " + "\n");
            System.out.println("Then he limped off into the hot desert air and disappeared into the distance." + "\n\n\n");
            System.out.println("What would you like to do next?");
            System.out.println("-------------------------------" + "\n");
            System.out.println("1. Ask the old man what he meant by his sullen words. " + "\n"
                    + "2. Enter the store to collect your necessities. " + "\n"
                    + "3. Exit the game." + "\n");
          minerDecision = intScanner.nextInt();
          if (minerDecision == 2) {
              System.out.println("You've entered the store. Please select your items." + "\n\n\n");
          }


        }
        else if (minerDecision == 2) {
            System.out.println("You've entered the store. Please select your items." + "\n\n\n");
        }
        else if (minerDecision == 3) {
            System.out.println("GAME OVER! GOODBYE!");
            mainStory();
        }
        else {
            System.out.println("Please enter a valid number.");
        }

    }

    private static void minerStory() {
    }
}

