import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenuPanel extends JPanel {
    private SnakeWindow frame;
    private JLabel start;
    // create main menu panel
    public MainMenuPanel(SnakeWindow frame) {
        setFocusable(true);
        this.frame = frame;
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Snake", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 100));
        title.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        title.setForeground(Color.GREEN);
        add(title, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0,0,100,0));
        bottomPanel.setOpaque(false);

        start = new JLabel("Hit enter to continue...", SwingConstants.CENTER);
        start.setFont(new Font("Serif", Font.BOLD, 30));
        start.setForeground(Color.white);
        start.setBackground(Color.darkGray);
        start.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        bottomPanel.add(start);

        add(bottomPanel, BorderLayout.SOUTH);


        addKeyListener(new StartKeyListener());
        start.addMouseListener(new StartMouseListener());
        setOpaque(false);
    }


    private class StartMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            //frame.startGame();
            frame.selectLevel();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            start.setOpaque(true);
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e){

            start.setOpaque(false);
            repaint();
        }
    }

    // keyboard listener
    private class StartKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyPressed = e.getKeyCode();
            if (keyPressed == KeyEvent.VK_ENTER) {
                //frame.startGame();
                frame.selectLevel();
            }
        }
    }
}
