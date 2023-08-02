package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Speed extends SuperObject{
GamePanel gp;
    public OBJ_Speed(GamePanel gp) {
        this.gp = gp;
        name = "Speed";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/magical-blue-apple.png"));
            uTool.scaleImage(image, gp.tileSize, gp.tileSize);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}


