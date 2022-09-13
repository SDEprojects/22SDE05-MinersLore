package org.minerslore;

import org.minerslore.GameEntities.GameEntity;
import org.minerslore.GameEntities.actors.Miner;
import org.minerslore.GameEntities.actors.Monster;
import org.minerslore.mapping.GenerateGameMap;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.minerslore.GameEntities.actors.ActionsDict.actorActions;

public class actionMap {

    private static final int DISPLAY_NUMBER = 16;
    private static List<String> helpList;
    private static Miner miner;
    private static Monster monster;
    private static int colSize;
    private static int rowSize;
    private static Map<String, Object> minersEquipment;
    private static final Scanner reader = new Scanner(System.in);
    private static boolean continueMonster = true;
    static boolean displayMethodInUse = false;
    static ExecutorService executor = Executors.newFixedThreadPool(2);

    public static void setMapVar() {
        new GenerateGameMap();

        Callable<Void> callable1 = new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                minerRun();
                return null;
            }
        };
        Callable<Void> callable2 = new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                monsterRun();
                return null;
            }
        };
        List<Callable<Void>> taskList = new ArrayList<Callable<Void>>();
        taskList.add(callable1);
        taskList.add(callable2);

        try {
            //start the threads and wait for them to finish
            executor.invokeAll(taskList);
        } catch (InterruptedException ie) {

        }

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

    public static final void setMinersEquipment(Map<String, Object> minersEquip) {
        minersEquipment = minersEquip;
    }

    public static final void displayMap() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        if (!displayMethodInUse) {
            displayMethodInUse = true;
            List tempEquipKeys = List.of(minersEquipment.keySet().toArray());
            List tempEquipValues = List.of(minersEquipment.values().toArray());

            StringBuilder sb = new StringBuilder();

            GameEntity rootY = miner.getS();
            for (int i = 0; i < DISPLAY_NUMBER / 2; i++) {
                rootY = rootY.getN();
                rootY = rootY.getW().getW();
            }


            for (int y = 0; y < DISPLAY_NUMBER; y++) {

                GameEntity rootX = rootY;
                for (int x = 0; x < DISPLAY_NUMBER * 2; x++) {

                    sb.append(rootX);
                    rootX = rootX.getE();
                }
                if (y < helpList.size()) {
                    sb.append(helpList.get(y));

                }

                else if (y == helpList.size()) {
            } else if (y > helpList.size() + 2 && y < helpList.size() + tempEquipKeys.size() + 4) {
                    sb.append("\t\t" + tempEquipKeys.get(y - helpList.size() - 3) + "\t" + tempEquipValues.get(y - helpList.size() - 3));
            } else {
                System.out.println(sb);
            }
                rootY = rootY.getS();
                sb.append("\n");


            }

            System.out.println(sb);
            displayMethodInUse = false;

        }
    }
//    public static final void displayMaped() {
//
//        int minerX = miner.getX();
//        int minerY = miner.getY();
//        GameEntity rootY = miner.getByIndex(((minerX + rowSize - DISPLAY_NUMBER) % rowSize), ((minerY + colSize - DISPLAY_NUMBER / 2) % colSize));
//        System.out.println(minerX);
//        System.out.println(minerY);
//        List tempEquipKeys = List.of(minersEquipment.keySet().toArray());
//        List tempEquipValues = List.of(minersEquipment.values().toArray());
//
//        for (int y = 0; y < DISPLAY_NUMBER; y++) {
//            StringBuilder sb = new StringBuilder();
//            GameEntity rootX = rootY;
//            for (int x = 0; x < DISPLAY_NUMBER * 2; x++) {
//                System.out.print(rootX);
//                sb.append(rootX);
//                rootX = rootX.getE();
//            }
//            System.out.println("");
////            if (y < helpList.size()) {
////                System.out.println(sb.toString() + "\t\t" + helpList.get(y));
////            } else if (y == helpList.size()) {
////                System.out.println(sb.toString() + "\t\tGold: " + "gold" + "KG");
////            } else if (y > helpList.size() + 2 && y < helpList.size() + tempEquipKeys.size() + 4) {
////                System.out.println(sb.toString() + "\t\t" + tempEquipKeys.get(y - helpList.size() - 3) + "\t" + tempEquipValues.get(y - helpList.size() - 3));
////            } else {
////                System.out.println(sb);
////            }
//            rootY = rootY.getS();
//        }
//    }

    public static final void handleCommand(char userCommand) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
//        ActionsDict.actorActions(monster, monster.move(miner, colSize, rowSize));
        actorActions(miner, userCommand);

    }

    public static void minerRun() throws InterruptedException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        char command = 0;

        while (command != 'Q') {
            if(!displayMethodInUse){
                displayMap();
            }


            System.out.println("Enter");
            command = reader.next().toUpperCase().charAt(0);

            // Clear Screen
            clearConsole();

            actorActions(miner, command);

        }
        stopMonster();
        shutDown(executor);

    }

    public static void monsterRun() throws InterruptedException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        while (controlMonster()) {
            int xDist = Math.abs(miner.getX() - monster.getX());
            int yDist = Math.abs(miner.getY() - monster.getY());
            Thread.sleep(2L * 1000L);
            actorActions(monster, monster.move(miner, colSize, rowSize));
            if (xDist + yDist < 10) {
                if(!displayMethodInUse) {
                    clearConsole();
                    displayMap();
                    System.out.println("Enter");
                }
            }
        }
    }

    private final static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
        }
    }

    private static boolean controlMonster() {

        return continueMonster;
    }
    private static void stopMonster(){
        continueMonster=false;
    }
    private static void shutDown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

    }
}





