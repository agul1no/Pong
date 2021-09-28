import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener {

    public static JFrame mainFrame = new JFrame();
    JTextField pongTitel = new JTextField();

    JButton button1 = new JButton("1 Player VS Computer");
    JButton button2 = new JButton("2 Players");
    JButton button3 = new JButton("Credits");
    JButton button4 = new JButton("Quit");

    MainMenu(){

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(Constans.SCREEN_WIDTH, Constans.SCREEN_HEIGHT);
        mainFrame.setLayout(null);
        mainFrame.getContentPane().setBackground(Color.BLACK);
        mainFrame.setTitle("Pong - Main Menu");
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);

        pongTitel.setText("Ultimate Pong");
        pongTitel.setBounds(0,80,800,135);
        pongTitel.setBackground(Color.BLACK);
        pongTitel.setForeground(new Color(255, 255, 255));
        pongTitel.setFont(new Font("MV Boil",Font.BOLD,100));
        pongTitel.setBorder(BorderFactory.createBevelBorder(1));
        pongTitel.setHorizontalAlignment(JTextField.CENTER);
        pongTitel.setEditable(false);

        button1.setBounds(300,230,200,50);
        button1.setFocusable(false);
        button1.addActionListener(this);
        button2.setBounds(300,300,200,50);
        button2.setFocusable(false);
        button2.addActionListener(this);
        button3.setBounds(300,370,200,50);
        button3.setFocusable(false);
        button3.addActionListener(this);
        button4.setBounds(300,440,200,50);
        button4.setFocusable(false);
        button4.addActionListener(this);

        mainFrame.add(pongTitel);
        mainFrame.add(button1);
        mainFrame.add(button2);
        mainFrame.add(button3);
        mainFrame.add(button4);


        mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== button1){
            mainFrame.dispose();
            OnePlayerWindow frame = new OnePlayerWindow();
        }

        if(e.getSource()== button2){
            mainFrame.dispose();
            TwoPlayersWindow frame = new TwoPlayersWindow();
        }
        if(e.getSource()== button3){
            mainFrame.setVisible(false);
            Credits frame = new Credits();
            //frame.setVisible(true);
            frame.toFront();
        }
        if(e.getSource()== button4){
            mainFrame.dispose();
        }

    }
}
