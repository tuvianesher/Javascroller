import java.awt.Image;

public class Player {
    private int x; // player's x position
    private int y; // player's y position
    private int width; // player's width
    private int height; // player's height
    private int speed; // player's movement speed
    private Image image; // player's image

    public Player(int x, int y, int width, int height, int speed, Image image) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.image = image;
    }

    // Getters and setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    // Update player's position based on keyboard input
    public void updatePosition(int deltaX, int deltaY) {
        x += deltaX * speed;
        y += deltaY * speed;
    }
}
