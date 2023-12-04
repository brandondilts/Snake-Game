import javax.swing.*;
import java.awt.*;


public class SnakeWindow extends JFrame {
    public static int Height;
    public static int Width;
    JPanel currentGame;
    private MainMenuPanel mainMenu;
    private GamePanel gamePanel;
    private Scoreboard scoreboard;
    private GameOverPanel gameOver;
    public SnakeWindow() {
        super("Snake Game");
        Height = 600;
        Width = 600;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        getContentPane().setLayout(new BorderLayout());
//        getContentPane().setLayout(new BoxLayout());
        getContentPane().setBackground(Color.DARK_GRAY);
        setResizable(false);
        // set size of content in the frame, excludes the title bar
        setPreferredSize(new Dimension(Width, Height));
        //getContentPane().setPreferredSize(new Dimension(Width, Height));
        pack();

        mainMenu = new MainMenuPanel(this);
        currentGame = mainMenu;
        add(currentGame);
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public void gameOver(int score) {
        System.out.println(score);
        remove(currentGame);
        currentGame.setFocusable(false);

        currentGame = new JPanel(new BorderLayout());
        System.out.println("Game over");

        gameOver = new GameOverPanel(scoreboard, this);
        currentGame.add(gameOver);
        currentGame.setVisible(true);

        add(currentGame);

        pack();
        revalidate();
        repaint();


        gameOver.requestFocus();
    }

    public void selectLevel() {
        remove(currentGame);
        currentGame = new LevelSelect(this);
        add(currentGame);
        pack();
        revalidate();
    }

    public void startGame(Level level) {
        remove(currentGame);
//        mainMenu.setFocusable(false);

        currentGame = new JPanel();
        currentGame.setLayout(new BoxLayout(currentGame, BoxLayout.Y_AXIS));

        scoreboard = new Scoreboard(this);
        //currentGame.add(scoreboard, BorderLayout.PAGE_START);
        currentGame.add(scoreboard);
        gamePanel = new GamePanel(this, scoreboard, level);
        //currentGame.add(gamePanel, BorderLayout.CENTER);
        currentGame.add(gamePanel);
        add(currentGame);

        pack();
        revalidate();
        //repaint();

        //focus on gamepanel to start game
        gamePanel.requestFocus();
    }
    public static void main(String[] args) {
        SnakeWindow window = new SnakeWindow();
    }


}
