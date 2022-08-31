package org.minerslore;

import org.minerslore.Actors.Actor;
import org.minerslore.Actors.Miner;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MapCopy {
    private static List<ArrayList<Character>> map = new ArrayList<>();

    private static List<ArrayList<Character>> overLay = new ArrayList<>();

    private static ArrayList<Actor> actors = new ArrayList<Actor>();

    public MapCopy() {

        map=fetchStarterMap();
        for(int i =0; i<map.size();i++){
            ArrayList<Character> charTempList = new ArrayList<Character>();
            Miner miner = new Miner();
            miner.move(4, 13);
            actors.add(miner);
            for(int k=0 ; k < map.get(i).size();k++){
                for (Actor act: actors){
                    if(act.Position.equals(new Point(i,k))){
                        charTempList.add(act.symbol);
                        break;
                    }
                    else{
                        charTempList.add('.');
                        break;
                    }
                }
            }
            overLay.add(charTempList);
        }
        updateOverLay();



    }

    public static List<ArrayList<Character>>  fetchStarterMap() {

        List<ArrayList<Character>> map_Original = new ArrayList<>();


        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(Objects.requireNonNull(Main.class.getClassLoader().getResourceAsStream("Map.txt")),
                            StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                List<Character> list = (ArrayList<Character>) line.chars().mapToObj((i) -> Character.valueOf((char) i)).collect(Collectors.toList());
                map_Original.add((ArrayList<Character>) list);

            }
            in.close();
        } catch (IOException e) {
            throw new RuntimeException("Caught exception reading resource " + "Maps", e);
        }


        return map_Original;
    }

    public static void displayMap(){

        for (int i =0; i<map.size(); i++) {

            for (int k =0; k<map.get(i).size(); k++)  {
                if(overLay.get(i).get(k)!='.'){
                    System.out.print(overLay.get(i).get(k));
                }
                else{
                    System.out.print(map.get(i).get(k));
                }
            }
            System.out.println("");
        }


    }

    public static void addActor(Actor actor){
        actors.add(actor);

    }

    public static void updateMap(){

    }

    public static void updateOverLay(){
        for (ArrayList<Character> each : overLay) {

            for (Character ea: each) {

                System.out.print(ea);

            }
            System.out.println("");
        }

    }

    public static void moveMiner(int y,int x){

        Actor act= actors.get(0);
        int prev_x=act.Position.x;
        int prev_y=act.Position.y;
        act.resetNeighbors();
        act.Position.setLocation(prev_x+x,prev_y+y);
        overLay.get(prev_x).set(prev_y,'.');
        overLay.get(prev_x+x).set(prev_y+y,'M');

    }

}
