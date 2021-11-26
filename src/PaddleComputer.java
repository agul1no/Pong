import java.awt.*;

public class PaddleComputer extends Rectangle {

    int x, width, height;
    public static double y;
    public static double yVelocity;

    PaddleComputer(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public static void checkingBall(){
        if(GamePanelUno.condition1){
            if(GamePanelUno.ballComputer.y + 20 <= y + 50) {
                setYDirection(-Constans.PADDLE_COMPUTER_VELOCITY);
                movePaddle();
              } else {
                setYDirection(Constans.PADDLE_COMPUTER_VELOCITY);
                movePaddle();
                if(GamePanelUno.ballComputer.y + 20 == y + 50)
                    setYDirection(0);
            }
        }else {
            setYDirection(0);
        }

    }

    public static void setYDirection (double yDirection){
        yVelocity = yDirection;
    }
    public static void movePaddle(){
            y = y + yVelocity;
    }
    public void draw (Graphics g){
        g.setColor(Color.MAGENTA);
        g.fillRect(x,(int)y,width,height);
    }
}
