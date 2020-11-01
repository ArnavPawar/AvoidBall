



/*
 * Arnav Pawar 
 * avoid ball game
 * final game proj
 * june 14
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.Timer; 
import java.awt.Font;
//@SuppressWarnings("serial")
public class Game extends JPanel {

    Ball ball = new Ball(this);
    Box box = new Box(this);
    static TimerTask task;
    static Timer timer = new Timer(); 
    int scores= 0;
    int timing =100;
   
    public Game() {       
        addKeyListener(new KeyListener() {//declaring keylistener
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {
                box.keyReleased(e);
            }
            @Override
            public void keyPressed(KeyEvent e) {
                box.keyPressed(e);
            }
        });
        setFocusable(true);
    }    
    public void move() {
        ball.move();
        box.move();
    }
   
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        int size = ball.getScale();       
        ball.paint(g2);        
        box.paint(g2);
        if(timing == 0){//when time =0 add one to score
            scores +=1;
            timing = 100;
        }
        else{
            timing--;
        }
        g.setFont(new Font("Sherif" , Font.BOLD, 20));
        g.drawString("      Score:  " + scores * 50,160,50);//creates the scire
    }
    public void gameOver() {
        System.exit(ABORT);//closes the window when collision occurs
    }
    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("avoid ball");
        Game game = new Game();
        Ball ball= new Ball(game);
      
        frame.add(game);
        frame.setSize(500, 500);//300,400
        frame.setVisible(true);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
            //timer.schedule(task,5000, 5000); 
        }
    }
}

