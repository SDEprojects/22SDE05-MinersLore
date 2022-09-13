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
    int moveCounter = 0;
    char[] directArrayX = {'D', 'A'};
    char[] directArrayY = {'S', 'W'};

    public char move(Miner miner, int colSize, int rowSize) {

        int xDist = Math.abs(miner.getX() - this.getX());
        int yDist = Math.abs(miner.getY() - this.getY());
        if (direction==1) {
            if(moveCounter<50){
                moveCounter++;
            }
            else{
                direction=0;
                moveCounter=0;
            }
        }

        if (xDist + yDist < 3) {
            if(direction ==0){
                this.encounter(miner);
            }
        }
      if (this.getX() < miner.getX()) {
            if (xDist < rowSize / 2 && ((Item) this.getE()).isPath() && !(this.getE() instanceof Door)) {
                return directArrayX[(0 + direction) % 2];
            } else if (Math.abs(miner.getX() - this.getX()) > rowSize / 2 && ((Item) this.getW()).isPath() && !(this.getW() instanceof Door)) {
                return directArrayX[(1 + direction) % 2];
            }
        } else if (this.getX() > miner.getX()) {
            if (xDist > rowSize / 2 && ((Item) this.getE()).isPath() && !(this.getE() instanceof Door)) {
                return directArrayX[(0 + direction) % 2];
            } else if (xDist < rowSize / 2 && ((Item) this.getE()).isPath() && !(this.getW() instanceof Door)) {
                return directArrayX[(1 + direction) % 2];
            }
        } else if (this.getY() < miner.getY()) {
            if (yDist < colSize / 2 && ((Item) this.getS()).isPath() && !(this.getS() instanceof Door)) {
                return directArrayY[(0 + direction) % 2];
            } else if (Math.abs(miner.getY() - this.getY()) > rowSize / 2 && ((Item) this.getN()).isPath() && !(this.getN() instanceof Door)) {
                return directArrayY[(1 + direction) % 2];
            }
        } else if (this.getY() > miner.getY()) {
            if (yDist > colSize / 2 && ((Item) this.getS()).isPath() && !(this.getS() instanceof Door)) {
                return directArrayY[(0 + direction) % 2];
            } else if (yDist < colSize / 2 && ((Item) this.getN()).isPath() && !(this.getN() instanceof Door)) {
                return directArrayY[(1 + direction) % 2];
            }
        }


        return ' ';
    }

    public void encounter(Miner miner) {
        System.out.println("MONSTER ATTACKS, AND STEALS YOURS GOLD!");
        miner.setGoldKG(0);
        direction = 1;
    }

    public void runMonster() {

    }

    @Override
    public String toString() {

        return TEXT_RED + super.toString() + ANSI_RESET;
    }
}
