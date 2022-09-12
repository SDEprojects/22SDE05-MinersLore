package org.minerslore.mapping;

import org.minerslore.GameEntities.GameEntity;
import org.minerslore.GameEntities.mapitems.*;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Our Dictionary
public class MapDictionary {
    private final static Object minerObj; // convert string classname to class

    static {
        try {
            minerObj = Class.forName("org.minerslore.mapping.MapDictionary").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | RuntimeException |
                 InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private final static Class<?>[] paramBuildMapTypes = {ArrayList.class, Point.class, char.class};


    private final static Map<Character, String> to_Map_Functions = new HashMap<>(
            Map.of('=', "charToWallAddToMap",
                    '^', "charToDoorAddToMap",
                    ' ', "charToPathAddToMap",
                    '.', "charToCavePathAddToMap",
                    '*', "charToItemAddToMap",
                    '-', "charToBoundaryAddToMap",
                    '+', "charToJewelAddToMap",
                    'w', "charToWaterAddToMap",
                    ',', "charToGrassAddToMap"
            )
    );


    public final static void charToWallAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new Wall(point));
    }

    public final static void charToDoorAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new Door(point));
    }

    public final static void charToPathAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new Path(point));
    }

    public final static void charToCavePathAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new CavePath(point, false));
    }

    public final static void charToItemAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new Item(ch, point, false));
    }

    public final static void charToBoundaryAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new Boundary(point));
    }

    public final static void charToJewelAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new Jewel(point));
    }

    public final static void charToWaterAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new Water(point));
    }

    public final static void charToGrassAddToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) {
        ((ArrayList<GameEntity>) mapObjectList).add(new Grass(point));
    }

    protected final static void addToMap(ArrayList<GameEntity> mapObjectList, Point point, char ch) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        if (to_Map_Functions.containsKey(ch)) {
            minerObj.getClass().getMethod(to_Map_Functions.get(ch), paramBuildMapTypes).invoke(to_Map_Functions.get(ch), mapObjectList, point, ch);

        } else {
            minerObj.getClass().getMethod(to_Map_Functions.get('*'), paramBuildMapTypes).invoke(to_Map_Functions.get(ch), mapObjectList, point, ch);

        }
    }


}
