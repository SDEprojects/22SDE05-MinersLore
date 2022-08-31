package org.minerslore;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.*;

// Our Dictionary
public class Dictionary {
    public static void dict() throws Exception {

        Map<Character, Method> playerAction = new HashMap<Character, Method>();

        playerAction.put('d', Dictionary.class.getMethod("dig"));
        playerAction.put('g', Dictionary.class.getMethod("gather"));
        playerAction.put('r', Dictionary.class.getMethod("run"));
        playerAction.put('h', Dictionary.class.getMethod("hit"));
        playerAction.put('n', Dictionary.class.getMethod("north"));
        playerAction.put('s', Dictionary.class.getMethod("south"));
        playerAction.put('e', Dictionary.class.getMethod("east"));
        playerAction.put('w', Dictionary.class.getMethod("west"));

        char cmdD = 'd';
        playerAction.get(cmdD).invoke(null); // prints dig

        char cmdG = 'g';
        playerAction.get(cmdG).invoke(null); // prints gather

        char cmdR = 'r';
        playerAction.get(cmdR).invoke(null); // prints run

        char cmdH = 'h';
        playerAction.get(cmdH).invoke(null); // prints hit

        char cmdN = 'n';
        playerAction.get(cmdN).invoke(null); // prints north

        char cmdE = 'e';
        playerAction.get(cmdE).invoke(null); // prints south

        char cmdS = 's';
        playerAction.get(cmdS).invoke(null); // prints east

        char cmdW = 'w';
        playerAction.get(cmdW).invoke(null); // prints west

    }

    public static void dig() {

    }

    public static void gather() {
        System.out.println("gather");
    }

    public static void run() {
        System.out.println("run");
    }

    public static void hit() {
        System.out.println("hit");
    }

    public static void north() {
        System.out.println("north");
    }

    public static void east() {
        System.out.println("east");
    }

    public static void south() {
        System.out.println("south");
    }

    public static void west() {
        System.out.println("west");
    }
}
