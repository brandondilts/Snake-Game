import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameOverPanel extends JPanel {
    //int finalScore;
    SnakeWindow frame;
    JLabel playAgain;
//    JLabel results = new JLabel();
    Scoreboard scoreboard;

    // create the game over screen
    public GameOverPanel(Scoreboard scoreboard, SnakeWindow frame) {
        // set layout guidelines
        setLayout(new BorderLayout());
        this.frame = frame;
        this.scoreboard = scoreboard;
        setVisible(true);
        setFocusable(true);
        setBackground(Color.LIGHT_GRAY);
        // this creates the game over panel message
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setOpaque(false);
        JLabel gameOver = new JLabel("Game Over!", SwingConstants.CENTER);
        gameOver.setFont(new Font("Serif", Font.BOLD, 50));
        gameOver.setForeground(Color.RED);
        gameOver.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(gameOver);

        // create panel for adding results (score total)
        JLabel results = new JLabel(scoreboard.score.scoreText(), SwingConstants.CENTER);
        results.setFont(new Font("Serif", Font.BOLD, 40));
        panel.add(results);

        add(panel, BorderLayout.CENTER);

        //TODO: add option to insert a username and save score to scoreboard
//        JLabel saveScore = new JLabel("Save your score to the scoreboard!", SwingConstants.CENTER);
//        saveScore.setFont(new Font("Serif", Font.PLAIN, 25));
//        add(saveScore);
//
//        JTextField username = new JTextField("Enter a username");
//        username.setEditable(true);
//
//
//        JButton submit = new JButton("Submit");

        //TODO: add submit button then redirect to scoreboard

        //Play again
        playAgain = new JLabel("Play again? Click or Press Enter", SwingConstants.CENTER);
        playAgain.setFont(new Font("Serif", Font.BOLD, 30));
        playAgain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // key listener for button press to restart the game
        addKeyListener(new StartKeyListener());
        playAgain.addMouseListener(new StartMouseListener());


        add(playAgain, BorderLayout.SOUTH);

    }
    // mouse listener for clicking a button
    private class StartMouseListener extends MouseAdapter {
        // when user clicks
        @Override
        public void mouseClicked(MouseEvent e) {
            frame.selectLevel();
        }
        // when cursor enters the frame of the button
        @Override
        public void mouseEntered(MouseEvent e) {
            playAgain.setOpaque(true);
            repaint();
        }
        // when cursor exits frame of button
        @Override
        public void mouseExited(MouseEvent e){

            playAgain.setOpaque(false);
            repaint();
        }
    }

    // keyboard listener
    private class StartKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyPressed = e.getKeyCode();
            if (keyPressed == KeyEvent.VK_ENTER) {
                frame.selectLevel();
            }
        }
    }
}


