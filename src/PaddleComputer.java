import java.awt.*;

public class PaddleComputer extends Rectangle {

    int x, width, height;
    public static int y;
    public static int yVelocity;

    PaddleComputer(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public static void checkingBall(){
        if(GamePanelUno.ballComputer.y + 20 < y + 50)
            setYDirection(-Constans.PADDLE_VELOCITY);
            movePaddle();
        if(GamePanelUno.ballComputer.y +20 > y + 50)
            setYDirection(Constans.PADDLE_VELOCITY);
            movePaddle();
    }

    public static void setYDirection (int yDirection){
        yVelocity = yDirection;
    }
    public static void movePaddle(){
            y = y + yVelocity;
    }
    public void draw (Graphics g){
        g.setColor(Color.MAGENTA);
        g.fillRect(x,y,width,height);
    }
}
