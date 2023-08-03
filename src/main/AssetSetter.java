package main;

import entity.NPC_OldMan;
import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;
import object.OBJ_Speed;

public class AssetSetter {

    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
//        gp.obj[0] = new OBJ_Key(gp);
//        gp.obj[0].worldX = 28 * gp.tileSize;
//        gp.obj[0].worldY = 21 * gp.tileSize;
//
//        gp.obj[1] = new OBJ_Key(gp);
//        gp.obj[1].worldX = 23 * gp.tileSize;
//        gp.obj[1].worldY = 40 * gp.tileSize;
//
//        gp.obj[2] = new OBJ_Door(gp);
//        gp.obj[2].worldX = 31 * gp.tileSize;
//        gp.obj[2].worldY = 21 * gp.tileSize;
//
//        gp.obj[3] = new OBJ_Door(gp);
//        gp.obj[3].worldX = 29 * gp.tileSize;
//        gp.obj[3].worldY = 40 * gp.tileSize;
//
//        gp.obj[4] = new OBJ_Chest(gp);
//        gp.obj[4].worldX = 36 * gp.tileSize;
//        gp.obj[4].worldY = 42 * gp.tileSize;
//
//        gp.obj[5] = new OBJ_Speed(gp);
//        gp.obj[5].worldX = 23 * gp.tileSize;
//        gp.obj[5].worldY = 16 * gp.tileSize;
    }
    public  void setNPC(){
        gp.npc[0] = new NPC_OldMan(gp);
        gp.npc[0].worldX = gp.tileSize*21;
        gp.npc[0].worldY = gp.tileSize*21;
    }
}
