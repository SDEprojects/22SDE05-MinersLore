package org.minerslore.GameEntities.actors;

import org.minerslore.GameEntities.mapitems.Door;
import org.minerslore.GameEntities.mapitems.Item;

import java.awt.*;

public class Monster extends Actor {

    private static final char SYMBOL = 0x00A5;
    private static final String MESSAGE = "Gold stealing creature of lore.";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public Monster(char symbol, Point location) {
        super(SYMBOL, location);
    }

    int direction = 0;
    boolean followMiner=true;
    int moveCounter = 0;


    public char move(Miner miner, int colSize, int rowSize) {

        int xDist = Math.abs(miner.getX() - this.getX());
        int yDist = Math.abs(miner.getY() - this.getY());
        if (direction==1) {
            if(moveCounter<20){
                moveCounter++;
            } else{
                direction=0;
                moveCounter=0;
                followMiner=true;
            }
        }
        if (xDist + yDist < 2) {
            if (direction == 0) {
                this.encounter(miner);
            }
        } else if (this.getX() < miner.getX()&& ((Item) this.getE()).isPath() && !(this.getE() instanceof Door)) {
            return followMiner ? 'D':'A';
        }else if (this.getX() > miner.getX()&& ((Item) this.getW()).isPath() && !(this.getW() instanceof Door)) {
            return followMiner ? 'A':'D';
        }else if (this.getY() < miner.getY()&& ((Item) this.getN()).isPath() && !(this.getN() instanceof Door)) {
            return followMiner ? 'S':'W';
        }else if (this.getY() > miner.getY()&& ((Item) this.getS()).isPath() && !(this.getS() instanceof Door)) {
            return followMiner ? 'W':'S';
        }


        return ' ';
    }
    public void encounter(Miner miner) {
        System.out.println("MONSTER ATTACKS, AND STEALS YOURS GOLD!");
        miner.resetGoldKG();
        followMiner=false;
        direction = 1;
    }
    @Override
    public String toString() {

        return TEXT_RED + super.toString() + ANSI_RESET;
    }
}
