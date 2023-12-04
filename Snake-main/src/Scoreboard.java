import javax.swing.*;
import java.awt.*;

/**
 * Main board
 * Has score, time, and exit
 * Holds LevelPanel to display chosen difficulty
 */

public class Scoreboard extends JPanel {
    private SnakeWindow frame;
    Score score;
    Timer timer;
    public Scoreboard(SnakeWindow frame){
        this.frame = frame;
        setLayout(new GridLayout(4, 1));
        setBorder(BorderFactory.createLineBorder(Color.black, 5, true));
        setBackground(Color.GREEN);
        setPreferredSize(new Dimension(600, 90));

        JLabel title = new JLabel("Snake!", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 20));
        title.setForeground(Color.BLACK);
        add(title);

        score = new Score();
        //JLabel currentScore = new JLabel("Score: " + score, SwingConstants.CENTER);
        add(score);

        //TODO: fix timer
        int time = 0;
        //timer = new Timer(75, );
        JLabel currentTime = new JLabel("Time: " + time, SwingConstants.CENTER);
        add(currentTime);

        JLabel gamePlay = new JLabel("Press space to pause/unpause game", SwingConstants.CENTER);
        add(gamePlay);

        setVisible(true);
    }
}

