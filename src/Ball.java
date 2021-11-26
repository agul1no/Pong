import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.security.Key;
import javax.swing.*;

public class Ball extends Rectangle{
    double x, y;
    int width, height;
    double xIDirection = -2;
    double yIDirection = 0;
    double xVelocity;
    double yVelocity;
    double initialSpeed = 2;
    public static int i = 0;
    public static boolean exit = true;


    Ball(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setXDirection(xIDirection * initialSpeed);
        setYDirection(yIDirection * initialSpeed);

    }

    public void keyReleased(KeyEvent e){
        if(e.getKeyCode()==KeyEvent.VK_SPACE) {
            if(!GamePanelTwoPlayers.condition || !GamePanelUno.condition1) {
                GamePanelTwoPlayers.condition = true;
                GamePanelUno.condition1 = true;
                exit = false;
                i++;
            }else{
                GamePanelUno.condition1 = false;
                GamePanelTwoPlayers.condition = false;
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
            resetScorePlayer1();
            resetScorePlayer2();
            //TODO gameThread oder gameThread1 crash at this point cause the threat that is not started cannot be stopped. Create a check for thread startet yes or no
            if (MainMenu.menu1) {
                GamePanelUno.gameThread1.stop();
                OnePlayerWindow.frameUno.dispose();
                MainMenu.mainFrame.setVisible(true);
            }else {
                GamePanelTwoPlayers.gameThread.stop();
                TwoPlayersWindow.frame.dispose();
                MainMenu.mainFrame.setVisible(true);
            }

        }

    }

    public void setXDirection(double xIDirection){
        xVelocity = xIDirection;
        System.out.println(xVelocity + " xVelocity in setXDirection");
    }

    public void setYDirection(double yIDirection){
        yVelocity = yIDirection;
        System.out.println(yVelocity + " yVelocity in setXDirection");
    }

    public void move(){
            x = (x + xVelocity);
            y = (y + yVelocity);
            //System.out.println(x + " x Postion");
            //System.out.println(y + " y Postion");
    }
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval((int)x,(int)y,width,height);
    }
    public static int resetScorePlayer1(){
        Score.player1 = 0;
        return Score.player1;
    }
    public static int resetScorePlayer2(){
        Score.player2 = 0;
        return Score.player2;
    }

}

