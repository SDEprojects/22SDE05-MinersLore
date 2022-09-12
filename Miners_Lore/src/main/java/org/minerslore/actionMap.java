package org.minerslore;

import org.minerslore.GameEntities.GameEntity;
import org.minerslore.GameEntities.actors.ActionsDict;
import org.minerslore.GameEntities.actors.Miner;
import org.minerslore.GameEntities.actors.Monster;
import org.minerslore.mapping.GenerateGameMap;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class actionMap {

    private static final int DISPLAY_NUMBER = 16;
    private static List<String> helpList;
    private static Miner miner;
    private static Monster monster;
    private static int colSize;
    private static int rowSize;
    private static Map<String, Object> minersEquipment;

    static {
        GenerateGameMap map = new GenerateGameMap();
    }

    public static final void setHelpList(List<String> helpList) {
        actionMap.helpList = helpList;
    }

    public static final void setMonster(Monster monster) {
        actionMap.monster = monster;
    }

    public static final void setMiner(Miner miner) {
        actionMap.miner = miner;
    }

    public static final void setColSize(int colSize) {
        actionMap.colSize = colSize;
    }

    public static final void setRowSize(int rowSize) {
        actionMap.rowSize = rowSize;
    }

    public static final void setMinersEquipment(Map<String, Object> minersEquipment) {
        actionMap.minersEquipment = minersEquipment;
    }

    public static final void displayMap() {
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
                System.out.println(sb.toString() + "\t\t" + helpList.get(y));
            } else if (y == helpList.size()) {
                System.out.println(sb.toString() + "\t\tGold: " + "gold" + "KG");
            } else if (y > helpList.size() + 2 && y < helpList.size() + tempEquipKeys.size() + 4) {
                System.out.println(sb.toString() + "\t\t" + tempEquipKeys.get(y - helpList.size() - 3) + "\t" + tempEquipValues.get(y - helpList.size() - 3));
            } else {
                System.out.println(sb);
            }
            rootY = rootY.getS();
        }
    }

    public static final void handleCommand(char userCommand) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        ActionsDict.actorActions(monster, monster.move(miner, colSize, rowSize));
        ActionsDict.actorActions(miner, userCommand);

    }
}
