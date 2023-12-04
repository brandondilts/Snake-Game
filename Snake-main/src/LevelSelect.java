import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelSelect extends JPanel implements ActionListener {
    SnakeWindow frame;
    Level level;

    public LevelSelect(SnakeWindow frame) {
        this.frame = frame;
        setLayout(new GridLayout(6, 1));
        setBackground(Color.DARK_GRAY);
        setOpaque(false);

        JLabel levels = new JLabel("Levels", SwingConstants.CENTER);
        levels.setFont(new Font("Serif", Font.BOLD, 40));
        levels.setForeground(Color.GREEN);
        add(levels);

        JLabel select = new JLabel("Select a level from below", SwingConstants.CENTER);
        select.setFont(new Font("Serif", Font.PLAIN, 20));
        add(select);

        JButton easy = new JButton("Easy");
        easy.addActionListener(this);
        add(easy);

        JButton intermediate = new JButton("Intermediate");
        intermediate.addActionListener(this);
        add(intermediate);

        JButton hard = new JButton("Hard");
        hard.addActionListener(this);
        add(hard);

        JLabel motivation = new JLabel("You got this....maybe", SwingConstants.CENTER);
        motivation.setFont(new Font("Serif", Font.PLAIN, 10));
        add(motivation);
    }

    //selects corresponding level to play based on button click
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("Easy")) {
            System.out.println("Easy level selected");
            level = new Easy();
            frame.startGame(level);
        } else if (e.getActionCommand().equals("Intermediate")) {
            level = new Intermediate();
            frame.startGame(level);
            System.out.println("Intermediate level selected");
        } else if (e.getActionCommand().equals("Hard")) {
            System.out.println("Hard level selected");
            level = new Hard();
            frame.startGame(level);
        } else {
            System.out.println("Something weird happened when selecting a level");

            frame.startGame(level);
        }


    }
}


