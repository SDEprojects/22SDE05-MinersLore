package org.minerslore.Actors;
import org.minerslore.Interact_Objects;
import org.minerslore.Items.Item;

import javax.swing.text.Position;
import java.awt.Point;
public class Actor extends Interact_Objects {

    private Interact_Objects on_Block;
    private int goldKG;

    public Actor(char symbol, Point location) {
        super(symbol, location);
    }

    public Interact_Objects getOn_Block() {
        return on_Block;
    }

    public void setOriginal_symbol(Interact_Objects original_symbol) {
        this.on_Block = original_symbol;
    }


    public void moveActor(Interact_Objects nextBlock){
        if(nextBlock instanceof Item && ((Item) nextBlock).isPath()) {
            // Put original On-Block in actor's place
            Interact_Objects prevBlock = this.on_Block;
//            prevBlock.setCurrent_symbol('!');

            // Replace Current block
            prevBlock.setE(this.getE());
            prevBlock.setW(this.getW());
            prevBlock.setS(this.getS());
            prevBlock.setN(this.getN());
            this.getN().setS(prevBlock);
            this.getS().setN(prevBlock);
            this.getE().setW(prevBlock);
            this.getW().setE(prevBlock);

            // Store next On-Block

            this.on_Block = nextBlock;

            // Set links from miner to N S E W blocks
            this.setN(nextBlock.getN());
            this.setS(nextBlock.getS());
            this.setW(nextBlock.getW());
            this.setE(nextBlock.getE());

            // Set links pointing to new miner Position
            this.getN().setS(this);
            this.getS().setN(this);
            this.getE().setW(this);
            this.getW().setE(this);
            this.setPosition(nextBlock.getPosition());
        } else if (nextBlock instanceof OldMan) {
            System.out.println("Something");
            ((OldMan) nextBlock).encounter();

        }


    }
    public void encounter(){
        System.out.println("Actor");

    }
}
