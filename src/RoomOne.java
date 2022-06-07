import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class RoomOne extends Screen{
    JButton retreatButton, fightButton, campButton, nextRoomButton;
    CampButtonHandler cbHandler = new CampButtonHandler();
    FightButtonHandler fbHandler = new FightButtonHandler();
    NextRoomHandler nrHandler = new NextRoomHandler();
    public RoomOne(String type, Container container, GameManager game) {
        super(type,container, game);
        hasCombat = true;
        combatDone = false;
        monsters = new LinkedList<GameCharacter>();
        monsters.add(new Goblin());
        monsters.add(new Goblin());
        monsters.add(new Goblin());
        if(!combatDone){
            updateText("You muster the strength to enter the cave. The inside is musty and pitch black. " +
                    "\nYou light a torch. As the flames illuminate this room, " + monsters.size() + " " +
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

    @Override
    public void updateVisibility(boolean newValue) {
        visibility = newValue;
        mainTextBoxPanel.setVisible(visibility);
        mainButtonPanel.setVisible(visibility);
    }
    public class NextRoomHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            updateVisibility(false);
            game.changeScreen("roomTwo");
        }
    }

    @Override
    public void updateAfterVictory() {
        combatDone = true;
        mainButtonPanel.removeAll();
        updateText("You defeated the monsters in this room. Dare you to venture forth? Or will you return to" +
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
