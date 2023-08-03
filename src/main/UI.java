package main;

import object.OBJ_Key;

import java.awt.*;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    Font arial_80B;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("10.00");
    public UI(GamePanel gp) {
        this.gp = gp;

        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 50);
    }
    public void showMessage(String text){
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);

        //PLAY STATE
        if(gp.gameState == gp.playState) {
            //run playstate stuff
        }
        //PAUSE STATE
        if(gp.gameState == gp.pauseState){
            drawPauseScreen();
        }
        //DIALOGUE STATE
        if(gp.gameState == gp.dialogueState) {
            drawDialogueScreen();
        }

    }
    public void drawPauseScreen() {

        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;

        g2.drawString(text, x, y);
    }
    public void drawDialogueScreen() {

        //WINDOW
        int x = gp.tileSize*2;
        int y = gp.tileSize/2;
        int width = gp.screenWidth - (gp.tileSize*4);
        int height = gp.tileSize*4;

        drawDialogueWindow(x, y, width, height);

        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 24F));
        x+= gp.tileSize;
        y+= gp.tileSize;
        g2.drawString(currentDialogue, x, y);
    }
    public void drawDialogueWindow(int x, int y, int width, int height) {

        Color c = new Color(235,235,235, 210);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);

        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x,y, width, height, 25, 25);
    }
    public int getXforCenteredText(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }
}
