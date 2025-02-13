package entity;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
//    public int hasKey = 0;


    public Player(GamePanel gp, KeyHandler keyH){
        super(gp);
        this.keyH = keyH;


        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width =32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage() {

        up1 = setup("/player/Mage-M-up");
        up2 = setup("/player/Mage-M-up1");
        down1 = setup("/player/Mage-M-down");
        down2 = setup("/player/Mage-M-down-1");
        left1 = setup("/player/Mage-M-left");
        left2 = setup("/player/Mage-M-left-1");
        right1 = setup("/player/Mage-M-01-right");
        right2 = setup("/player/Mage-M-right1");

    }

//    public BufferedImage setup(String imageName) {
//
//        UtilityTool uTool = new UtilityTool();
//        BufferedImage image = null;
//
//        try{
//            image = ImageIO.read(getClass().getResourceAsStream("/player/" + imageName +".png"));
//            image = uTool.scaleImage(image, gp.tileSize, gp.tileSize);
//
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//
//        return image;
//    }
    public void update() {

        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {

            if (keyH.upPressed == true) {
                direction = "up";
            } else if (keyH.downPressed == true) {
                direction = "down";
            } else if (keyH.leftPressed == true) {
                direction = "left";
            } else if (keyH.rightPressed) {
                direction = "right";
            }

            //   CHECK TILE COLLISION
            collisionOn = false;
            gp.cCheck.checkTile(this);

            //Check OBJECT COLLISION
            int objIndex = gp.cCheck.checkObject(this, true);
            pickUpObject(objIndex);

            //Check NPC COLLISION
            int npcIndex = gp.cCheck.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            // IF COLLISION IS FALSE, PLAYER CAN MOVE
            if(collisionOn == false) {

                switch(direction) {
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }
    }

    public void pickUpObject(int i) {

        if(i != 999){
//            gp.obj[i] = null;
//            String objectName = gp.obj[i].name;
//
//            switch(objectName) {
//                case "Key":
//                    gp.playSE(1);
//                    hasKey++;
//                    gp.obj[i] = null;
//                    gp.ui.showMessage("Obtained Key!");
//                    break;
//                case "Door":
//                    gp.playSE(3);
//                    if(hasKey > 0) {
//                        gp.obj[i] = null;
//                        hasKey--;
//                        gp.ui.showMessage(("You opened the Door!"));
//                    } else {
//                        gp.ui.showMessage("You need a key!");
//                    }
//                    break;
//                case "Speed":
//                    gp.playSE(2);
//                    speed += 2;
//                    gp.obj[i] = null;
//                    gp.ui.showMessage("Speed Increased!");
//                    break;
//                case "Chest":
//                    gp.ui.gameFinished = true;
//                    gp.stopMusic();
//                    gp.playSE(4);
//                    break;
//            }
//
        }
    }
    public void interactNPC(int i) {
        if(i != 999) {

            gp.gameState = gp.dialogueState;
            gp.npc[i].speak();

        }
    }
    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY,null);
    }
}
