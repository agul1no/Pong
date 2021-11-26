import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Credits extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton button1 = new JButton("Back to main menu");

    Credits(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(Constans.SCREEN_WIDTH, Constans.SCREEN_HEIGHT);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Pong - Credits");
        frame.setIconImage(MainMenu.image.getImage());

        textField.setText("About this game");
        textField.setBounds(0,20,800,110);
        textField.setBackground(Color.BLACK);
        textField.setForeground(new Color(255, 255, 255));
        textField.setFont(new Font("MV Boil",Font.BOLD,80));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setText("      The Pong Game was originally developed by Allan Alcorn and  released  in  1972  by  Atari  Corporations. " +
                "Soon,  Pong became a huge success and became the first commercially successful game. Today, the Pong Game is " +
                "considered to be the game which started the video games industry, as it proved that the video games market " +
                "can produce significant revenues. 1975 Atari released a home edition of Pong which sold 150,000 units." +
                "                         " +
                "                                                                          " +
                " This version of Pong was developed in 2021 by Agu as his first ''big'' programing project." +
                "                                                                    " +
                "                                                                        " +
                "                                            So have fun and good luck! ;)");
        textArea.setBounds(100,170,580,400);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Time new roman",Font.PLAIN,20));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);

        button1.setBounds(580,480,150,30);
        button1.setFocusable(false);
        button1.addActionListener(this);

        frame.add(button1);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== button1){
            //TODO Credit Frame wird nicht ausgeblenden und MainMenu mainFrame wird nicht angezeigt.
            //frame.dispose();
            frame.toBack();
            frame.setVisible(false);
            MainMenu.mainFrame.setVisible(true);
            //MainMenu.mainFrame.setState(JFrame.NORMAL);
            //MainMenu.mainFrame.setVisible(true);

        }
    }
}
