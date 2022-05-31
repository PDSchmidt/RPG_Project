import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class NewCharacterScreen extends Screen{
    JPanel testPanel,testButtonPanel;
    JLabel testLabel;
    JButton testButton;
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
        con.add(testButtonPanel);

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
}
