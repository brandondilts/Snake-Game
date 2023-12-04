import java.awt.*;
import java.util.Random;

/**
 * Interface for all items added to GamePanel
 */
public interface Item {
    Random random = new Random();

    public Color changeColor();
    public int changeScore();
    public int getX();
    public int getY();
}

//increase body and score by 1
class Apple implements Item{
    Color color = Color.RED;
    int x;
    int y;
    int points = 1;

        public Apple() {
            x = random.nextInt((int) (GamePanel.screenWidth / GamePanel.unitSize)) * GamePanel.unitSize;
            y = random.nextInt((int) (GamePanel.screenHeight / GamePanel.unitSize)) * GamePanel.unitSize;
        }
        public Color changeColor() {
            return color;
        }
        public int changeScore() {
            return points;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }

    //decrease score by 1
class Bomb implements Item{
    Color color = Color.BLACK;
    int x;
    int y;
    int points = -1;

        public Bomb() {
            x = random.nextInt((int) (GamePanel.screenWidth / GamePanel.unitSize)) * GamePanel.unitSize;
            y = random.nextInt((int) (GamePanel.screenHeight / GamePanel.unitSize)) * GamePanel.unitSize;
        }
        public Color changeColor() {
            return color;
        }
        public int changeScore() {
            return points;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }

    }

    //increase body size by 1, but worth 2 points
class Diamond implements Item{
    Color color = Color.CYAN;
    int x;
    int y;
    int points = 2;

        public Diamond() {
            x = random.nextInt((int) (GamePanel.screenWidth / GamePanel.unitSize)) * GamePanel.unitSize;
            y = random.nextInt((int) (GamePanel.screenHeight / GamePanel.unitSize)) * GamePanel.unitSize;
        }
        public Color changeColor() {
            return color;
        }
        public int changeScore() {
            return points;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }

    }

