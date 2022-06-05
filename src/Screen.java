import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Screen {
    GameManager game;
    String screenType,defaultText;
    boolean hasCombat, combatDone, visibility = false;
    Queue<Character> monsters;
    Container con;
    //Fonts for all screens to access
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 24);
    Font mainTextFont = new Font("Times New Roman", Font.PLAIN, 32);

    JPanel mainTextBoxPanel,mainButtonPanel;
    JTextArea mainText;
    Map<Integer,String> textMap;

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
    public void doCombat(){
        //Create Que of player + monsters
        //while combat not done
            //cycle through
                //if this player, attack creature
                    //if creature dead, combatDone = true

                //else this creature, attack player
                    //if player dead, back to village

    }
    public void updateText(String newText){
        mainText.setText(newText);
    }
    public void setDefaultText(){
        mainText.setText(defaultText);
    }
    public void updateVisibility(boolean newValue){
        visibility = newValue;
    }
    public class CreditScreenHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            updateVisibility(false);
            game.changeScreen("creditScreen");
        }
    }


}


/*//GameManager GUI
CLICK BUTTON()
    createCharacter("Name", "Choice"){

        if("Choice".equals("Rogue")){
            Character player = new Rogue("Name")
        }
        else if("Choice".equals("Cleric")){
            Character player = new Cleric("Name")
        }
        else if("Choice".equals("Wizard")){
            Character player = new Wizard("Name")
        }
}

public wizard("Name"){
    //Create with specific stats and name
}*/
