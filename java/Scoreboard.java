import javax.swing.JLabel;

public class Scoreboard {
    private int score;
    private JLabel scoreLabel;

    public Scoreboard() {
        score = 0;
        scoreLabel = new JLabel("Score: " + score);
    }

    public void updateScore(int points) {
        score += points;
        scoreLabel.setText("Score: " + score);
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    public int getScore() {
        return score;
    }
}
