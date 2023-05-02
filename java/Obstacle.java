import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Obstacle {
    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage image;
    private int speed;

    public Obstacle(int x, int y, int width, int height, BufferedImage image, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.image = image;
        this.speed = speed;
    }

    public void move() {
        x -= speed;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(image, x, y, width, height, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public static Obstacle createRandomObstacle(int panelWidth, int panelHeight, BufferedImage image, int speed) {
        Random rand = new Random();
        int obstacleWidth = image.getWidth();
        int obstacleHeight = image.getHeight();
        int obstacleX = panelWidth + rand.nextInt(panelWidth);
        int obstacleY = rand.nextInt(panelHeight - obstacleHeight);
        return new Obstacle(obstacleX, obstacleY, obstacleWidth, obstacleHeight, image, speed);
    }
}
