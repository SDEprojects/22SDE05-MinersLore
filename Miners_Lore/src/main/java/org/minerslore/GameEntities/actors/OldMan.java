package org.minerslore.GameEntities.actors;

import org.minerslore.Main;
import org.minerslore.stories.Story;
import org.yaml.snakeyaml.Yaml;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class OldMan extends Actor implements Encounterable {
    public static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final char SYMBOL = 0x00F6;
    private static final String MESSAGE = "Old man";
    private static Map<String, Object> Story;


    public OldMan(char symbol, Point location) {


        super(SYMBOL, location);
        ClassLoader cl = Main.class.getClassLoader();
        java.io.InputStream input = cl.getResourceAsStream("Story.yaml");


        Yaml yaml = new Yaml();

        Story = yaml.load(input);

    }


    public static void showInventory() {

    }

    public static void showActions() {

    }

    public void encounter(Actor actor) throws IOException {
        Story oldmanStory = new Story();
//        oldmanStory.mainStory();
    }

    @Override
    public String toString() {

        return ANSI_PURPLE + super.toString() + ANSI_RESET;
    }


}