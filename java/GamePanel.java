import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.awt.Dimension;

public class GamePanel extends JPanel {
    public static final long NANOSECONDS_PER_UPDATE = 1000000000 / 60; // 60 FPS
    public int width;
    public int height;
    private Player player;
    private Obstacle obstacle;
    private ImageLoader imageLoader;

    public GamePanel(int width, int height, Player player, Obstacle obstacle, ImageLoader imageLoader) {
        this.width = width;
        this.height = height;
        this.player = player;
        this.obstacle = obstacle;
        this.imageLoader = imageLoader;
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set background color
        setBackground(Color.WHITE);

        // Clear the panel
        g2d.clearRect(0, 0, getWidth(), getHeight());

        // Draw player image
        BufferedImage playerImage = imageLoader.getImage("player.png");
        g2d.drawImage(playerImage, player.getX(), player.getY(), null);

        // Draw obstacle image
        BufferedImage obstacleImage = imageLoader.getImage("obstacle.png");
        g2d.drawImage(obstacleImage, obstacle.getX(), obstacle.getY(), null);
    }

    public void clear() {
        // Clear the panel if needed
    }

    public void drawImage(Image image, int x, int y) {
        // Draw an image at the specified location if needed
    }

    public void drawText(String string, int x, int y) {
        // Draw text at the specified location if needed
    }
}
