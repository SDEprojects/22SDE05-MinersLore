package org.minerslore;
import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        map.displayMap();

        Scanner reader = new Scanner(System.in);  // Reading from System.in

        String Command="";
        while(!Command.equals("quite")){

            System.out.println("Enter");
            String n = reader.next(); // Scans the next token of the input as an int.
            Command=n;
            int x, y;
            if(n.equalsIgnoreCase("N")){

                map.moveMiner(0,-1);

            }
            else if(n.equalsIgnoreCase("S")){

                    map.moveMiner(0,1);

                }

            else if(n.equalsIgnoreCase("W")){

                map.moveMiner(-1,0);

            }
            else if(n.equalsIgnoreCase("E")){

                map.moveMiner(1,0);

            }
            map.displayMap();

        }

//once finished
        reader.close();

        }
    }