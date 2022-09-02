package org.minerslore;

import org.minerslore.Actors.Actor;
import org.minerslore.Actors.Miner;
import org.minerslore.Items.Item;
import org.minerslore.Items.Wall;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameMap {
    private static List<ArrayList<Interact_Objects>> map = new ArrayList<>();
    private static ArrayList<Actor> actors = new ArrayList<>();
    public GameMap() {

        fetchStarterMap();
        Miner miner = new Miner('M',new Point(20,20));
        actors.add(miner);

        map.get(miner.getY()).set(miner.getX(),miner);
    }
    public static void  fetchStarterMap() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("Map.txt")),
                            StandardCharsets.UTF_8));
            String row;
            int y=0;



            while ((row = in.readLine()) != null) {

                ArrayList<Interact_Objects> mapObjectList = new ArrayList<Interact_Objects>();
                List<Character> charList = row.chars().mapToObj((i) -> Character.valueOf((char)i)).collect(Collectors.toList());

                for (int x = 0; x < charList.size(); x++) {
                    if (charList.get(x) == '=') {
                        mapObjectList.add(new Wall(new Point(x, y)));
                    } else {
                        mapObjectList.add(new Item(charList.get(x), new Point (x, y)));
                    }
                }

                map.add(mapObjectList);
                y++;
            }
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("Caught exception reading resource " + "Maps", e);
        }
    }

    public static void displayMap() {
        int radius =12;
        Actor miner=actors.get(0);
        int actX=miner.getX();
        int actY=miner.getY();


        map.get(miner.getY()).set(miner.getX(),miner);
        for(int y =0; y<map.size(); y++){
            for(int x = 0; x<map.get(y).size(); x++){
                // ( x - Obj_X )^2+( y - Obj_Y ) ^ 2 < R^2
                if (Math.pow(( x-actX) * .4,2)+Math.pow( y-actY,2 ) <= Math.pow( radius,2 )){
                    System.out.print(map.get(y).get(x));
                }

                else {
                    System.out.print(" ");
                }

            }
//            row.forEach(item-> System.out.print(item.toString().replace(',',' ')));
            if(Math.pow(y-actY,2)<Math.pow(radius,2)){
                System.out.println();
            }


        }
    }

    public static void moveMiner(String Direction){

        if(Direction.equalsIgnoreCase("N")){

            (actors.get(0)).moveNorth();
            }
            else if(Direction.equalsIgnoreCase("S")){
            actors.get(0).moveSouth();
                }
            else if(Direction.equalsIgnoreCase("W")){
            actors.get(0).moveWest();
            }
            else if(Direction.equalsIgnoreCase("E")){
            actors.get(0).moveEast();
            }
    }
}
