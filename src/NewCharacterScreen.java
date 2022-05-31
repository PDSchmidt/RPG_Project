import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class NewCharacterScreen extends Screen{
    String chosenTypeLabel = "";
    JPanel testPanel,testButtonPanel;
    JLabel testLabel;
    JButton testButton, wizardButton, rogueButton, fighterButton;
    BackButtonHandler bbHandler = new BackButtonHandler();
    FighterButtonHandler fbHandler = new FighterButtonHandler();
    RogueButtonHandler rbHandler = new RogueButtonHandler();
    WizardButtonHandler wbHandler = new WizardButtonHandler();
    public NewCharacterScreen(String type,Container container, GameManager game) {
        super(type,container,game);
        hasCombat = false;
        combatDone = false;
        visibility = false;

        testPanel = new JPanel();
        testPanel.setBounds(100,100,1080,200);
        testPanel.setBackground(Color.BLUE);
        con.add(testPanel);

        testLabel = new JLabel();
        testLabel.setBackground(Color.RED);
        testLabel.setForeground(Color.WHITE);
        testLabel.setFont(buttonFont);
        testLabel.setText("Choose your player: " + chosenTypeLabel);
        testPanel.add(testLabel);

        testButtonPanel = new JPanel();
        testButtonPanel.setBounds(440,400,400,200);
        testButtonPanel.setBackground(Color.RED);
        testButtonPanel.setLayout(new GridLayout(4,1));
        con.add(testButtonPanel);


        //Wizard
        wizardButton = new JButton("WIZARD");
        wizardButton.setBackground(Color.BLACK);
        wizardButton.setForeground(Color.WHITE);
        wizardButton.setFont(buttonFont);
        wizardButton.setFocusPainted(false);
        //action listener
        wizardButton.addActionListener(wbHandler);
        testButtonPanel.add(wizardButton);

        //Rogue
        rogueButton = new JButton("ROGUE");
        rogueButton.setBackground(Color.BLACK);
        rogueButton.setForeground(Color.WHITE);
        rogueButton.setFont(buttonFont);
        rogueButton.setFocusPainted(false);
        //action listener
        rogueButton.addActionListener(rbHandler);
        testButtonPanel.add(rogueButton);

        //Fighter
        fighterButton = new JButton("FIGHTER");
        fighterButton.setBackground(Color.BLACK);
        fighterButton.setForeground(Color.WHITE);
        fighterButton.setFont(buttonFont);
        fighterButton.setFocusPainted(false);
        //action listener
        fighterButton.addActionListener(fbHandler);
        testButtonPanel.add(fighterButton);

        testButton = new JButton("BACK");
        testButton.setBackground(Color.BLACK);
        testButton.setForeground(Color.WHITE);
        testButton.setFont(buttonFont);
        testButton.setFocusPainted(false);
        //action listener
        testButton.addActionListener(bbHandler);
        testButtonPanel.add(testButton);


        testPanel.setVisible(false);
        testButtonPanel.setVisible(false);

    }

    @Override
    public void updateVisibility(boolean newValue) {
        visibility = newValue;
        testPanel.setVisible(visibility);
        testButtonPanel.setVisible(visibility);

    }
    public class BackButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            updateVisibility(false);
            game.changeScreen("titleScreen");
        }
    }
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
}
