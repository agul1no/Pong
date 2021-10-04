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
            GamePanelTwoPlayers.condition = true;
            GamePanelUno.condition1 = true;
            Score.player1=0;
            Score.player2=0;
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

}

