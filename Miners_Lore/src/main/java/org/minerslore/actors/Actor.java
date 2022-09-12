package org.minerslore.actors;

import org.minerslore.GameEntity;
import org.minerslore.mapitems.Item;

import java.awt.*;
import java.io.IOException;

public class Actor extends GameEntity  {

    private Item on_Block;
    private int goldKG;

    public Actor(char symbol, Point location) {
        super(symbol, location);
    }

    public GameEntity getOn_Block() {
        return on_Block;
    }

    public void setOriginal_symbol(Item original_symbol) {
        this.on_Block = original_symbol;
    }

    public void setGoldKG(int kg) {
        this.goldKG = this.goldKG + kg;
    }

    public void moveActor(GameEntity nextBlock) throws IOException {
        if (nextBlock instanceof Item && ((Item) nextBlock).isPath()) {
            // Put original On-Block in actor's place
            GameEntity prevBlock = this.on_Block;
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

            this.on_Block = (Item) nextBlock;

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
        } else if (nextBlock instanceof Actor) {
            ((Actor) nextBlock).encounter();

        }

    }

    public void encounter() throws IOException {
        System.out.println("Actor");

    }

    public int getGoldKG() {
        return goldKG;
    }

//    public void setGoldKG(int kg) throws IOException {
//        this.goldKG = this.goldKG + kg;
//        String yamlPath = "Miners_Lore/src/main/resources/help.yaml";
//        Map<String, Object> yaml = new Yaml().load(new FileReader(yamlPath));
//        yaml.put("Gold", this.goldKG);
//        String yamlModifiedPath = "Miners_Lore/src/main/resources/help.yaml";
//        DumperOptions options = new DumperOptions();
//        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
//        String output = new Yaml(options).dump(yaml);
//        try (FileWriter fw = new
//                FileWriter(yamlModifiedPath)) {
//            fw.write(output);
//        }
//    }
}
