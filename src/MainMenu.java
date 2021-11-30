import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener {

    public static JFrame mainFrame = new JFrame();
    JTextField pongTitel = new JTextField();
    public static ImageIcon image = new ImageIcon("pingpong.png"); // creates an image icon
    public static boolean menu1 = true;

    JButton button1 = new JButton("1 Player VS Computer");
    JButton button2 = new JButton("2 Players");
    JButton button3 = new JButton("Credits");
    JButton button4 = new JButton("Quit");
    JRadioButton easy;
    JRadioButton medium;
    JRadioButton hard;
    ButtonGroup bg;
    JTextField select;


    MainMenu(){

        easy = new JRadioButton(" easy");
        medium = new JRadioButton(" medium", true);
        hard = new JRadioButton(" hard");
        bg = new ButtonGroup();

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(Constans.SCREEN_WIDTH, Constans.SCREEN_HEIGHT);
        mainFrame.setLayout(null);
        mainFrame.getContentPane().setBackground(Color.BLACK);
        mainFrame.setTitle("Pong - Main Menu");
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setIconImage(image.getImage()); // change icon of frame

        pongTitel.setText("Ultimate Pong");
        pongTitel.setBounds(0,20,800,135);
        pongTitel.setBackground(Color.BLACK);
        pongTitel.setForeground(new Color(255, 255, 255));
        pongTitel.setFont(new Font("MV Boil",Font.BOLD,100));
        pongTitel.setBorder(BorderFactory.createBevelBorder(1));
        pongTitel.setHorizontalAlignment(JTextField.CENTER);
        pongTitel.setEditable(false);

        button1.setBounds(150,230,200,50);
        button1.setFocusable(false);
        button1.addActionListener(this);
        button2.setBounds(150,300,200,50);
        button2.setFocusable(false);
        button2.addActionListener(this);
        button3.setBounds(150,370,200,50);
        button3.setFocusable(false);
        button3.addActionListener(this);
        button4.setBounds(150,440,200,50);
        button4.setFocusable(false);
        button4.addActionListener(this);

        easy.setBounds(500,250,100,50);
        easy.setBackground(Color.BLACK);
        easy.setForeground(Color.WHITE);
        easy.setFont(new Font("Time new roman",Font.PLAIN,30));
        easy.setFocusable(false);
        easy.addActionListener(this);

        medium.setBounds(500,300,150,50);
        medium.setBackground(Color.BLACK);
        medium.setForeground(Color.WHITE);
        medium.setFont(new Font("Time new roman",Font.PLAIN,30));
        medium.setFocusable(false);
        medium.addActionListener(this);

        hard.setBounds(500,350,100,50);
        hard.setBackground(Color.BLACK);
        hard.setForeground(Color.WHITE);
        hard.setFont(new Font("Time new roman",Font.PLAIN,30));
        hard.setFocusable(false);
        hard.addActionListener(this);

        select = new JTextField();
        select.setText("Select the Level of difficulty:");
        select.setBounds(400,155,350,100);
        select.setBackground(Color.BLACK);
        select.setForeground(Color.WHITE);
        select.setFont(new Font("Time new roman",Font.PLAIN,28));
        select.setEditable(false);
        select.setBorder(BorderFactory.createBevelBorder(1));

        mainFrame.add(pongTitel);
        mainFrame.add(button1);
        mainFrame.add(button2);
        mainFrame.add(button3);
        mainFrame.add(button4);
        mainFrame.add(easy);
        mainFrame.add(medium);
        mainFrame.add(hard);
        mainFrame.add(select);
        bg.add(easy);
        bg.add(medium);
        bg.add(hard);


        mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== button1){
            mainFrame.dispose();
            OnePlayerWindow frame = new OnePlayerWindow();
            menu1 = true;
        }

        if(e.getSource()== button2){
            mainFrame.dispose();
            TwoPlayersWindow frame = new TwoPlayersWindow();
            menu1 = false;
        }
        if(e.getSource()== button3){
            mainFrame.setVisible(false);
            Credits frame = new Credits();
            //frame.setVisible(true);
            frame.toFront();
        }
        if(e.getSource()== button4){
            mainFrame.dispose();
            System.exit(0);
        }

        if(e.getSource() == easy){
            GamePanelUno.maxSpeed1 = 10;
            GamePanelTwoPlayers.maxSpeed2 = 10;
        }
        if(e.getSource() == medium){
            GamePanelUno.maxSpeed1 = 15;
            GamePanelTwoPlayers.maxSpeed2 = 15;
        }
        if(e.getSource() == hard){
            GamePanelUno.maxSpeed1 = 20;
            GamePanelTwoPlayers.maxSpeed2 = 20;
        }

    }
}
