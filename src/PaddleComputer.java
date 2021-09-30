import java.awt.*;

public class PaddleComputer extends Rectangle {

    int x, y, width, height;
    int yVelocity;

    PaddleComputer(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move(){
        if(GamePanelUno.ballComputer.y + 20 < y + 50)
            y = y - yVelocity;
        if(GamePanelUno.ballComputer.y +20 > y + 50)
            y = y + yVelocity;
    }
    public void draw (Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x,y,width,height);
    }
}
