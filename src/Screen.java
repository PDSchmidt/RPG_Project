import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Screen {
    GameManager game;
    String screenType;
    boolean hasCombat, combatDone, visibility = false;
    Queue<Character> monsters;
    GameCharacter player;
    Container con;
    //Fonts for all screens to access
    Font buttonFont = new Font("Times New Roman", Font.PLAIN, 24);

    public Screen(){

    }
    public Screen(String type, Container container, GameManager game){
        this.game = game;
        screenType= type;
        con = container;
        /*if(type.equals("titleScreen")){
            //make titlescreen
        }
        else if(type.equals("villageScreen")){
            //make villageScreen
        }
        else if(type.equals("dungeonEntrance")){
            //make dungeonEntrance
        }
        else if(type.equals("roomOne")){
            //make roomOne
        }
        else if(type.equals("roomTwo")){
            //make roomTwo
        }
        else if(type.equals("roomThree")){
            //make roomThree
        }
        else if(type.equals("bossRoom")){
            //make bossRoom
        }
        else if(type.equals("newCharacterScreen")){
            //make newCharacterScreen
        }
        else{
            //make loadCharacterScreen
        }*/
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

    }
    public void updateVisibility(boolean newValue){
        visibility = newValue;
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
