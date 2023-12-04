import javax.swing.*;
import java.awt.*;
import java.util.Random;

public interface Level {
    Random random = new Random();
    public Color changeBackground();
    public Item selectItem();
}

//only apples appear
class Easy implements Level {
    Color background = Color.CYAN;

    public Easy() {
    }

    public Color changeBackground() {
        return background;
    }

    public Item selectItem() {
        return new Apple();
    }
}

//introduces bombs
class Intermediate implements Level {
    Color background = Color.YELLOW;
    Item item;
    public Intermediate(){}
    public Color changeBackground() {
        return background;
    }
    public Item selectItem() {
        int next = random.nextInt(100);
        System.out.println("random item int " + next);
        if (next > 75) {
            item = new Bomb();
        }  else {
            //any other time
            item = new Apple();
        } return item;
    }
}

//higher probability of bombs and diamonds
class Hard implements Level {
    Color background = Color.magenta;
    Item item;
    public Hard(){}
    public Color changeBackground() {
        return background;
    }
    public Item selectItem() {
        int next = random.nextInt(100);
        if (next % 10 == 0 || next % 15 == 0) {
            item = new Bomb();
        } else if (next % 20 == 0 || next % 30 == 0) {
            item = new Diamond();
        } else {
            //any other time
            item = new Apple();
        } return item;
    }
}

