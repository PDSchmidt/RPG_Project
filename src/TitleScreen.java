import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class TitleScreen extends Screen{
    JPanel adventureLogoPanel,buttonPanel,loadedPanel,continuePanel;
    JLabel title,loadedStatus;
    JButton newAdventure,loadAdventure,continueButton;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);


    NewGameButtonHandler ngHandler = new NewGameButtonHandler();
    LoadGameButtonHandler lgHandler = new LoadGameButtonHandler();
    ContinueButtonHandler cbHandler = new ContinueButtonHandler();

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
        loadAdventure.addActionListener(lgHandler);
        //action listener
        buttonPanel.add(loadAdventure);

        loadedPanel = new JPanel();
        loadedPanel.setBounds(440,550,400,100);
        loadedPanel.setBackground(Color.BLACK);

        loadedStatus = new JLabel("TEST");
        loadedStatus.setBackground(Color.RED);
        loadedStatus.setForeground(Color.WHITE);
        loadedStatus.setFont(buttonFont);

        loadedPanel.add(loadedStatus);
        con.add(loadedPanel);


        con.add(buttonPanel);
        con.repaint();

    }

    @Override
    public void updateVisibility(boolean newValue) {
        super.updateVisibility(newValue);
        adventureLogoPanel.setVisible(visibility);
        buttonPanel.setVisible(visibility);
        loadedPanel.setVisible(visibility);
        loadedStatus.setText("");

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
    public class LoadGameButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            loadGame();

        }
    }
    public class ContinueButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private void loadGame() {
        try {
            Scanner scnr = new Scanner(new File("savefile2.txt"));
            String type = scnr.next();
            if(type.equals("Rogue")){
                player = new Rogue();
            }
            else if(type.equals("Wizard")){
                player = new Wizard();
            }
            else{
                player = new Fighter();
            }
            player.name = scnr.next();
            player.stats.put("Strength", scnr.nextInt());
            player.stats.put("Dexterity", scnr.nextInt());
            player.stats.put("Constitution", scnr.nextInt());
            player.stats.put("Intelligence", scnr.nextInt());
            player.stats.put("Wisdom", scnr.nextInt());
            player.stats.put("Charisma", scnr.nextInt());
            player.setCurrentHp(scnr.nextInt());
            //need setters for setMaxHP and Name
            loadedStatus.setText("LOADED " + player.getName() + " SUCCESSFULLY!");
            scnr.close();
            con.repaint();
        } catch(FileNotFoundException e) {
            loadedStatus.setText(e.toString());
            con.repaint();
        }
    }
}
