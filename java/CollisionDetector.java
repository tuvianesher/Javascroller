import java.awt.Rectangle;

public class CollisionDetector {
    
    public static boolean detectCollision(Player player, Obstacle obstacle) {
        Rectangle playerBounds = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        Rectangle obstacleBounds = new Rectangle(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
        return playerBounds.intersects(obstacleBounds);
    }
    
}
