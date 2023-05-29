import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImageLoader {
    private Map<String, BufferedImage> imageMap;

    public ImageLoader() {
        imageMap = new HashMap<>();
        loadImages();
    }

    private void loadImages() {
        try {
            // Load player.png and obstacle.png from resources
            BufferedImage playerImage = ImageIO.read(getClass().getResourceAsStream("player.png"));
            BufferedImage obstacleImage = ImageIO.read(getClass().getResourceAsStream("obstacle.png"));

            // Add the loaded images to the image map
            imageMap.put("player.png", playerImage);
            imageMap.put("obstacle.png", obstacleImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage(String imageName) {
        return imageMap.get(imageName);
    }
}
