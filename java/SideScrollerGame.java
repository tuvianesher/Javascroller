import javax.swing.JFrame;

public class SideScrollerGame {
  private GameWindow gameWindow;
  private GamePanel gamePanel;
  private Player player;
  private Obstacle obstacle;
  private Scoreboard scoreboard;
  private ImageLoader imageLoader;
  private KeyboardListener keyboardListener;
  private CollisionDetector collisionDetector;
  private boolean running;

  public SideScrollerGame() {
    this.gameWindow = new GameWindow(GamePanel.PANEL_WIDTH, GamePanel.PANEL_HEIGHT);
    this.gamePanel = new GamePanel();
    this.player = new Player();
    this.obstacle = new Obstacle();
    this.scoreboard = new Scoreboard();
    this.imageLoader = new ImageLoader();
    this.keyboardListener = new KeyboardListener(this.player);
    this.collisionDetector = new CollisionDetector(this.player, this.obstacle);
    this.running = false;
  }

  public void start() {
    this.running = true;
    initialize();
    gameLoop();
  }

  public void stop() {
    this.running = false;
  }

  private void initialize() {
    // Load images
    this.imageLoader.loadImages();

    // Initialize game objects
    this.player.initialize();
    this.obstacle.initialize();
    this.scoreboard.initialize();

    // Add keyboard listener to game window
    this.gameWindow.addKeyListener(this.keyboardListener);

    // Add game panel to game window
    this.gameWindow.add(this.gamePanel);

    // Set game window properties
    this.gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.gameWindow.setSize(GamePanel.PANEL_WIDTH, GamePanel.PANEL_HEIGHT);
    this.gameWindow.setLocationRelativeTo(null);
    this.gameWindow.setVisible(true);
  }

  private void gameLoop() {
    long lastTime = System.nanoTime();
    long currentTime;
    double deltaTime = 0;

    while (this.running) {
      currentTime = System.nanoTime();
      deltaTime += (currentTime - lastTime) / (double) GamePanel.NANOSECONDS_PER_UPDATE;
      lastTime = currentTime;

      // Update game state
      while (deltaTime >= 1) {
        update();
        deltaTime--;
      }

      // Draw game graphics
      draw();
    }
  }

  private void update() {
    // Update player position
    this.player.update();

    // Update obstacle position
    this.obstacle.update();

    // Check for collisions
    if (this.collisionDetector.detectCollision()) {
      this.stop();
    }

    // Update scoreboard
    this.scoreboard.update();
  }

  private void draw() {
    // Clear game panel
    this.gamePanel.clear();

    // Draw game objects
    this.gamePanel.drawImage(this.player.getImage(), this.player.getX(), this.player.getY());
    this.gamePanel.drawImage(this.obstacle.getImage(), this.obstacle.getX(), this.obstacle.getY());
    this.gamePanel.drawText("Score: " + this.scoreboard.getScore(), 10, 20);

    // Repaint game panel
    this.gamePanel.repaint();
  }

  public static void main(String[] args) {
    SideScrollerGame game = new SideScrollerGame();
    game.start();
  }
}