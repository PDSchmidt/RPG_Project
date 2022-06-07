import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class RoomThree extends Screen{
    JButton retreatButton, fightButton, campButton, nextRoomButton;
    CampButtonHandler cbHandler = new CampButtonHandler();
    FightButtonHandler fbHandler = new FightButtonHandler();
    NextRoomHandler nrHandler = new NextRoomHandler();
    public RoomThree(String type, Container container, GameManager game) {
        super(type,container,game);
        hasCombat = true;
        combatDone = false;
        monsters = new LinkedList<GameCharacter>();
        monsters.add(new HobGoblin());
        monsters.add(new HobGoblin());
        monsters.add(new HobgoblinCaptain());
        if (!combatDone) {
            updateText("Haggard, but not dissuaded by the challenges thus far, you press forward." +
                    "\nA larger room lays just ahead. As the flames illuminate this room, " + monsters.size() + " " +
                    monsters.peek().getCharacterType() + "s leap from the shadows!\n\n" +
                    "\"Rrrrrroooaaagggghhhh!\" They attack!");
            retreatButton = new JButton("RETREAT TO CAVE ENTRANCE");
            retreatButton.setBackground(Color.BLACK);
            retreatButton.setForeground(Color.WHITE);
            retreatButton.setFont(buttonFont);
            retreatButton.setFocusPainted(false);
            retreatButton.addActionListener(cbHandler);
            mainButtonPanel.add(retreatButton);

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
            game.changeScreen("bossRoom");
        }
    }
    public void updateAfterVictory() {
        combatDone = true;
        mainButtonPanel.removeAll();
        updateText("You defeated the monsters in this third room. With the Hobgoblin Captain defeated, " +
                "surely your task is nearly complete. Lights flicker from the adjacent room and you are sure that you " +
                "hear the sound of a woman's voice from within. Dare you to venture forth? Or will you return to" +
                " to camp to rest and recoup?");
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
