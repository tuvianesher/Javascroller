import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {
    private BufferedImage playerImage;
    private BufferedImage obstacleImage;

    public ImageLoader() {
        try {
            playerImage = ImageIO.read(getClass().getResourceAsStream("player.png"));
            obstacleImage = ImageIO.read(getClass().getResourceAsStream("obstacle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getPlayerImage() {
        return playerImage;
    }

    public BufferedImage getObstacleImage() {
        return obstacleImage;
    }
}
