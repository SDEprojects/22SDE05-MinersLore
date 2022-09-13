package org.minerslore.mapping;

import org.minerslore.GameEntities.GameEntity;
import org.minerslore.GameEntities.actors.Actor;
import org.minerslore.GameEntities.actors.Miner;
import org.minerslore.GameEntities.actors.Monster;
import org.minerslore.GameEntities.actors.OldMan;
import org.minerslore.GameEntities.mapitems.Item;
import org.minerslore.Main;
import org.minerslore.actionMap;
import org.yaml.snakeyaml.Yaml;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class GenerateGameMap {

    // GenerateGameMap generates GameEntity objects and links them together generating a 2D linked lists of GameEntity Objects.
    public GenerateGameMap() {

        generateHelpList();

        List<ArrayList<GameEntity>> map = fetchStarterMap();

        int minerStartX = 98;
        int minerStartY = 102;
        Miner miner = new Miner('M', new Point(minerStartX, minerStartY));
        addActorToMap(miner, map);

        int monsterStartX = 40;
        int monsterStartY = 102;
        Monster monster = new Monster('!', new Point(monsterStartX, monsterStartY));
        addActorToMap(monster, map);

        monsterStartX = 92;
        monsterStartY = 95;
        Monster monster2 = new Monster('!', new Point(monsterStartX, monsterStartY));
        addActorToMap(monster2, map);

        monsterStartX = 1;
        monsterStartY = 2;
        Monster monster3 = new Monster('!', new Point(monsterStartX, monsterStartY));
        addActorToMap(monster3, map);

        monsterStartX = 2;
        monsterStartY = 90;
        Monster monster4 = new Monster('!', new Point(monsterStartX, monsterStartY));
        addActorToMap(monster4, map);

        monsterStartX = 54;
        monsterStartY = 2;
        Monster monster5 = new Monster('!', new Point(monsterStartX, monsterStartY));
        addActorToMap(monster5, map);

        monsterStartX = 98;
        monsterStartY = 2;
        Monster monster6 = new Monster('!', new Point(monsterStartX, monsterStartY));
        addActorToMap(monster6, map);

        int oldManStartX = 97;
        int oldManStartY = 112;
        addActorToMap(new OldMan('O', new Point(oldManStartX, oldManStartY)), map);

        HashMap<String, Integer> mapSize = setLinkedObjectsReturnSize(map);

        // Sets all variables for actionMap, after GenerateGameMap sets values for actionMap fields, GenerateGameMap is no longer called upon.
        actionMap.setHelpList(generateHelpList());
        actionMap.setMiner(miner);
        actionMap.setMonster(monster);
        actionMap.addMonsterToList(monster);
        actionMap.addMonsterToList(monster2);
        actionMap.addMonsterToList(monster3);
        actionMap.addMonsterToList(monster4);
        actionMap.addMonsterToList(monster5);
        actionMap.addMonsterToList(monster6);
        actionMap.setColSize(mapSize.get("colSize"));
        actionMap.setRowSize(mapSize.get("rowSize"));
        actionMap.setMinersEquipment(generateEquipmentList());
    }

    public final static List<ArrayList<GameEntity>> fetchStarterMap() {
        List<ArrayList<GameEntity>> map = new ArrayList<>();
        try {
            String row;
            int y = 0;
            ClassLoader cl = Main.class.getClassLoader();
            InputStream input = cl.getResourceAsStream("Map.yaml");

            Yaml yaml = new Yaml();

            Map<String, Object> obj = yaml.load(input);
            BufferedReader in = new BufferedReader(new StringReader(obj.get("Map1").toString()));

            while ((row = in.readLine()) != null) {

                ArrayList<GameEntity> mapObjectList = new ArrayList<>();
                List<Character> charList = row.chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());

                for (int x = 0; x < charList.size(); x++) {
                    MapDictionary.addToMap(mapObjectList, new Point(x, y), charList.get(x));
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

    public final static HashMap<String, Integer> setLinkedObjectsReturnSize(List<ArrayList<GameEntity>> map) {

        int colSize = map.size();
        int rowSize;
        for (int y = 0; y < colSize; y++) {
            ArrayList<GameEntity> list = map.get(y);
            rowSize = list.size();

            for (int x = 0; x < rowSize; x++) {
                GameEntity temp = list.get(x);
                temp.setN(map.get((y - 1 + colSize) % colSize).get(x));
                temp.setS(map.get((y + 1 + colSize) % colSize).get(x));
                temp.setE(map.get(y).get((x + 1 + rowSize) % rowSize));
                temp.setW(map.get(y).get((x - 1 + rowSize) % rowSize));
            }
        }
        return new HashMap<String, Integer>(Map.of("rowSize", map.size(), "colSize", map.get(0).size()));
    }

    public final static List<String> generateHelpList() {
        ClassLoader cld = Main.class.getClassLoader();
        InputStream streamMapYaml = cld.getResourceAsStream("helpBar.yaml");

        Yaml yaml = new Yaml();

        Map<String, Object> tempHelp = yaml.load(streamMapYaml);
        return ((ArrayList<String>) tempHelp.get("Help")).stream()
                .map(x -> x.replace('5', (char) 0x00D1))
                .map(x -> x.replace('.', (char) ' '))
                .collect(Collectors.toList());
    }

    public final static Map<String, Object> generateEquipmentList() {
        ClassLoader cld = Main.class.getClassLoader();
        InputStream streamMapYaml = cld.getResourceAsStream("helpBar.yaml");

        Yaml yaml = new Yaml();

        Map<String, Object> tempHelp = yaml.load(streamMapYaml);

        return (Map<String, Object>) tempHelp.get("Inventory");

    }

    public final static void addActorToMap(Actor actor, List<ArrayList<GameEntity>> map) {
        int startx = actor.getX();
        int starty = actor.getY();
        actor.setOnBlock((Item) map.get(starty).get(startx));
        map.get(starty).set(startx, actor);
    }
}
