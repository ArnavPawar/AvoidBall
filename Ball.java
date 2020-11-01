
/*
 * Arnav Pawar 
 * avoid ball game
 * june 14
 */
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.Timer;
import java.lang.Math;
import java.awt.Toolkit;
public class Ball {
    private static final int DIAMETER = 30;
    
    int x = (int)(Math.random()*300);
    int xa = 1;
    int y = 0;
    int ya = 1;
    int timer = 1000;
    int scale = 1;
    private Game game;

    public Ball(Game game) {
        this.game= game;      
    }
    
    public void move() {
        if (x + xa < 0){//scale makes the ball bigger
            xa = 2 * scale;
        }
        if (x + xa > game.getWidth() - DIAMETER*scale){
            xa = -2 * scale;
        }
        if (y + ya < 0){
            ya = 2* scale;
        }
        if (y + ya > game.getHeight() - DIAMETER*scale){
            ya=-2* scale; 
        }
        if (collision()){//collision will end the game   
            game.gameOver();
        }
        if(timer ==0){
            scale++;
            timer=1000;
        }else{
            timer--;
        }
        x = x + xa;
        y = y + ya;        
    }
     public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getScale(){
        return scale;
    }       
    private boolean collision() {//looks for collison
        return game.box.getBounds().intersects(getBounds());     
    }   
    public void paint(Graphics2D g) {//mults diam by scale to make bigger
        g.fillOval(x, y, DIAMETER * scale, DIAMETER* scale);   
    }    
    public Rectangle getBounds() {//draw bal
        return new Rectangle(x, y, DIAMETER*scale, DIAMETER*scale);
    }   
}
