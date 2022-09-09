package org.minerslore.Actors;

import org.minerslore.GameEntity;
import org.minerslore.mapitems.Item;

import java.awt.*;

public class Monster extends Actor {

    private static final char SYMBOL = 0x00A5;
    private static final String MESSAGE = "Gold stealing creature of lore.";
    public static final String TEXT_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public Monster(char symbol, Point location) {
        super(SYMBOL, location);
    }

    public void move() {

    }

    public GameEntity move(GameEntity nextMove, GameEntity pathBlock, GameEntity lastBlock) {
        System.out.println(this.getOn_Block());
        if(pathBlock instanceof Miner){
            return nextMove;
        }if(((Item)pathBlock.getE()).isPath() && !pathBlock.getE().equals(lastBlock)){
            return move(nextMove, pathBlock.getE(),lastBlock);
        }if(((Item)pathBlock.getW()).isPath() && !pathBlock.getW().equals(lastBlock)){
            return move(nextMove, pathBlock.getW(),lastBlock);
        }if(((Item)pathBlock.getS()).isPath() && !pathBlock.getS().equals(lastBlock)){
            return move(nextMove, pathBlock.getS(),lastBlock);
        }if(((Item)pathBlock.getN()).isPath() && !pathBlock.getN().equals(pathBlock)){
            return move(nextMove, pathBlock.getN(),pathBlock);
        }

        return pathBlock;
    }

    public void encounter() {

    }

    @Override
    public String toString() {
        return TEXT_RED  + super.toString() + ANSI_RESET;
    }
}
