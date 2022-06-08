import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
public class VillageScreen extends Screen{
    int displayTextCount;
    JButton continueButton;

    ContinueButtonHandler cbHandler = new ContinueButtonHandler();

    public VillageScreen(String type, Container container, GameManager game) {
        super(type,container,game);
        displayTextCount = 0;

        continueButton = new JButton("CONTINUE");
        continueButton.setBackground(Color.BLACK);
        continueButton.setForeground(Color.WHITE);
        continueButton.setFont(buttonFont);
        continueButton.setFocusPainted(false);
        mainButtonPanel.add(continueButton);
        continueButton.addActionListener(cbHandler);

        textMap = new HashMap<Integer,String>();

        textMap.put(0,"   You are relaxing in a pub in the center of the village." +
                " Suddenly, the captain of the guard rushes in with a group of soldiers.\n\n" +
                "\"Alas! We are seeking help from a qualified adventurer!\"" +
                "\n\n\"I am a wandering " + game.player.characterType + ".\" you say to the Captain." +
                " \"My name is " + game.player.name + ".\"" +
                "\n\n\"Really? That's fantastic!\" he responds. \"The King is in dire need of your assistance. Please Follow us" +
                " to the castle.\"");
        textMap.put(1,"   You make your way to the castle and are brought to the throne room where the King greets you. " +
                "He looks distraught, a sense of panic is in the air." +
                "\n\"Greetings " + game.player.characterType + ", my daughter is in grave danger. She has been kidnapped" +
                " by a group of bandits and monsters! They have fled to a cave outside of town. You must sav her from them!\"" +
                "\n   Her name is Gertrude. She has brown hair and is as sweet as can be. Will you help rescue her? I mu" +
                "st warn you, this is a dangerous task, but you will be rewarded handsomely!\"" +
                "\n\n   You weigh your options carefully, what will you do?");
        textMap.put(2,"   The King looks relieved that you are willing to take on this quest." +
                "\n\n   \"Excellent! The Captain will escort you to the cave entrance. Best of luck on your journey. Now " +
                "go and please save my daughter!\" he exclaims. \n\n   The Captain of the guard beckons you to follow and guides you " +
                "outside of town to the entrance of a foreboding cave...");
        updateText(textMap.get(displayTextCount));
        displayTextCount++;
    }

    @Override
    public void updateVisibility(boolean newValue) {
        super.updateVisibility(newValue);
        mainTextBoxPanel.setVisible(visibility);
        mainButtonPanel.setVisible(visibility);
    }
    public class ContinueButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(textMap.containsKey(displayTextCount)){
                updateText(textMap.get(displayTextCount));
                displayTextCount++;
            }
            if(displayTextCount == 2){
                CreditScreenHandler csHandler = new CreditScreenHandler();
                mainButtonPanel.remove(continueButton);
                JButton noButton = new JButton("Refuse");
                noButton.setBackground(Color.BLACK);
                noButton.setForeground(Color.WHITE);
                noButton.setFont(buttonFont);
                noButton.setFocusPainted(false);
                noButton.addActionListener(csHandler);
                JButton yesButton = new JButton("Accept");
                yesButton.setBackground(Color.BLACK);
                yesButton.setForeground(Color.WHITE);
                yesButton.setFont(buttonFont);
                yesButton.setFocusPainted(false);
                yesButton.addActionListener(cbHandler);
                mainButtonPanel.add(noButton);
                mainButtonPanel.add(yesButton);
            }
            else if(displayTextCount == 3){
                mainButtonPanel.removeAll();
                mainButtonPanel.add(continueButton);
                con.repaint();
                displayTextCount++;
            }
            else if(displayTextCount == 4){
                updateVisibility(false);
                game.changeScreen("dungeonEntrance");
            }
            else{}
        }
    }
}
