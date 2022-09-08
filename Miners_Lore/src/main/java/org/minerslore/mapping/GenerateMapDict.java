package org.minerslore.mapping;

import org.minerslore.Actors.Actor;
import org.minerslore.Interact_Objects;
import org.minerslore.mapitems.*;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Our Dictionary
public class GenerateMapDict {
    static Object minerObj; // convert string classname to class

    static {
        try {
            minerObj = Class.forName("org.minerslore.mapping.GenerateMapDict").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | RuntimeException |
                 InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    static Class<?>[] paramBuildMapTypes = {ArrayList.class, Point.class, char.class};
    static Class<?>[] paramUserCommandTypes = {Actor.class};

    public static Map<Character, String> to_Map_Functions = new HashMap<>(
            Map.of('=', "charToWallAddToMap",
                    '^', "charToDoorAddToMap",
                    ' ', "charToPathAddToMap",
                    '.', "charToCavePathAddToMap",
                    '*', "charToItemAddToMap"
            )
    );
    public static Map<Character, String> userCommands = new HashMap<>(
            Map.of('N', "goNorth",
                    'S', "goSouth",
                    'E', "goEast",
                    'W', "goWest",
                    'D', "actionDig"
            )
    );

    public static void charToWallAddToMap(ArrayList<Interact_Objects> mapObjectList, Point point, char ch) {
        ((ArrayList<Interact_Objects>) mapObjectList).add(new Wall(point));
    }

    public static void charToDoorAddToMap(ArrayList<Interact_Objects> mapObjectList, Point point, char ch) {
        ((ArrayList<Interact_Objects>) mapObjectList).add(new Door(point));
    }

    public static void charToPathAddToMap(ArrayList<Interact_Objects> mapObjectList, Point point, char ch) {
        ((ArrayList<Interact_Objects>) mapObjectList).add(new Path(point));
    }

    public static void charToCavePathAddToMap(ArrayList<Interact_Objects> mapObjectList, Point point, char ch) {
        ((ArrayList<Interact_Objects>) mapObjectList).add(new CavePath(point, false));
    }

    public static void charToItemAddToMap(ArrayList<Interact_Objects> mapObjectList, Point point, char ch) {
        ((ArrayList<Interact_Objects>) mapObjectList).add(new Item(ch, point, false));
    }

    public static void addToMap(ArrayList<Interact_Objects> mapObjectList, Point point, char ch) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        if (to_Map_Functions.containsKey(ch)) {
            minerObj.getClass().getMethod(to_Map_Functions.get(ch), paramBuildMapTypes).invoke(to_Map_Functions.get(ch), mapObjectList, point, ch);

        } else {
            minerObj.getClass().getMethod(to_Map_Functions.get('*'), paramBuildMapTypes).invoke(to_Map_Functions.get(ch), mapObjectList, point, ch);

        }
    }

    public static boolean commandContains(char ch) {
        return to_Map_Functions.containsKey(ch);
    }

    public static void goNorth(Actor actor) throws IOException {
        actor.moveActor(actor.getN());
    }

    public static void goSouth(Actor actor) throws IOException {
        actor.moveActor(actor.getS());
    }

    public static void goEast(Actor actor) throws IOException {
        actor.moveActor(actor.getE());
    }

    public static void goWest(Actor actor) throws IOException {
        actor.moveActor(actor.getW());
    }

    public static void actionDig(Actor actor) {

    }

    public static void actorActions(Actor actor, char ch) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        if (userCommands.containsKey(ch)) {
            System.out.println(ch);
            minerObj.getClass().getMethod(userCommands.get(ch), paramUserCommandTypes).invoke(userCommands.get(ch), actor);
        } else {
            System.out.println("Miner is confused.");
        }
    }

}
