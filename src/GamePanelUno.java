import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanelUno extends JPanel implements Runnable {

    Thread gameThread;
    Image image;
    Graphics graphics;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;
    static Dimension screenSize = new Dimension(Constans.SCREEN_WIDTH,Constans.SCREEN_HEIGHT);

    GamePanelUno(){
        newPaddles();
        newBall();
        score = new Score(Constans.SCREEN_HEIGHT,Constans.SCREEN_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setVisible(true);
        this.setPreferredSize(screenSize);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public static void newBall(){

    }
    public static void newPaddles(){

    }
    public void paint(Graphics g){

    }
    public static void draw (Graphics g){

    }
    public static void move(){

    }
    public void run(){

    }
    public class AL extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }
    }
}
