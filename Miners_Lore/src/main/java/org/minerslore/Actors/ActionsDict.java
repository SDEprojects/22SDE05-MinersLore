package org.minerslore.Actors;

import org.minerslore.Main;
import org.minerslore.mapitems.*;
import org.minerslore.stories.PrintStoriesToConsole;
import org.yaml.snakeyaml.Yaml;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static org.minerslore.stories.PrintStoriesToConsole.parseYaml;

// Our Dictionary
public class ActionsDict {
    static Object minerObj; // convert string classname to class
    static Map<String, Object> obj;

    static {
        try {
            minerObj = Class.forName("org.minerslore.Actors.ActionsDict").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | RuntimeException |
                 InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    static Class<?>[] paramUserCommandTypes = {Actor.class};
    public static Map<Character, String> userCommands = new HashMap<>(
            Map.of('W', "goNorth",
                    'S', "goSouth",
                    'D', "goEast",
                    'A', "goWest",
                    'G', "actionDig",
                    'Q',"quitGame"
            )
    );

    public static void goNorth(Actor actor) throws IOException {
        actor.moveActor(actor.getN());
    }

    public static void goSouth(Actor actor) throws IOException {
        actor.moveActor(actor.getS());
    }

    public static void goEast(Actor actor) throws IOException {
        actor.moveActor(actor.getE());
    }

    public static void goWest(Actor actor) throws IOException {
        actor.moveActor(actor.getW());
    }
    public static void quitGame(Actor actor) throws IOException {
        System.out.println("Miner is leaving town, with "+actor.getGoldKG()+" Gold.");
    }

    public static void actionDig(Actor actor) {
        Item block = (Item) actor.getOn_Block();
        if (block instanceof CavePath && block.isPath()) {
            ((CavePath)block).interact(actor);
        } else if (block instanceof Jewel && block.isPath()) {
            ((Jewel)block).interact(actor);
        }
    }

    public static void actorActions(Actor actor, char ch) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, IOException {

        if (userCommands.containsKey(ch)) {
            System.out.println(ch);
            minerObj.getClass().getMethod(userCommands.get(ch), paramUserCommandTypes).invoke(userCommands.get(ch), actor);
        } else {
            obj = PrintStoriesToConsole.parseYaml();
            System.out.println(obj.get(1));
        }
    }
}