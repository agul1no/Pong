import java.awt.*;
import java.util.Timer;
import java.util.concurrent.CompletionService;

public class Score extends Rectangle{

    public static int player1 = 0;
    public static int player2 = 0;
    public static int playerComputer = 0;
    static int width;
    static int height;

    Score(int gameWidth, int gameHeight){
        Score.width = width;
        Score.height = height;
    }

    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas", Font.PLAIN,60));

        g.drawLine(Constans.SCREEN_WIDTH/2,0,Constans.SCREEN_WIDTH/2,Constans.SCREEN_HEIGHT);

        g.drawString(String.valueOf(player1), (Constans.SCREEN_WIDTH/2)-90, 50);
        g.drawString(String.valueOf(player2), (Constans.SCREEN_WIDTH/2)+55, 50);

        if(player1 >= 11 && player1-player2 > 1){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Consolas", Font.PLAIN,70));
            g.drawString("Player 1 won!", 160,250);
            GamePanelTwoPlayers.end = true;
            GamePanelUno.end1 = true;
            //TODO Wenn das Spiel vorbei ist, fehlt der Button, um wieder zum Main Menu zurückzukommen
        }
        if(player2 >= 11 && player2-player1 > 1){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Consolas", Font.PLAIN,70));
            g.drawString("Player 2 won!", 160,250);
            GamePanelTwoPlayers.end = true;
            GamePanelUno.end1 = true;
        }
    }
}
