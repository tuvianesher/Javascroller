import javax.swing.JFrame;

public class GameWindow extends JFrame {
    private int width;
    private int height;

    public GameWindow(int width, int height) {
        this.width = width;
        this.height = height;
        initWindow();
    }

    private void initWindow() {
        setTitle("Side Scroller Game");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
