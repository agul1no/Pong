import javax.swing.*;
import java.awt.*;

public class Credits extends JFrame {

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();

    Credits(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(Constans.SCREEN_WIDTH, Constans.SCREEN_HEIGHT);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Pong - Credits");

        textField.setText("About this game");
        textField.setBounds(0,20,800,110);
        textField.setBackground(Color.BLACK);
        textField.setForeground(new Color(255, 255, 255));
        textField.setFont(new Font("MV Boil",Font.BOLD,80));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setText("      The Pong Game was originally developed by Allan Alcorn and released in 1972 by Atari Corporations. " +
                "Soon, Pong became a huge success and became the first commercially successful game. Today, the Pong Game is " +
                "considered to be the game which started the video games industry, as it proved that the video games market " +
                "can produce significant revenues. 1975 Atari released a home edition of Pong which sold 150,000 units." +
                "                         " +
                "                                                                                                " +
                "       This version of Pong was developed in 2021 by Agu as his first ''big'' programing project." +
                "                                                                    " +
                "                                                                        " +
                "                                                       So have fun and good luck! ;)");
        textArea.setBounds(80,170,600,400);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Time new roman",Font.PLAIN,20));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);
    }
}
