package org.minerslore.Actors;

import org.minerslore.Main;
import org.minerslore.Story;
import org.yaml.snakeyaml.Yaml;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class OldMan extends Actor {

    private static final char SYMBOL = 'O';
    private static final String MESSAGE = "Old man";
    Map<String, Object> Story;


    public OldMan(char symbol, Point location) {


        super(SYMBOL, location);
        ClassLoader cl = Main.class.getClassLoader();
        java.io.InputStream input = cl.getResourceAsStream("Story.yaml");


        Yaml yaml = new Yaml();

        Story = yaml.load(input);
//        System.out.println(Story.get("STORY"));
    }


    public static void showInventory() {

    }

    public static void showActions() {

    }

    public void encounter() throws IOException {
//        System.out.println(Story.get("STORY"));
        Story oldmanStory = new Story();
        oldmanStory.mainStory();

    }


}