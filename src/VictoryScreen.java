import javax.swing.*;
import java.awt.*;

public class VictoryScreen extends Screen{
    JButton continueButton;
    CreditScreenHandler csHandler = new CreditScreenHandler();
    public VictoryScreen(String type, Container container, GameManager game){
        super(type,container,game);
        hasCombat = false;
        combatDone = true;
        updateText("Unsure of how the news of the Princess's betrayal and demise will be received, you return to the King." +
                "\n\n\n\t\tKing: \"YOU DID WHAT?!?!?!\"" +
                "\n\nNo matter what you say, no matter how you plead, the King will have none of it. You are thrown in to a dungeon" +
                " for the rest of your life." +
                "\n\nBut at least you have your dignity. . . ");
        continueButton = new JButton("CONTINUE");
        continueButton.setBackground(Color.BLACK);
        continueButton.setForeground(Color.WHITE);
        continueButton.setFont(buttonFont);
        continueButton.setFocusPainted(false);
        mainButtonPanel.add(continueButton);
        continueButton.addActionListener(csHandler);
    }
    public void updateVisibility(boolean newValue) {
        visibility = newValue;
        mainTextBoxPanel.setVisible(visibility);
        mainButtonPanel.setVisible(visibility);
    }
}
