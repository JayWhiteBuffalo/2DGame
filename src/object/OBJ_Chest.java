package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Chest extends SuperObject{
    public OBJ_Chest() {

        name = "Chest";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/soda-pop-machine.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
