import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DungeonEntrance extends Screen{
    JButton saveButton, exitButton, enterCaveButton, restButton;
    JPanel statusTextPanel;
    JLabel statusTextLabel;
    CowardCreditScreenHandler csHandler = new CowardCreditScreenHandler();
    SaveGameHandler sgHandler = new SaveGameHandler();
    RestHandler rHandler = new RestHandler();
    EnterDungeonHandler edHandler = new EnterDungeonHandler();
    public DungeonEntrance(String type, Container container, GameManager game) {
        super(type,container, game);
        mainTextBoxPanel.setBackground(Color.BLUE);
        mainText.setBackground(Color.BLUE);
        mainTextBoxPanel.setBounds(100,100,1080,350);

        statusTextPanel = new JPanel();
        statusTextPanel.setBounds(100,450,1080,50);
        statusTextPanel.setBackground(Color.GREEN);
        statusTextPanel.setForeground(Color.WHITE);
        statusTextPanel.setLayout(new GridLayout(1,1));
        statusTextPanel.setVisible(false);

        statusTextLabel = new JLabel("");
        statusTextLabel.setFont(mainTextFont);
        statusTextLabel.setForeground(Color.WHITE);
        statusTextLabel.setBackground(Color.BLACK);
        statusTextPanel.add(statusTextLabel);
        con.add(statusTextPanel);
        updateText("   The cave entrance is very large and intimidating. There is an ominous " +
                "presence that resonates from the pitch black opening. Nothing can be seen further without venturing inside. " +
                "You set up a small camp and weigh your options." +
                "\n\n   You can save your progress while here at the camp." +
                "\n   You may return to your camp to rest while you are not in danger." +
                "\n   You can re-enter the cave after resting." +
                "\n\n   What would you like to do?");

        //buttons
        exitButton = new JButton("FLEE");
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(buttonFont);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(csHandler);
        mainButtonPanel.add(exitButton);

        saveButton = new JButton("SAVE");
        saveButton.setBackground(Color.BLACK);
        saveButton.setForeground(Color.WHITE);
        saveButton.setFont(buttonFont);
        saveButton.setFocusPainted(false);
        saveButton.addActionListener(sgHandler);
        mainButtonPanel.add(saveButton);

        restButton = new JButton("REST");
        restButton.setBackground(Color.BLACK);
        restButton.setForeground(Color.WHITE);
        restButton.setFont(buttonFont);
        restButton.setFocusPainted(false);
        restButton.addActionListener(rHandler);
        mainButtonPanel.add(restButton);

        enterCaveButton = new JButton("ENTER CAVE");
        enterCaveButton.setBackground(Color.BLACK);
        enterCaveButton.setForeground(Color.WHITE);
        enterCaveButton.setFont(buttonFont);
        enterCaveButton.setFocusPainted(false);
        enterCaveButton.addActionListener(edHandler);
        mainButtonPanel.add(enterCaveButton);


    }

    @Override
    public void updateVisibility(boolean newValue) {
        visibility = newValue;
        mainTextBoxPanel.setVisible(visibility);
        mainButtonPanel.setVisible(visibility);
        statusTextPanel.setVisible(visibility);
    }
    public class SaveGameHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{game.saveGame();
            statusTextLabel.setText("GAME SAVED!");}
            catch(Exception f){
                statusTextLabel.setText("ERROR");
            }
        }
    }
    public class RestHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            game.player.setCurrentHp(game.player.getMaxHp());
            statusTextLabel.setText("YOU FEEL RESTED! CURRENT HP: " + game.player.getCurrentHP() + "/" +
                    game.player.getMaxHp());
        }
    }
    public class EnterDungeonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            updateVisibility(false);
            game.changeScreen("roomOne");
        }
    }
}
