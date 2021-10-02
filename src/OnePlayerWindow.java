import javax.swing.*;
import java.awt.*;

public class OnePlayerWindow extends JFrame{

    GamePanelUno panelUno;
    JFrame frameUno = new JFrame();

    OnePlayerWindow(){
        panelUno = new GamePanelUno();
        frameUno.add(panelUno);
        frameUno.setSize(Constans.SCREEN_WIDTH, Constans.SCREEN_HEIGHT);
        frameUno.setLocationRelativeTo(null);
        frameUno.setTitle("Pong - 1 Player VS Computer");
        frameUno.setResizable(false);
        frameUno.setBackground(Color.BLACK);
        frameUno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameUno.setVisible(true);
        frameUno.pack();
    }
}
