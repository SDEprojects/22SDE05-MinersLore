package org.minerslore;

import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.*;

public class Dictionary {
    public static void main(String[] args) throws Exception {
        Map<Character, Method> playerAction = new HashMap<Character, Method>();

        playerAction.put('d', Dictionary.class.getMethod("dig"));
        playerAction.put('g', Dictionary.class.getMethod("gather"));
        playerAction.put('r', Dictionary.class.getMethod("run"));
        playerAction.put('h', Dictionary.class.getMethod("hit"));
        playerAction.put('n', Dictionary.class.getMethod("north"));
        playerAction.put('s', Dictionary.class.getMethod("south"));
        playerAction.put('e', Dictionary.class.getMethod("east"));
        playerAction.put('w', Dictionary.class.getMethod("west"));

        char cmd = 'd';
        playerAction.get(cmd).invoke(null); // prints dig


//            playerAction.put("d", "dig");
//            playerAction.put("g", "gather");
//            playerAction.put("r", "run");
//            playerAction.put("h", "hit");
//            playerAction.put("n", "north");
//            playerAction.put("e", "east");
//            playerAction.put("s", "south");
//            playerAction.put("w", "west");
//             System.out.println(playerAction);
    }

    public static void dig() {
        System.out.println("dig");
    }

    public static void gather() {
        System.out.println("gather");
    }
}
