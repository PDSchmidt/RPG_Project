import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Screen {
    GameManager game;
    String screenType,defaultText;
    boolean hasCombat, combatDone, visibility = false;
    Queue<GameCharacter> monsters;
    Container con;
    //Fonts for all screens to access
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 24);
    Font mainTextFont = new Font("Times New Roman", Font.PLAIN, 32);

    JPanel mainTextBoxPanel,mainButtonPanel;
    JTextArea mainText;
    Map<Integer,String> textMap;
    JButton cowardCreditsButton, continueCombatButton;
    CowardCreditScreenHandler ccHandler = new CowardCreditScreenHandler();


    public Screen(){
    }
    public Screen(String type, Container container, GameManager game){
        this.game = game;
        screenType= type;
        con = container;

        mainTextBoxPanel = new JPanel();
        mainTextBoxPanel.setBounds(100,100,1080,400);
        mainTextBoxPanel.setBackground(Color.BLACK);
        mainTextBoxPanel.setForeground(Color.WHITE);
        mainTextBoxPanel.setLayout(new GridLayout(1,1));
        mainTextBoxPanel.setVisible(false);

        mainText = new JTextArea("");
        mainText.setBackground(Color.BLACK);
        mainText.setForeground(Color.WHITE);
        mainText.setFont(mainTextFont);
        mainText.setWrapStyleWord(true);
        mainText.setLineWrap(true);
        mainText.setEditable(false);
        mainTextBoxPanel.add(mainText);
        con.add(mainTextBoxPanel);

        mainButtonPanel = new JPanel();
        mainButtonPanel.setBounds(100,525,1080,50);
        mainButtonPanel.setBackground(Color.RED);
        mainButtonPanel.setForeground(Color.WHITE);
        mainButtonPanel.setLayout(new GridLayout(1,5));
        mainButtonPanel.setVisible(false);

        con.add(mainButtonPanel);
    }
    public void updateText(String newText){
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                mainText.setText(newText);
            }
        });

    }
    public void updateVisibility(boolean newValue){
        visibility = newValue;
    }
    //method for managing combat in a Screen using the game.player and the QUEUE associated with each Screen
    public void doCombat() throws InterruptedException {
        updateCombatButtons(true);
        con.repaint();
        con.revalidate();
        if(!combatDone && game.player.getCurrentHP() > 0){
            String result = game.player.attack(monsters.peek()) + "\n";
            con.repaint();
            if(monsters.peek().getCurrentHP() > 0){
                monsters.add(monsters.remove());
            }
            else{
                monsters.remove();
            }
            if(monsters.isEmpty()) {
                combatDone = true;
                updateAfterVictory();
                return;
            }
            for(GameCharacter monster : monsters){
                result += monster.attack(game.player) + "\n";
                if(game.player.getCurrentHP() <= 0){
                    updateText("The challenge was too great for you. . . you were defeated.");
                    mainButtonPanel.removeAll();
                    cowardCreditsButton = new JButton("SHAME");
                    cowardCreditsButton.setFocusPainted(false);
                    cowardCreditsButton.setForeground(Color.WHITE);
                    cowardCreditsButton.setBackground(Color.BLACK);
                    cowardCreditsButton.setFont(buttonFont);
                    cowardCreditsButton.addActionListener(ccHandler);
                    mainButtonPanel.add(cowardCreditsButton);
                }
            }
            updateText(result);
        }
    }
    public void updateCombatButtons(boolean b) {
    }

    public void updateAfterVictory(){
    }
    public class CowardCreditScreenHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            game.cowardEnding = true;
            updateVisibility(false);
            game.changeScreen("creditScreen");
        }
    }
    public class CreditScreenHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            game.cowardEnding = false;
            updateVisibility(false);
            game.changeScreen("creditScreen");
        }
    }
    public class CampButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            updateVisibility(false);
            game.changeScreen("dungeonEntrance");
        }
    }
    public class FightButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                doCombat();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
