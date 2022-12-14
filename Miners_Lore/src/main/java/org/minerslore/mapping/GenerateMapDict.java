package org.minerslore.mapping;

import org.minerslore.Actors.Actor;
import org.minerslore.GameEntity;
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
                    '*', "charToItemAddToMap",
                    '-', "charToBoundaryAddToMap",
                    '+', "charToJewelAddToMap"
            )
    );


    public static void charToWallAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new Wall(point));
    }

    public static void charToDoorAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new Door(point));
    }

    public static void charToPathAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new Path(point));
    }

    public static void charToCavePathAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new CavePath(point, false));
    }

    public static void charToItemAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new Item(ch, point, false));
    }

    public static void charToBoundaryAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new Boundary(point));
    }

    public static void charToJewelAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new Jewel(point));
    }

    public static void addToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        if (to_Map_Functions.containsKey(ch)) {
            minerObj.getClass().getMethod(to_Map_Functions.get(ch), paramBuildMapTypes).invoke(to_Map_Functions.get(ch), mapObjectList, point, ch);

        } else {
            minerObj.getClass().getMethod(to_Map_Functions.get('*'), paramBuildMapTypes).invoke(to_Map_Functions.get(ch), mapObjectList, point, ch);

        }
    }




}
