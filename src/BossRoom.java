import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class BossRoom extends Screen{
    JButton fightButton, campButton, nextRoomButton;
    CampButtonHandler cbHandler = new CampButtonHandler();
    FightButtonHandler fbHandler = new FightButtonHandler();
    NextRoomHandler nrHandler = new NextRoomHandler();
    public BossRoom(String type, Container container, GameManager game) {
        super(type,container,game);
        hasCombat = true;
        combatDone = false;
        monsters = new LinkedList<GameCharacter>();
        monsters.add(new Princess());
        if (!combatDone) {
            updateText("You enter a small chamber at the end of this cave. You see a woman with " +
                    "brown hair who smiles at you warmly. She looks a bit distraught.\n" +
                    "\"Thank you so much for saving me from those horrible Goblins! We should get out of here quickly!\" she says." +
                    "\nYou agree, turning your back to leave this accursed, musty cave. Suddenly, you hear quick movement from behind " +
                    "you! You turn just in time to see the woman lunge at you with a wicked dagger in her hand!\n" +
                    "\"You fool!\" she screams, \"You'll pay for what you've done! Those were MY minions!\"");


            fightButton = new JButton("FIGHT FOR YOUR LIFE");
            fightButton.setBackground(Color.BLACK);
            fightButton.setForeground(Color.WHITE);
            fightButton.setFont(buttonFont);
            fightButton.setFocusPainted(false);
            fightButton.addActionListener(fbHandler);
            mainButtonPanel.add(fightButton);
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
    public void updateAfterVictory() {
        combatDone = true;
        mainButtonPanel.removeAll();
        updateText("\t\tWell that was awkward");
        campButton = new JButton("RETURN TO CAMP");
        campButton.setBackground(Color.BLACK);
        campButton.setForeground(Color.WHITE);
        campButton.setFont(buttonFont);
        campButton.setFocusPainted(false);
        campButton.addActionListener(cbHandler);
        mainButtonPanel.add(campButton);

        nextRoomButton = new JButton("VENTURE FORTH");
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
