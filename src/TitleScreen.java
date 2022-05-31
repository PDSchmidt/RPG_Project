import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class TitleScreen extends Screen{
    JPanel adventureLogoPanel,buttonPanel;
    JLabel title;
    JButton newAdventure,loadAdventure;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);


    NewGameButtonHandler ngHandler = new NewGameButtonHandler();

    public TitleScreen(){

    }
    public TitleScreen(String type, Container container, GameManager game) {
        super(type,container,game);
        hasCombat = false;
        combatDone = false;
        visibility = false;

        adventureLogoPanel = new JPanel();
        adventureLogoPanel.setBounds(100,100,1080,150);
        adventureLogoPanel.setBackground(Color.BLACK);

        title = new JLabel("ADVENTURE");
        title.setForeground(Color.WHITE);
        title.setFont(titleFont);
        adventureLogoPanel.add(title);

        con.add(adventureLogoPanel);

        buttonPanel = new JPanel();
        buttonPanel.setBounds(540,400,200,100);
        buttonPanel.setBackground(Color.BLUE);
        buttonPanel.setLayout(new GridLayout(2,1));

        newAdventure = new JButton("NEW");
        newAdventure.setBackground(Color.BLACK);
        newAdventure.setForeground(Color.WHITE);
        newAdventure.setFont(buttonFont);
        newAdventure.setFocusPainted(false);
        //action listener
        newAdventure.addActionListener(ngHandler);
        buttonPanel.add(newAdventure);

        loadAdventure = new JButton("LOAD");
        loadAdventure.setBackground(Color.BLACK);
        loadAdventure.setForeground(Color.WHITE);
        loadAdventure.setFont(buttonFont);
        loadAdventure.setFocusPainted(false);
        //action listener
        buttonPanel.add(loadAdventure);


        con.add(buttonPanel);
        con.repaint();

    }

    @Override
    public void updateVisibility(boolean newValue) {
        super.updateVisibility(newValue);
        adventureLogoPanel.setVisible(visibility);
        buttonPanel.setVisible(visibility);

    }
    public void createNewGame(){
        updateVisibility(false);
        game.changeScreen("newCharacterScreen");
    }
    public class NewGameButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            createNewGame();

        }
    }
}
