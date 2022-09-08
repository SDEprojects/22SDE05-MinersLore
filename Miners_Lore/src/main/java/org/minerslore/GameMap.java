package org.minerslore;

import org.minerslore.Actors.Actor;
import org.minerslore.Actors.Miner;
import org.minerslore.Actors.Monster;
import org.minerslore.Actors.OldMan;
import org.yaml.snakeyaml.Yaml;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GameMap {
    private static final int DISPLAY_NUMBER = 16;
    private static List<String> helpList = new ArrayList<>(16);
    private static Miner miner;
    private static Monster monster;
    private static int colSize;
    private static int rowSize;


    public GameMap() {
        int minerStartX = 98;
        int minerStartY = 102;

        int oldManStartX = 96;
        int oldManStartY = 105;

        int monsterStartX = 90;
        int monsterStartY = 102;

        List<ArrayList<Interact_Objects>> map = fetchStarterMap();

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

    public static List<ArrayList<Interact_Objects>> fetchStarterMap() {
        List<ArrayList<Interact_Objects>> map = new ArrayList<>();
        try {

            String row;
            int y = 0;
            ClassLoader cl = Main.class.getClassLoader();
            java.io.InputStream input = cl.getResourceAsStream("Map.yaml");

            Yaml yaml = new Yaml();

            java.util.Map<String, Object> obj = yaml.load(input);
            BufferedReader in = new BufferedReader(new StringReader(obj.get("Map1").toString()));

            while ((row = in.readLine()) != null) {

                ArrayList<Interact_Objects> mapObjectList = new ArrayList<>();
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
        StringBuilder sb = new StringBuilder();
        Interact_Objects rootY = miner.getByIndex(((minerX + rowSize - DISPLAY_NUMBER) % rowSize), ((minerY + colSize - DISPLAY_NUMBER / 2) % colSize));

        for (int y = 0; y < DISPLAY_NUMBER; y++) {

            Interact_Objects rootX = rootY;
            for (int x = 0; x < DISPLAY_NUMBER * 2; x++) {
                System.out.print(rootX);
                rootX = rootX.getE();
            }
            System.out.println(helpList.get(y));
            rootY = rootY.getS();
        }
    }

    public static void setLinkedObjects(List<ArrayList<Interact_Objects>> map) {
        int colSize = map.size();
        for (int y = 0; y < colSize; y++) {
            ArrayList<Interact_Objects> list = map.get(y);
            int rowSize = list.size();

            for (int x = 0; x < rowSize; x++) {
                Interact_Objects temp = list.get(x);
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
        helpList.add("\t\t");
        helpList.add("\t\t");
        helpList.add("\t\t");
        helpList.add("\t\t");
        helpList.add("\t\t");
        helpList.add("\t\t");
        helpList.add("\t\t");
        helpList.add("\t\t");

        helpList.add("\t\t     N\t\t\t\t Go Command Enter: N,S,E,W");
        helpList.add("\t\t    )|(\t\t\t\t Mine Command Enter: D");
        helpList.add("\t\t  )  |  (");
        helpList.add("\t\tW----O----E");
        helpList.add("\t\t  )  |  (");
        helpList.add("\t\t    )|(");
        helpList.add("\t\t     S");
        helpList.add("\t\t");
        helpList.add("\t\t");
        helpList.add("\t\t");
        helpList.add("\t\t");

    }

    public static void addActorToMap(Actor actor, List<ArrayList<Interact_Objects>> map) {
        int startx = actor.getX();
        int starty = actor.getY();
        actor.setOriginal_symbol(map.get(starty).get(startx));
        map.get(starty).set(startx, actor);

    }
}
