package main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {

    GamePanel gp;
    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setObject() {
        gp.obj[0] = new OBJ_Key();
        gp.obj[0].worldX = 27 * gp.tileSize;
        gp.obj[0].worldY = 20 * gp.tileSize;www

        gp.obj[1] = new OBJ_Key();
        gp.obj[1].worldX = 27 * gp.tileSize;
        gp.obj[1].worldY = 42 * gp.tileSize;

        gp.obj[2] = new OBJ_Door();
        gp.obj[2].worldX = 32 * gp.tileSize;
        gp.obj[2].worldY = 35 * gp.tileSize;

        gp.obj[3] = new OBJ_Door();
        gp.obj[3].worldX = 32 * gp.tileSize;
        gp.obj[3].worldY = 40 * gp.tileSize;

        gp.obj[4] = new OBJ_Chest();
        gp.obj[4].worldX = 36 * gp.tileSize;
        gp.obj[4].worldY = 42 * gp.tileSize;
    }
}
