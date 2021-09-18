import javax.swing.*;
import java.awt.*;

public class TwoPlayersWindow extends JFrame {    //we can treat our GameFrame as a JFrame
    // The Frame is the frame around the painting. It houses the panel. it contains the min, max und X buttoms
    GamePanelTwoPlayers panel;
    JFrame frame = new JFrame();

    TwoPlayersWindow(){
        panel = new GamePanelTwoPlayers();   //Instanciating the panel in the constructor
        frame.add(panel);           // adding the game panel "panel" to our Frame
        frame.setSize(Constans.SCREEN_WIDTH,Constans.SCREEN_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Pong - 2 Players");
        frame.setResizable(false);
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();    // podria abrir la ventana muy pequenia

    }
}
