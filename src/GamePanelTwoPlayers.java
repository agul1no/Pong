import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanelTwoPlayers extends JPanel implements Runnable {    // We can treat our GamePanel as a JPanel
    // It is the canvas in where we are painting
    Thread gameThread;     // Runnable
    Image image;
    Graphics graphics;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;
    public static boolean condition = false;
    public static boolean end = false;

    GamePanelTwoPlayers(){              // when we construct our game panel we want to create new paddles
        newPaddles();         // create new ball
        newBall();
        score = new Score(Constans.SCREEN_WIDTH,Constans.SCREEN_HEIGHT); // instanciating the score in the constructor passing the size of the game. We have to indicate what kind of values in the class score in the constructor between parenthesis
        this.setFocusable(true);
        this.addKeyListener(new AL());    // AL is our inner class
        this.setPreferredSize(Constans.SCREEN_SIZE);

        gameThread = new Thread(this);  // this because we are implementing the runnable interface
        gameThread.start();

    }

    public void newBall(){
        ball = new Ball( (Constans.SCREEN_WIDTH/2 - Constans.BALL_DIAMETER/2),Constans.SCREEN_HEIGHT/2 - Constans.BALL_DIAMETER/2, Constans.BALL_DIAMETER, Constans.BALL_DIAMETER);

    }
    public void newPaddles(){
        paddle1 = new Paddle(0,(Constans.SCREEN_HEIGHT/2)-(Constans.PADDLE_HEIGHT/2),Constans.PADDLE_WIDTH, Constans.PADDLE_HEIGHT, 1);
        paddle2 = new Paddle(Constans.SCREEN_WIDTH - Constans.PADDLE_WIDTH,(Constans.SCREEN_HEIGHT/2)-(Constans.PADDLE_HEIGHT/2),Constans.PADDLE_WIDTH, Constans.PADDLE_HEIGHT, 2);

    }
    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());   // we create an image with the dimension of our game panel
        graphics = image.getGraphics();                // we set our graphic equal to the image and we create a graphic
        draw(graphics);                                // we draw all the components and we pass it the graphic that we have created from our image
        g.drawImage(image,0,0, this);   // drawing the image. We pass the image and the coordinates
    }
    public void draw(Graphics g){
        paddle1.draw(g);    // we take our paddle and use the draw function and we pass it the graphic g
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);

        if(!condition) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Consolas", Font.PLAIN, 48));
            g.drawString("Press the Space bar to start", 50, 210);
        }
    }
    public void move(){

        paddle1.move();
        paddle2.move();
        ball.move();
    }

    public double calculateNewVelocityAngle() {
        double relativeIntersectY = (paddle1.y + (paddle1.height / 2.0)) - (ball.y + (Constans.BALL_DIAMETER/ 2.0));
        double normalIntersectY = relativeIntersectY / (paddle1.height / 2.0);
        double theta = normalIntersectY * Constans.MAX_ANGLE;

        return Math.toRadians(theta); // convert to radians cause sin function expects radiant
    }

    public double calculateNewVelocityAngle2() {
        double relativeIntersectY = (paddle2.y + (Constans.PADDLE_HEIGHT / 2.0)) - (ball.y + (Constans.BALL_DIAMETER/ 2.0));
        double normalIntersectY = relativeIntersectY / (Constans.PADDLE_HEIGHT / 2.0);
        double theta = normalIntersectY * Constans.MAX_ANGLE;

        return Math.toRadians(theta); // convert to radians cause sin function expects radiant
    }

    public void checkCollision(){
        //bounce the ball at the window edges
        if(ball.y <= 0){
            ball.setYDirection(-ball.yVelocity);
        }
        if(ball.y >= Constans.SCREEN_HEIGHT-Constans.BALL_DIAMETER){
            ball.setYDirection(-ball.yVelocity);
        }
        //bounces ball out of paddles
        Random random = new Random();
        int rand = random.nextInt(6);
        if (ball.xVelocity < 0){
            if(ball.x < paddle1.x + Constans.PADDLE_WIDTH) {  //we extended the ball class to a rectangle so now the class has the methods of the rectangle class (inheritance)
                if (ball.y + 20 > paddle1.y && ball.y < paddle1.y + Constans.PADDLE_HEIGHT) {
                    //ball.xVelocity = -ball.xVelocity;
                    double theta = calculateNewVelocityAngle();
                    double newVx = Math.abs((Math.cos(theta)) * -ball.xVelocity);
                    double newVy = (-Math.sin(theta)) * ball.yVelocity;    // Math.sin expects radiant

                    //double oldSing = Math.signum(ball.xVelocity); //give the sign of vx. Positive or negative
                    ball.xVelocity = newVx * Constans.BALL_VELOCITY;
                    if(ball.xVelocity > 15)
                        ball.xVelocity = 15;
                    if(rand >=3){
                        rand = 3;
                    }else
                        rand = -3;
                    ball.yVelocity = newVy-rand;
                }
            }
        } else if(ball.xVelocity > 0) {
            if (ball.x + Constans.BALL_DIAMETER > paddle2.x){
                if (ball.y + 20 > paddle2.y && ball.y < paddle2.y + Constans.PADDLE_HEIGHT) {
                    //ball.xVelocity = -ball.xVelocity;
                    double theta = calculateNewVelocityAngle2();
                    double newVx = Math.abs((Math.cos(theta)) * -ball.xVelocity);
                    double newVy = (-Math.sin(theta)) * ball.yVelocity;    // Math.sin expects radiant

                    //double oldSing = Math.signum(ball.xVelocity); //give the sign of vx. Positive or negative
                    ball.xVelocity = newVx * -Constans.BALL_VELOCITY;
                    if(ball.xVelocity < -15)
                        ball.xVelocity = -15;
                    if(rand >=3){
                        rand = 3;
                    }else
                    rand = -3;
                    ball.yVelocity = newVy-rand;

                }
            }
        }

        // stops paddles at window edges
        if(paddle1.y <= 0){
            paddle1.y = 0;
        }
        if(paddle1.y >= Constans.SCREEN_HEIGHT-Constans.PADDLE_HEIGHT){
            paddle1.y = Constans.SCREEN_HEIGHT-Constans.PADDLE_HEIGHT;
        }
        if(paddle2.y <= 0){
            paddle2.y = 0;
        }
        if(paddle2.y >= Constans.SCREEN_HEIGHT-Constans.PADDLE_HEIGHT){
            paddle2.y = Constans.SCREEN_HEIGHT-Constans.PADDLE_HEIGHT;
        }
        //it gives player 1 point and creates new paddles and ball
        if(ball.x <= 0 && condition){
            score.player2++;
            newPaddles();
            newBall();
            System.out.println("Player 2: "+ score.player2);
        }
        if(ball.x > Constans.SCREEN_WIDTH - Constans.BALL_DIAMETER && condition){
            score.player1++;
            newPaddles();
            newBall();
            System.out.println("Player 1: "+ score.player1);
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
            System.out.println(condition);
            System.out.println(Score.player1);
            System.out.println(Score.player2);
            score.startingTheScore(Score.player2);
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


    public class AL extends KeyAdapter{                     // inner Class Action Listener
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);                      // object.function then we determinate what happens when we call
            paddle2.keyPressed(e);                     // this function. See class Paddle keyPressed and keyReleased
        }
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
            ball.keyReleased(e);
        }

    }
}
