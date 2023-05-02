import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    private boolean isMovingUp;
    private boolean isMovingDown;
    private boolean isMovingLeft;
    private boolean isMovingRight;

    public KeyboardListener() {
        isMovingUp = false;
        isMovingDown = false;
        isMovingLeft = false;
        isMovingRight = false;
    }

    public boolean isMovingUp() {
        return isMovingUp;
    }

    public boolean isMovingDown() {
        return isMovingDown;
    }

    public boolean isMovingLeft() {
        return isMovingLeft;
    }

    public boolean isMovingRight() {
        return isMovingRight;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // We don't need to handle keyTyped events.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                isMovingUp = true;
                break;
            case KeyEvent.VK_DOWN:
                isMovingDown = true;
                break;
            case KeyEvent.VK_LEFT:
                isMovingLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
                isMovingRight = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                isMovingUp = false;
                break;
            case KeyEvent.VK_DOWN:
                isMovingDown = false;
                break;
            case KeyEvent.VK_LEFT:
                isMovingLeft = false;
                break;
            case KeyEvent.VK_RIGHT:
                isMovingRight = false;
                break;
        }
    }
}
