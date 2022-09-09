package org.minerslore.mapping;

import org.minerslore.Actors.ActionsDict;
import org.minerslore.Actors.Actor;
import org.minerslore.Actors.Miner;
import org.minerslore.Actors.Monster;
import org.minerslore.Actors.OldMan;
import org.minerslore.GameEntity;
import org.minerslore.Main;
import org.yaml.snakeyaml.Yaml;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class GameMap {
    private static final int DISPLAY_NUMBER = 16;
    private static List<String> helpList;
    private static Miner miner;
    private static Monster monster;
    private static int colSize;
    private static int rowSize;
    private static Map<String, Object> minersEquipment;


    public GameMap() {
        int minerStartX = 98;
        int minerStartY = 102;

        int oldManStartX = 96;
        int oldManStartY = 105;

        int monsterStartX = 90;
        int monsterStartY = 102;
        generateHelpList();
        List<ArrayList<GameEntity>> map = fetchStarterMap();

        colSize = map.size();
        rowSize = map.get(0).size();

        generateHelpList();

        miner = new Miner('M', new Point(minerStartX, minerStartY));
        addActorToMap(miner, map);

        monster = new Monster('!', new Point(monsterStartX, monsterStartY));
        addActorToMap(monster, map);

        addActorToMap(new OldMan('O', new Point(oldManStartX, oldManStartY)), map);


        setLinkedObjects(map);


    }

    public static List<ArrayList<GameEntity>> fetchStarterMap() {
        List<ArrayList<GameEntity>> map = new ArrayList<>();
        try {

            String row;
            int y = 0;
            ClassLoader cl = Main.class.getClassLoader();
            java.io.InputStream input = cl.getResourceAsStream("Map.yaml");

            Yaml yaml = new Yaml();

            java.util.Map<String, Object> obj = yaml.load(input);
            BufferedReader in = new BufferedReader(new StringReader(obj.get("Map1").toString()));

            while ((row = in.readLine()) != null) {

                ArrayList<GameEntity> mapObjectList = new ArrayList<>();
                List<Character> charList = row.chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());


                for (int x = 0; x < charList.size(); x++) {

                    GenerateMapDict.addToMap(mapObjectList,new Point(x,y),charList.get(x));

                }

                map.add(mapObjectList);
                y++;
            }
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("Caught exception reading resource " + "Maps", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    public static void displayMap() {
        int minerX = miner.getX();
        int minerY = miner.getY();
        GameEntity rootY = miner.getByIndex(((minerX + rowSize - DISPLAY_NUMBER) % rowSize), ((minerY + colSize - DISPLAY_NUMBER / 2) % colSize));
        List tempEquipKeys = List.of(minersEquipment.keySet().toArray());
        List tempEquipValues = List.of(minersEquipment.values().toArray());
        for (int y = 0; y < DISPLAY_NUMBER; y++) {
            StringBuilder sb = new StringBuilder();
            GameEntity rootX = rootY;
            for (int x = 0; x < DISPLAY_NUMBER * 2; x++) {
//                System.out.print(rootX);
                sb.append(rootX);
                rootX = rootX.getE();
            }
            if (y < helpList.size()) {
                System.out.println(sb.toString() +"\t\t"+ helpList.get(y));
            }   else if (y == helpList.size() ) {
                System.out.println(sb.toString() +"\t\tGold: " + "gold" + "KG");
            }else if (y > helpList.size()+2 && y < helpList.size() + tempEquipKeys.size()+4) {
                System.out.println(sb.toString() +"\t\t"+ tempEquipKeys.get(y - helpList.size()-3) + "\t" + tempEquipValues.get(y - helpList.size()-3));
            } else {
                System.out.println(sb);
            }
            rootY = rootY.getS();
        }
    }


    public static void setLinkedObjects(List<ArrayList<GameEntity>> map) {
        int colSize = map.size();
        for (int y = 0; y < colSize; y++) {
            ArrayList<GameEntity> list = map.get(y);
            int rowSize = list.size();

            for (int x = 0; x < rowSize; x++) {
                GameEntity temp = list.get(x);
                temp.setN(map.get((y - 1 + colSize) % colSize).get(x));
                temp.setS(map.get((y + 1 + colSize) % colSize).get(x));
                temp.setE(map.get(y).get((x + 1 + rowSize) % rowSize));
                temp.setW(map.get(y).get((x - 1 + rowSize) % rowSize));

            }
        }
    }

    public static void handleCommand(char userCommand) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ActionsDict.actorActions(miner,userCommand);

    }


    public static void generateHelpList() {
        ClassLoader cld = Main.class.getClassLoader();
        InputStream streamMapYaml = cld.getResourceAsStream("helpBar.yaml");

        Yaml yaml = new Yaml();

        Map<String, Object> tempHelp = yaml.load(streamMapYaml);
        helpList = ((ArrayList<String>) tempHelp.get("Help")).stream()
                .map(x->x.replace('5', (char) 0x00D1))
                .map(x->x.replace('.', (char) ' '))
                .collect(Collectors.toList());


        minersEquipment = (Map<String, Object>) tempHelp.get("Equipment");

    }

    public static void addActorToMap(Actor actor, List<ArrayList<GameEntity>> map) {
        int startx = actor.getX();
        int starty = actor.getY();
        actor.setOriginal_symbol(map.get(starty).get(startx));
        map.get(starty).set(startx, actor);

    }
}
