package org.minerslore.mapitems;

import org.minerslore.Actors.Actor;
import org.minerslore.Main;
import org.yaml.snakeyaml.Yaml;

import java.awt.*;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class CavePath extends Item {
    static Map<String, Object> obj;

    private int gold;
    private boolean isDug;
    private static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";

    private static final char SYMBOL = '.';
    private static final String MESSAGE = "Path walkable. This path can be mined.";

    public CavePath(Point position, boolean isDug) {
        super(SYMBOL, position, true);
        this.isDug = isDug;
    }

    public static void interact(Actor actor) {

        ClassLoader cl = Main.class.getClassLoader();
        java.io.InputStream input = cl.getResourceAsStream("Rand.yaml");
        Yaml yaml = new Yaml();
        obj = yaml.load(input);

        Item block = (Item) actor.getOn_Block();
        CavePath tile = (CavePath) block;
        if (tile.isDug() == false) {
            tile.setDug();
            int randomGoldKG = 0;
            double probability = Math.random();
            if (probability <= .25) {
                randomGoldKG = ThreadLocalRandom.current().nextInt(1, 11);
                actor.setGoldKG(randomGoldKG);
                System.out.println("Congrats, you found " + randomGoldKG + "KG of gold!");
                if (actor.getGoldKG() > randomGoldKG) {
                    System.out.println("So far, you have have collected " + actor.getGoldKG() + "KG!");
                }
            } else {
                System.out.println(obj.get(5));
            }
        } else if (tile.isDug() == true) {
            System.out.println(obj.get(6));
        }
    }

    public void setDug(){
        this.isDug = true;
    };

    public boolean isDug(){
        return isDug;
    }

    @Override
    public String toString() {
        if (isDug == true) {
            return ANSI_BLACK + super.toString() + ANSI_RESET;
        } else {
            return ANSI_YELLOW + super.toString() + ANSI_RESET;
        }
    }
}
