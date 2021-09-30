import javax.swing.*;
import java.awt.*;

public class OnePlayerWindow extends JFrame{

    JFrame frameUno = new JFrame();
    GamePanelUno panelUno;

    OnePlayerWindow(){
        panelUno = new GamePanelUno();
        //this.add(panelUno);

        frameUno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameUno.setResizable(false);
        frameUno.setSize(Constans.SCREEN_WIDTH, Constans.SCREEN_HEIGHT);
        frameUno.setLocationRelativeTo(null);
        frameUno.setTitle("Pong - 1 Player VS Computer");
        frameUno.setBackground(Color.BLACK);
        //frameUno.pack();

        frameUno.setVisible(true);





    }
}
