import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;

public class BossRoom extends Screen{
    JButton fightButton, fleeButton, nextRoomButton, continueButton;
    FightButtonHandler fbHandler = new FightButtonHandler();
    NextRoomHandler nrHandler = new NextRoomHandler();
    ContinueButtonHandler continueHandler = new ContinueButtonHandler();
    int displayTextCount;
    public BossRoom(String type, Container container, GameManager game) {
        super(type,container,game);
        hasCombat = true;
        combatDone = false;
        monsters = new LinkedList<GameCharacter>();
        monsters.add(new Princess());
        displayTextCount = 0;

        textMap = new HashMap<Integer,String>();
        textMap.put(0,"As you enter the boss chamber, you notice that there is no one present. " +
                "All that resides inside is an empty throne covered in gold. Unexpectedly, the chamber door closes itself " +
                        "behind you, locking in place, barring your escape. " +
                        "The room goes dark. Footsteps are heard in the distance. ");
        textMap.put(1,"???: \"I see that you've been able to best all my minions.\" a voice calls out from the darkness." +
                "\n\nYou: \"Who goes there? Show yourself! Where's the Princess?\"" +
                "\n\n???: \"Where is she? She is right here.\"");
        textMap.put(2,"The room goes bright again. Sitting on the throne is none other than Princess Gertrude with a wry smile." +
                "\n\nYou: \"What's going on here? Your father sent me here to save you!\"" +
                "\n\nPrincess Gertrude: \"I'll tell you if you manage to defeat me!\"" +
                "\n\nShe leaps out of the throne and rushes towards you, drawing a sinister blade.");
        if (!combatDone) {
            updateText("You enter a small chamber at the end of this cave. You see a woman with " +
                    "brown hair who smiles at you warmly. She looks a bit distraught.\n" +
                    "\"Thank you so much for saving me from those horrible Goblins! We should get out of here quickly!\" she says." +
                    "\nYou agree, turning your back to leave this accursed, musty cave. Suddenly, you hear quick movement from behind " +
                    "you! You turn just in time to see the woman lunge at you with a wicked dagger in her hand!\n" +
                    "\"You fool!\" she screams, \"You'll pay for what you've done! Those were MY minions!\"");
            updateText(textMap.get(0));
            displayTextCount++;
            continueButton = new JButton("CONTINUE");
            continueButton.setBackground(Color.BLACK);
            continueButton.setForeground(Color.WHITE);
            continueButton.setFont(buttonFont);
            continueButton.setFocusPainted(false);
            mainButtonPanel.add(continueButton);
            continueButton.addActionListener(continueHandler);
        }
        else{
            updateAfterVictory();
        }
    }
    public void updateVisibility(boolean newValue) {
        visibility = newValue;
        mainTextBoxPanel.setVisible(visibility);
        mainButtonPanel.setVisible(visibility);
    }
    public class NextRoomHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            updateVisibility(false);
            game.changeScreen("victoryScreen");
        }
    }
    public class ContinueButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(textMap.containsKey(displayTextCount)){
                updateText(textMap.get(displayTextCount));
                displayTextCount++;
            }
            if(displayTextCount == 3) {
                mainButtonPanel.remove(continueButton);
                fightButton = new JButton("FIGHT FOR YOUR LIFE");
                fightButton.setBackground(Color.BLACK);
                fightButton.setForeground(Color.WHITE);
                fightButton.setFont(buttonFont);
                fightButton.setFocusPainted(false);
                fightButton.addActionListener(fbHandler);
                mainButtonPanel.add(fightButton);
            }
        }
    }
    public void updateAfterVictory() {
        combatDone = true;
        mainButtonPanel.removeAll();
        updateText("\t\tWell that was awkward.\n\n" +
                "Will you return to the King and relay the unfortunate news? " +
                "Who knows if they'll believe you. . .");
        fleeButton = new JButton("FLEE THE KINGDOM");
        fleeButton.setBackground(Color.BLACK);
        fleeButton.setForeground(Color.WHITE);
        fleeButton.setFont(buttonFont);
        fleeButton.setFocusPainted(false);
        fleeButton.addActionListener(ccHandler);
        mainButtonPanel.add(fleeButton);

        nextRoomButton = new JButton("RETURN TO KING");
        nextRoomButton.setBackground(Color.BLACK);
        nextRoomButton.setForeground(Color.WHITE);
        nextRoomButton.setFont(buttonFont);
        nextRoomButton.setFocusPainted(false);
        nextRoomButton.addActionListener(nrHandler);
        mainButtonPanel.add(nextRoomButton);
    }

    @Override
    public void updateCombatButtons(boolean b) {
        if(b) {
            fightButton.setText("CONTINUE");
        }
    }
}
