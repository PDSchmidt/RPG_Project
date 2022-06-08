import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//End Screen for the game
public class CreditScreen extends Screen{
    JButton exit;
    ExitHandler eHandler = new ExitHandler();
    public CreditScreen(String type, Container container, GameManager game){
        super(type, container, game);
        mainTextBoxPanel.setBounds(540, 100, 400,400);
        mainText.setText("Created by:" +
                "\nPaul Schmidt" +
                "\nSimon That" +
                "\nDevinn Wilson");
        mainButtonPanel.setBounds(540,550, 200, 50);
        exit = new JButton("EXIT");
        exit.setFocusPainted(false);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setFont(buttonFont);
        exit.addActionListener(eHandler);
        mainButtonPanel.add(exit);

    }
    //Instructions for turning on/off the GUI based on whether the player is getting the coward ending or regular credits
    @Override
    public void updateVisibility(boolean newValue) {
        visibility = newValue;
        mainTextBoxPanel.setVisible(visibility);
        if(game.cowardEnding){
            mainTextBoxPanel.setBounds(200,100,1080, 400);
            mainText.setText("Something along your journey has scared you away from this quest. . . " +
                    "\nYou flee the country in shame, never to return." +
                    "\n\n\t\tCreated by:" +
                    "\n\t\tPaul Schmidt" +
                    "\n\t\tSimon That" +
                    "\n\t\tDevinn Wilson");
        }
        mainButtonPanel.setVisible(visibility);
    }
    public class ExitHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
