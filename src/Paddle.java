import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle{

    int id;
    int x, y, width, height;
    int yVelocity;

    Paddle(int x, int y, int width, int height, int id){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
    }

    public void keyPressed(KeyEvent e){            // we add the AL Class to the Paddle Class
        switch (id){                           // Switch operator to see the id of the Paddle
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){               // in the under class AL extends KeyAdapter in the method keyPressed(KeyEvent e)
                    setYDirection(-Constans.PADDLE_VELOCITY);    // we write "object.keyPressed(e)" in the class of the object, here,
                    movePaddle();                                      // we ask for the condition "e.getKeyCode()==KeyEvent.VK_UP_DOWN_S_WHATEVER"
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(Constans.PADDLE_VELOCITY);
                    movePaddle();
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(-Constans.PADDLE_VELOCITY);
                    movePaddle();
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setYDirection(Constans.PADDLE_VELOCITY);
                    movePaddle();
                }
                break;

        }
    }
    public void keyReleased(KeyEvent e){
        switch (id){
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){      // the same for the keyReleased method
                    setYDirection(0);
                    movePaddle();
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(0);
                    movePaddle();
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(0);
                    movePaddle();
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setYDirection(0);
                    movePaddle();
                }
                break;

        }

    }
    public void setYDirection (int yDirection){

        yVelocity = yDirection;
    }
    public void movePaddle (){

        y = y + yVelocity;
    }
    public void draw(Graphics g) {
        if(id== 1) {
            g.setColor(Color.BLUE);
        } else
            g.setColor(Color.RED);
        g.fillRect(x,y,width,height);

    }
}