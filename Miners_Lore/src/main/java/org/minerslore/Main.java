package org.minerslore;

import org.minerslore.stories.Story;

import java.io.IOException;
import java.util.Scanner;
import java.lang.Thread;


public class Main  { ;

    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) throws Exception  {

        String splash = Story.splashMap.get("Splash1").toString();
        System.out.println(splash);

        actionMap.setMapVar();



    }



}