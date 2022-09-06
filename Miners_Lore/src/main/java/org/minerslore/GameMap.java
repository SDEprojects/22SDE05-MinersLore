package org.minerslore;

import org.minerslore.Actors.Actor;
import org.minerslore.Actors.Miner;
import org.minerslore.Actors.OldMan;
import org.minerslore.Items.*;
import org.yaml.snakeyaml.Yaml;
import jline.console.ConsoleReader;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameMap {
    private static List<ArrayList<Interact_Objects>> map = new ArrayList<>();

    static Miner miner;
    static int colSize;
    static int rowSize;


    public GameMap() {
        int minerStartX=98;
        int minerStartY=102;

        int oldManStartX=96;
        int oldManStartY=105;


        fetchStarterMap();
        colSize=map.size();
        rowSize=map.get(0).size();
        miner = new Miner('M',new Point(minerStartX,minerStartY));
        miner.setOriginal_symbol(map.get(minerStartY).get(minerStartX));
        map.get(miner.getY()).set(miner.getX(),miner);

        OldMan oldman = new OldMan(new Point(oldManStartX,oldManStartY));
        oldman.setOriginal_symbol(map.get(oldManStartY).get(oldManStartX));
        map.get(oldManStartY).set(oldManStartX,oldman);
        setLinkedObjects();
        colSize=map.size();
        rowSize=map.get(0).size();
    }
    public static void  fetchStarterMap() {
        try {

            String row;
            int y=0;
            ClassLoader cl = Main.class.getClassLoader();
            java.io.InputStream input = cl.getResourceAsStream("Map.yaml");

            Yaml yaml = new Yaml();

            java.util.Map<String, Object> obj = yaml.load(input);
            BufferedReader in = new BufferedReader(new StringReader( obj.get("Map1").toString()));

            while ((row = in.readLine()) != null) {

                ArrayList<Interact_Objects> mapObjectList = new ArrayList<>();
                List<Character> charList = row.chars().mapToObj((i) -> Character.valueOf((char)i)).collect(Collectors.toList());

                for (int x = 0; x < charList.size(); x++) {
                    if (charList.get(x) == '=') {
                        mapObjectList.add(new Wall(new Point(x, y)));
                    } else if (charList.get(x) == ' ') {
                        mapObjectList.add(new Path(new Point(x, y)));
                    } else if (charList.get(x) == '.') {
                        mapObjectList.add(new CavePath(new Point(x, y)));
                    }else if (charList.get(x) == '^') {
                        mapObjectList.add(new Door(new Point(x,y)));
                    } else {
                        mapObjectList.add(new Item(charList.get(x), new Point (x, y),false));
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
        int minerX=miner.getX();
        int minerY= miner.getY();

        Interact_Objects rootY =miner.getByIndex(((minerX+rowSize-16)%rowSize), ((minerY+colSize-8)%colSize));

        for(int y =0; y<16; y++){

            Interact_Objects rootX =rootY;
            for(int x = 0; x<32; x++){
                System.out.print(rootX);
                rootX =rootX.getE();
            }
                System.out.println();
            rootY=rootY.getS();
        }
    }
    public static void setLinkedObjects(){
        int colSize=map.size();
        for(int y =0; y< colSize; y++){
            ArrayList<Interact_Objects> list=map.get(y);
            int rowSize=list.size();

            for (int x =0; x<rowSize; x++){

                Interact_Objects temp=list.get(x);
                temp.setN(map.get((y-1+colSize)%colSize).get(x));
                temp.setS(map.get((y+1+colSize)%colSize).get(x));
                temp.setE(map.get(y).get((x+1+rowSize)%rowSize));
                temp.setW(map.get(y).get((x-1+rowSize)%rowSize));

            }
        }
    }

    public static void moveMiner(String Direction){

        if(Direction.equalsIgnoreCase("N")){
                miner.moveActor(miner.getN());
            }

            else if(Direction.equalsIgnoreCase("S")){
            miner.moveActor(miner.getS());
        }
            else if(Direction.equalsIgnoreCase("W")){
            miner.moveActor(miner.getW());
        }
            else if(Direction.equalsIgnoreCase("E")){
            miner.moveActor(miner.getE());
        }
    }
}
