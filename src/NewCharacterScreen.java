import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
public class NewCharacterScreen extends Screen{
    String chosenTypeLabel = "";
    JPanel textDisplayPanel, optionButtonPanel, startAdventurePanel;
    JLabel testLabel;

    JTextField nameField;
    JButton backButton,createButton, wizardButton, rogueButton, fighterButton, startAdventureButton;
    BackButtonHandler bbHandler = new BackButtonHandler();
    FighterButtonHandler fbHandler = new FighterButtonHandler();
    RogueButtonHandler rbHandler = new RogueButtonHandler();
    WizardButtonHandler wbHandler = new WizardButtonHandler();
    CreateButtonHandler cbHandler = new CreateButtonHandler();
    StartAdventureHandler saHandler = new StartAdventureHandler();
    public NewCharacterScreen(String type,Container container, GameManager game) {
        super(type,container,game);
        hasCombat = false;
        combatDone = false;
        visibility = false;

        textDisplayPanel = new JPanel();
        textDisplayPanel.setBounds(100,100,1080,200);
        textDisplayPanel.setBackground(Color.BLACK);
        textDisplayPanel.setLayout(new GridLayout(2,1));
        con.add(textDisplayPanel);

        testLabel = new JLabel();
        testLabel.setBackground(Color.BLACK);
        testLabel.setForeground(Color.WHITE);
        testLabel.setFont(buttonFont);
        testLabel.setText("Choose your player: " + chosenTypeLabel);
        textDisplayPanel.add(testLabel);

        nameField = new JTextField("Enter your character's name here");
        nameField.setBackground(Color.BLACK);
        nameField.setForeground(Color.WHITE);
        nameField.setFont(buttonFont);
        textDisplayPanel.add(nameField);

        optionButtonPanel = new JPanel();
        optionButtonPanel.setBounds(440,400,400,200);
        optionButtonPanel.setBackground(Color.RED);
        optionButtonPanel.setLayout(new GridLayout(5,1));
        con.add(optionButtonPanel);

        //Wizard
        wizardButton = new JButton("WIZARD");
        wizardButton.setBackground(Color.BLACK);
        wizardButton.setForeground(Color.WHITE);
        wizardButton.setFont(buttonFont);
        wizardButton.setFocusPainted(false);
        wizardButton.addActionListener(wbHandler);
        optionButtonPanel.add(wizardButton);

        //Rogue
        rogueButton = new JButton("ROGUE");
        rogueButton.setBackground(Color.BLACK);
        rogueButton.setForeground(Color.WHITE);
        rogueButton.setFont(buttonFont);
        rogueButton.setFocusPainted(false);
        rogueButton.addActionListener(rbHandler);
        optionButtonPanel.add(rogueButton);

        //Fighter
        fighterButton = new JButton("FIGHTER");
        fighterButton.setBackground(Color.BLACK);
        fighterButton.setForeground(Color.WHITE);
        fighterButton.setFont(buttonFont);
        fighterButton.setFocusPainted(false);
        fighterButton.addActionListener(fbHandler);
        optionButtonPanel.add(fighterButton);

        //Create Button
        createButton = new JButton("CREATE");
        createButton.setBackground(Color.BLACK);
        createButton.setForeground(Color.WHITE);
        createButton.setFont(buttonFont);
        createButton.setFocusPainted(false);
        createButton.addActionListener(cbHandler);
        optionButtonPanel.add(createButton);

        //Back Button
        backButton = new JButton("BACK");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(buttonFont);
        backButton.setFocusPainted(false);
        backButton.addActionListener(bbHandler);
        optionButtonPanel.add(backButton);

        startAdventurePanel = new JPanel();
        startAdventurePanel.setBounds(880,475,300,50);
        startAdventurePanel.setBackground(Color.RED);
        startAdventurePanel.setLayout(new GridLayout(1,1));
        con.add(startAdventurePanel);

        startAdventureButton = new JButton("START ADVENTURE");
        startAdventureButton.setBackground(Color.BLACK);
        startAdventureButton.setForeground(Color.WHITE);
        startAdventureButton.setFont(buttonFont);
        startAdventureButton.setFocusPainted(false);
        startAdventureButton.addActionListener(saHandler);
        startAdventurePanel.add(startAdventureButton);

        textDisplayPanel.setVisible(false);
        optionButtonPanel.setVisible(false);
        startAdventurePanel.setVisible(false);

    }

    @Override
    public void updateVisibility(boolean newValue) {
        chosenTypeLabel = "";
        testLabel.setText("Choose your player: " + chosenTypeLabel);
        nameField.setText("Enter your character's name here");
        con.repaint();
        visibility = newValue;
        textDisplayPanel.setVisible(visibility);
        optionButtonPanel.setVisible(visibility);
        startAdventurePanel.setVisible(false);
        if(game.newCharacterCreated)
            startAdventurePanel.setVisible(visibility);

    }
    public class BackButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            game.player = null;
            updateVisibility(false);
            game.changeScreen("titleScreen");
        }
    }
    //Sets the chosenTypeLabel to the class the character is choosing
    public class WizardButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            chosenTypeLabel = "Wizard";
            testLabel.setText("Choose your player: " + chosenTypeLabel);
            con.repaint();
        }
    }
    public class FighterButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            chosenTypeLabel = "Fighter";
            testLabel.setText("Choose your player: " + chosenTypeLabel);
            con.repaint();
        }
    }
    public class RogueButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            chosenTypeLabel = "Rogue";
            testLabel.setText("Choose your player: " + chosenTypeLabel);
            con.repaint();
        }
    }
    //Uses the nameField and chosenTypeLabel to create the appropriate Object with the chosen character's name
    public class CreateButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(chosenTypeLabel.equals("Rogue")){
                game.player = new Rogue(nameField.getText());
                testLabel.setText("You created a Rogue! Their name is: " + game.player.getName());
                game.newCharacterCreated = true;
            }
            else if(chosenTypeLabel.equals("Wizard")){
                game.player = new Wizard(nameField.getText());
                testLabel.setText("You created a Wizard! Their name is: " + game.player.getName());
                game.newCharacterCreated = true;
            }
            else if(chosenTypeLabel.equals("Fighter")){
                game.player = new Fighter(nameField.getText());
                testLabel.setText("You created a Fighter! Their name is: " + game.player.getName());
                game.newCharacterCreated = true;
            }
            else{

            }
            if(game.newCharacterCreated)
                startAdventurePanel.setVisible(true);


        }
    }
    public class StartAdventureHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            updateVisibility(false);
            Screen villageScreen = new VillageScreen("villageScreen", con, game);
            game.screens.put("villageScreen",villageScreen);
            game.changeScreen("villageScreen");

        }
    }
}
