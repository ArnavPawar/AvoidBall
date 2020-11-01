

/*
 * Arnav Pawar 
 * avoid ball game
 * june 14
 */
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Box {
    //private static final int Y = 330;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    int y=425;//starts y pos
    int ya=0;
    int x = 425;//start x pos
    int xa = 0;
    private Game game;

    public Box(Game game) {
        this.game = game;
    }

    public void move() {//limits movement
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH){
            x = x + xa;
        }
        if (y + ya > 0 && y + ya < game.getWidth() - WIDTH){
            y = y + ya;
        }
    }

    public void paint(Graphics2D g) {//draws rectangle
        g.fillRect(x, y, 40, 40);
    }

    public void keyReleased(KeyEvent e) {
        xa=0;
        ya=0;
    }
    public void keyPressed(KeyEvent e) {//moves the box
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -4;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 4;
        if (e.getKeyCode() == KeyEvent.VK_UP)
            ya = -4;
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
            ya = 4; 
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
    public int getTopY() {
        return y;
    }
}
