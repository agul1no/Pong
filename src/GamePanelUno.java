import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanelUno extends JPanel implements Runnable {

    Thread gameThread;
    Image image;
    Graphics graphics;
    static Paddle paddle1;
    static PaddleComputer paddleComputer;
    static Ball ballComputer;
    Score score;
    //static Dimension screenSize = new Dimension(Constans.SCREEN_WIDTH,Constans.SCREEN_HEIGHT);
    public static boolean condition = false;
    public static boolean end = false;

    GamePanelUno(){
        newPaddles();
        newBall();
        score = new Score(Constans.SCREEN_HEIGHT,Constans.SCREEN_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setVisible(true);
        this.setPreferredSize(Constans.SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public static void newBall(){
         ballComputer = new Ball( (Constans.SCREEN_WIDTH/2 - Constans.BALL_DIAMETER/2),Constans.SCREEN_HEIGHT/2 - Constans.BALL_DIAMETER/2, Constans.BALL_DIAMETER, Constans.BALL_DIAMETER);
    }
    public static void newPaddles(){
        paddle1 = new Paddle(0,(Constans.SCREEN_HEIGHT/2)-(Constans.PADDLE_HEIGHT/2),Constans.PADDLE_WIDTH, Constans.PADDLE_HEIGHT, 1);
        paddleComputer= new PaddleComputer(Constans.SCREEN_WIDTH - Constans.PADDLE_WIDTH,(Constans.SCREEN_HEIGHT/2)-(Constans.PADDLE_HEIGHT/2),Constans.PADDLE_WIDTH, Constans.PADDLE_HEIGHT);
    }
    public void paint(Graphics g){

    }
    public static void draw (Graphics g){

    }
    public static void move(){
        paddle1.move();
        paddleComputer.move();
        ballComputer.move();
    }
    public void checkCollision() {

    }
    public void run(){
        //creating an easy game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1_000_000_000 / amountOfTicks;
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            System.out.println(condition);
            System.out.println(Score.player1);
            System.out.println(Score.player2);
            score.startingTheScore2();
            score.startingTheScore1();
            //TODO Score zählt mit obwohl das Spiel Loop nicht angefangen hat
            if(delta >= 1 && condition && !end){
                move();
                checkCollision();
                repaint();
                delta--;
            }else{

            }
        }
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
