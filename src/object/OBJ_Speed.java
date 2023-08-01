package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Speed extends SuperObject{

    public OBJ_Speed() {

        name = "Speed";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/magical-blue-apple.png"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}


