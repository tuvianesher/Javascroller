import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.awt.Dimension;

public class GamePanel extends JPanel {
    private int width;
    private int height;
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
}
