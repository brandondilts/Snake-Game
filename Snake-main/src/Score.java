import javax.swing.*;

public class Score extends JLabel {
    int score;
    public Score() {
        score = 0;
        setText("Score: " + String.valueOf(score));
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void addItem(Item item) {
        score += item.changeScore();
        setText("Score: " + String.valueOf(score));
    }
    public String scoreText() {
        return "Score: " + score;
    }
}
