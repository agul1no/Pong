import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener {

    JFrame mainFrame = new JFrame();
    JTextField pongTitel = new JTextField();

    JButton buttom1 = new JButton("1 Player VS Computer");
    JButton buttom2 = new JButton("2 Players");
    JButton buttom3 = new JButton("Credits");
    JButton buttom4 = new JButton("Quit");

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

        buttom1.setBounds(300,230,200,50);
        buttom1.setFocusable(false);
        buttom1.addActionListener(this);
        buttom2.setBounds(300,300,200,50);
        buttom2.setFocusable(false);
        buttom2.addActionListener(this);
        buttom3.setBounds(300,370,200,50);
        buttom3.setFocusable(false);
        buttom3.addActionListener(this);
        buttom4.setBounds(300,440,200,50);
        buttom4.setFocusable(false);
        buttom4.addActionListener(this);

        mainFrame.add(pongTitel);
        mainFrame.add(buttom1);
        mainFrame.add(buttom2);
        mainFrame.add(buttom3);
        mainFrame.add(buttom4);


        mainFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==buttom1){
            mainFrame.dispose();
            OnePlayerWindow frame = new OnePlayerWindow();
        }

        if(e.getSource()==buttom2){
            mainFrame.dispose();
            TwoPlayersWindow frame = new TwoPlayersWindow();
        }
        if(e.getSource()==buttom3){
            mainFrame.dispose();
            Credits frame = new Credits();
        }
        if(e.getSource()==buttom4){
            mainFrame.dispose();
        }

    }
}
