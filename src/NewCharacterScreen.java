import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class NewCharacterScreen extends Screen{
    JPanel testPanel,testButtonPanel;
    JLabel testLabel;
    JButton testButton, wizardButton, rogueButton, fighterButton;
    BackButtonHandler bbHandler = new BackButtonHandler();
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
        testLabel.setText("TESTING");
        testPanel.add(testLabel);

        testButtonPanel = new JPanel();
        testButtonPanel.setBounds(440,400,400,200);
        testButtonPanel.setBackground(Color.RED);
        testButtonPanel.setLayout(new GridLayout(4,1));
        con.add(testButtonPanel);

        testButton = new JButton("BACK");
        testButton.setBackground(Color.BLACK);
        testButton.setForeground(Color.WHITE);
        testButton.setFont(buttonFont);
        testButton.setFocusPainted(false);
        //action listener
        testButton.addActionListener(bbHandler);
        testButtonPanel.add(testButton);

        //Wizard
        wizardButton = new JButton("WIZARD");
        wizardButton.setBackground(Color.BLACK);
        wizardButton.setForeground(Color.WHITE);
        wizardButton.setFont(buttonFont);
        wizardButton.setFocusPainted(false);
        //action listener
        wizardButton.addActionListener(bbHandler);
        testButtonPanel.add(wizardButton);

        //Rogue
        rogueButton = new JButton("ROGUE");
        rogueButton.setBackground(Color.BLACK);
        rogueButton.setForeground(Color.WHITE);
        rogueButton.setFont(buttonFont);
        rogueButton.setFocusPainted(false);
        //action listener
        rogueButton.addActionListener(bbHandler);
        testButtonPanel.add(rogueButton);

        //Fighter
        fighterButton = new JButton("FIGHTER");
        fighterButton.setBackground(Color.BLACK);
        fighterButton.setForeground(Color.WHITE);
        fighterButton.setFont(buttonFont);
        fighterButton.setFocusPainted(false);
        //action listener
        fighterButton.addActionListener(bbHandler);
        testButtonPanel.add(fighterButton);


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
}
