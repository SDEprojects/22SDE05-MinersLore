package org.minerslore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Map {
    private static List<ArrayList<Character>> map = new ArrayList<>();
    private static ArrayList<Actor> actors = new ArrayList<Actor>();

    public Map() {
        map=fetchStarterMap();
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
        for (ArrayList<Character> each : map) {

            for (Character ea: each) {

                System.out.print(ea);

            }
            System.out.println("");
        }

    }

    public static void addActor(Actor actor){
        actors.add(actor);

    }

    public static void updateMap(){

    }

}
