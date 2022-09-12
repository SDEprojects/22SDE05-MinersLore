package org.minerslore.GameEntities.mapitems;

import org.minerslore.GameEntities.actors.Actor;
import org.minerslore.Main;
import org.yaml.snakeyaml.Yaml;

import java.awt.*;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class CavePath extends Item implements Interactable {
    private static Map<String, Object> obj;
    private boolean isDug;
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RESET = "\u001B[0m";


    private static char SYMBOL = 0x00A4;
    private static final String MESSAGE = "Path walkable. This path can be mined, these tunnels are full of gold.";

    public CavePath(Point position, boolean isDug) {
        super(SYMBOL, position, true);
        this.isDug = isDug;
    }

    public void interact(Actor actor) {

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

    public static void setSYMBOL(char SYMBOL) {
        CavePath.SYMBOL = SYMBOL;
    }

    public void setDug() {
        this.isDug = true;
        this.setCurrent_symbol(' ');
    }

    ;

    public boolean isDug() {
        return isDug;
    }

    public final String inspect() {
        return MESSAGE;
    }


    @Override
    public String toString() {
        return ANSI_YELLOW + super.toString() + ANSI_RESET;
    }
}
