import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanelUno extends JPanel implements Runnable {

    public static Thread gameThread1;
    Image image1;
    Graphics graphics1;
    Paddle paddle1P;
    PaddleComputer paddleComputer;
    static Ball ballComputer;
    Score score1;
    //static Dimension screenSize = new Dimension(Constans.SCREEN_WIDTH,Constans.SCREEN_HEIGHT);
    public static boolean condition1 = false;
    public static boolean end1 = false;

    GamePanelUno(){
        newPaddles();
        newBall();
        score1 = new Score(Constans.SCREEN_HEIGHT,Constans.SCREEN_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        //this.setVisible(true);
        this.setPreferredSize(Constans.SCREEN_SIZE);

        gameThread1 = new Thread(this);
        gameThread1.start();
    }

    public void newBall(){
         ballComputer = new Ball( (Constans.SCREEN_WIDTH/2 - Constans.BALL_DIAMETER/2),Constans.SCREEN_HEIGHT/2 - Constans.BALL_DIAMETER/2, Constans.BALL_DIAMETER, Constans.BALL_DIAMETER);
    }
    public void newPaddles(){
        paddle1P = new Paddle(0,(Constans.SCREEN_HEIGHT/2)-(Constans.PADDLE_HEIGHT/2),Constans.PADDLE_WIDTH, Constans.PADDLE_HEIGHT, 1);
        paddleComputer = new PaddleComputer(Constans.SCREEN_WIDTH - Constans.PADDLE_WIDTH,(Constans.SCREEN_HEIGHT/2)-(Constans.PADDLE_HEIGHT/2),Constans.PADDLE_WIDTH, Constans.PADDLE_HEIGHT);
    }
    public void paint(Graphics g){
        image1 = createImage(getWidth(),getHeight());
        graphics1 = image1.getGraphics();
        draw(graphics1);
        g.drawImage(image1,0,0,this);
    }
    public void draw (Graphics g){
        paddle1P.draw(g);
        paddleComputer.draw(g);
        ballComputer.draw(g);
        score1.draw(g);

        if(!condition1) {
            if (Ball.i == 0){
                g.setColor(Color.WHITE);
                g.setFont(new Font("Consolas", Font.PLAIN, 48));
                g.drawString("Press the Space bar to start", 50, 210);
            } else if(!Ball.exit) {
                g.setColor(Color.WHITE);
                g.setFont(new Font("Consolas", Font.PLAIN, 42));
                g.drawString("Press the Space bar to continue", 50, 110);
                g.setFont(new Font("Consolas", Font.PLAIN, 40));
                g.drawString("or", 378, 160);
                g.drawString("press escape to exit the Game", 92, 210);
            }
        }
    }
    public void move(){
        ballComputer.move();
    }
    public void movePaddle(){
        paddle1P.movePaddle();
        paddleComputer.movePaddle();
    }

    public double calculateNewVelocityAngle() {
        double relativeIntersectY = (paddle1P.y + (paddle1P.height / 2.0)) - (ballComputer.y + (Constans.BALL_DIAMETER/ 2.0));
        double normalIntersectY = relativeIntersectY / (paddle1P.height / 2.0);
        double theta = normalIntersectY * Constans.MAX_ANGLE;

        return Math.toRadians(theta); // convert to radians cause sin function expects radiant
    }

    public double calculateNewVelocityAngle2() {
        double relativeIntersectY = (paddleComputer.y + (Constans.PADDLE_HEIGHT / 2.0)) - (ballComputer.y + (Constans.BALL_DIAMETER/ 2.0));
        double normalIntersectY = relativeIntersectY / (Constans.PADDLE_HEIGHT / 2.0);
        double theta = normalIntersectY * Constans.MAX_ANGLE;

        return Math.toRadians(theta); // convert to radians cause sin function expects radiant
    }

    public void checkCollision() {
//bounce the ball at the window edges
        if (ballComputer.y <= 0) {
            ballComputer.setYDirection(-ballComputer.yVelocity);
        }
        if (ballComputer.y >= Constans.SCREEN_HEIGHT - Constans.BALL_DIAMETER) {
            ballComputer.setYDirection(-ballComputer.yVelocity);
        }
        //bounces ball out of paddles
        Random random = new Random();
        int rand = random.nextInt(6);
        if (ballComputer.xVelocity < 0) {
            if (ballComputer.x < paddle1P.x + Constans.PADDLE_WIDTH) {  //we extended the ball class to a rectangle so now the class has the methods of the rectangle class (inheritance)
                if (ballComputer.y + 20 > paddle1P.y && ballComputer.y < paddle1P.y + Constans.PADDLE_HEIGHT) {
                    //ball.xVelocity = -ball.xVelocity;
                    double theta = calculateNewVelocityAngle();
                    double newVx = Math.abs((Math.cos(theta)) * -ballComputer.xVelocity);
                    double newVy = (-Math.sin(theta)) * ballComputer.yVelocity;    // Math.sin expects radiant

                    //double oldSing = Math.signum(ball.xVelocity); //give the sign of vx. Positive or negative
                    ballComputer.xVelocity = newVx * Constans.BALL_VELOCITY;
                    if (ballComputer.xVelocity > 16)
                        ballComputer.xVelocity = 16;
                    if (rand >= 3) {
                        rand = 3;
                    } else
                        rand = -3;
                    ballComputer.yVelocity = newVy - rand;
                }
            }
        } else if (ballComputer.xVelocity > 0) {
            if (ballComputer.x + Constans.BALL_DIAMETER > paddleComputer.x) {
                if (ballComputer.y + 20 > paddleComputer.y && ballComputer.y < paddleComputer.y + Constans.PADDLE_HEIGHT) {
                    //ball.xVelocity = -ball.xVelocity;
                    double theta = calculateNewVelocityAngle2();
                    double newVx = Math.abs((Math.cos(theta)) * -ballComputer.xVelocity);
                    double newVy = (-Math.sin(theta)) * ballComputer.yVelocity;    // Math.sin expects radiant

                    //double oldSing = Math.signum(ball.xVelocity); //give the sign of vx. Positive or negative
                    ballComputer.xVelocity = newVx * -Constans.BALL_VELOCITY;
                    if (ballComputer.xVelocity < -16)
                        ballComputer.xVelocity = -16;
                    if (rand >= 3) {
                        rand = 3;
                    } else
                        rand = -3;
                    ballComputer.yVelocity = newVy - rand;

                }
            }
        }

        // stops paddles at window edges
        if(paddle1P.y <= 0){
            paddle1P.y = 0;
        }
        if(paddle1P.y >= Constans.SCREEN_HEIGHT-Constans.PADDLE_HEIGHT){
            paddle1P.y = Constans.SCREEN_HEIGHT-Constans.PADDLE_HEIGHT;
        }
        if(paddleComputer.y <= 0){
            paddleComputer.y = 0;
        }
        if(paddleComputer.y >= Constans.SCREEN_HEIGHT-Constans.PADDLE_HEIGHT){
            paddleComputer.y = Constans.SCREEN_HEIGHT-Constans.PADDLE_HEIGHT;
        }
        //it gives player 1 point and creates new paddles and ball
        if(ballComputer.x <= 0 && condition1){
            score1.player2++;
            newPaddles();
            newBall();
            System.out.println("Player 2: "+ score1.player2);
        }
        if(ballComputer.x > Constans.SCREEN_WIDTH - Constans.BALL_DIAMETER && condition1){
            score1.player1++;
            newPaddles();
            newBall();
            System.out.println("Player 1: "+ score1.player1);
        }
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
            //System.out.println(condition1);
            //System.out.println(Score.player1);
            //System.out.println(Score.player2);
            if(delta >= 1){
                if(condition1 && !end1) {
                    move();
                    PaddleComputer.checkingBall();
                    movePaddle();
                    }


                checkCollision();
                repaint();
                delta--;
            }
        }
    }
    public class AL extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            paddle1P.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e) {
            paddle1P.keyReleased(e);
            ballComputer.keyReleased(e);
        }
    }
}
