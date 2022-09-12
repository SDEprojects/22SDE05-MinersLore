package org.minerslore.GameEntities.actors;

import org.minerslore.GameEntities.mapitems.Interactable;
import org.minerslore.GameEntities.mapitems.Item;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Our Dictionary
public class ActionsDict {
    private static Object minerObj; // convert string classname to class
    private static final Scanner reader = new Scanner(System.in);


    private static Class<?>[] paramUserCommandTypes = {Actor.class};
    private static Map<Character, String> userCommands = new HashMap<>(
            Map.of('W', "goNorth",
                    'S', "goSouth",
                    'D', "goEast",
                    'A', "goWest",
                    'F', "actionDig",
                    'Q', "quitGame",
                    'I', "InspectPathInstructions",
                    '8', "inpectNorth",
                    '2', "inspectSouth",
                    '4', "inspectWest"
            )
    );

    static {
        userCommands.put('6', "inspectEast");
        userCommands.put('5', "inspectCurrent");
        userCommands.put('G', "GoInstructions");
        try {
            minerObj = Class.forName("org.minerslore.GameEntities.actors.ActionsDict").getDeclaredConstructor().newInstance();
        } catch (InstantiationException | ClassNotFoundException | NoSuchMethodException | RuntimeException |
                 InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }

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
        System.out.println("Miner is leaving town, with " + actor.getGoldKG() + " Gold.");
    }

    public static void actionDig(Actor actor) {

        Interactable block = (Item) actor.getOn_Block();
        block.interact(actor);
    }

    public static void InspectPathInstructions(Actor actor) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        System.out.println("Enter commands to Inpect \nNorth\t->\t8\nSouth\t->\t2\nWest\t->\t4\nEast\t->\t6\nCurrent\t->\t5");
        char inspectCommand = reader.next().toUpperCase().charAt(0);
        actorActions(actor, inspectCommand);
    }

    public static void GoInstructions(Actor actor) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        System.out.println("Enter command to Go \nNorth\t->\tE\nSouth\t->\tS\nWest\t->\tA\nEast\t->\tD\nDig\t->\t\tF");
        char inspectCommand = reader.next().toUpperCase().charAt(0);
        actorActions(actor, inspectCommand);
    }


    public static void inpectNorth(Actor actor) {
        if (actor.getN() instanceof Interactable) {
            System.out.println(((Interactable) actor.getN()).inspect());
        }
    }

    public static void inspectSouth(Actor actor) {
        if (actor.getS() instanceof Interactable) {
            System.out.println(((Interactable) actor.getS()).inspect());
        }
    }

    public static void inspectEast(Actor actor) {
        if (actor.getE() instanceof Interactable) {
            System.out.println(((Interactable) actor.getE()).inspect());
        }
    }

    public static void inspectWest(Actor actor) throws IOException {
        if (actor.getW() instanceof Interactable) {
            System.out.println(((Interactable) actor.getW()).inspect());
        }
    }

    public static void inspectCurrent(Actor actor) throws IOException {
        if (actor.getOn_Block() instanceof Interactable) {
            System.out.println(((Interactable) actor.getOn_Block()).inspect());
        }
    }


    public static void actorActions(Actor actor, char ch) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        if (userCommands.containsKey(ch)) {
            minerObj.getClass().getMethod(userCommands.get(ch), paramUserCommandTypes).invoke(userCommands.get(ch), actor);
        } else if (actor instanceof Miner) {
            System.out.println(" Miner is confused. \nPlease choose N, S, E, W or G.\nTo inspect the area use the command -> I for instructions.");
        }
    }
}