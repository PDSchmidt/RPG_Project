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

        continuePanel = new JPanel();
        continuePanel.setBounds(880,475,300,50);
        continuePanel.setBackground(Color.RED);
        continuePanel.setLayout(new GridLayout(1,1));
        con.add(continuePanel);

        continueButton = new JButton("CONTINUE");
        continueButton.setBackground(Color.BLACK);
        continueButton.setForeground(Color.WHITE);
        continueButton.setFont(buttonFont);
        continueButton.setFocusPainted(false);
        //action listener
        continueButton.addActionListener(cbHandler);
        continuePanel.add(continueButton);
        con.add(continuePanel);
        con.repaint();

    }

    @Override
    public void updateVisibility(boolean newValue) {
        super.updateVisibility(newValue);
        adventureLogoPanel.setVisible(visibility);
        buttonPanel.setVisible(visibility);
        loadedPanel.setVisible(visibility);
        loadedStatus.setText("");
        if(game.player != null)
            continuePanel.setVisible(visibility);
        else
            continuePanel.setVisible(false);

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
                game.player = new Rogue();
            }
            else if(type.equals("Wizard")){
                game.player = new Wizard();
            }
            else{
                game.player = new Fighter();
            }
            game.player.name = scnr.next();
            game.player.stats.put("Strength", scnr.nextInt());
            game.player.stats.put("Dexterity", scnr.nextInt());
            game.player.stats.put("Constitution", scnr.nextInt());
            game.player.stats.put("Intelligence", scnr.nextInt());
            game.player.stats.put("Wisdom", scnr.nextInt());
            game.player.stats.put("Charisma", scnr.nextInt());
            game.player.setCurrentHp(scnr.nextInt());
            //need setters for setMaxHP and Name
            loadedStatus.setText("LOADED " + game.player.getName() + " SUCCESSFULLY!");
            scnr.close();

            continuePanel.setVisible(true);
            con.repaint();
        } catch(FileNotFoundException e) {
            loadedStatus.setText(e.toString());
            con.repaint();
        }
    }
}
