import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class GameManager {
    GameCharacter player;
    Map<String,Screen> screens;
    JFrame mainWindow;
    Container con;
    boolean cowardEnding, newCharacterCreated;
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    {
                        GameManager game = new GameManager();
                    }
                } catch (Exception e) {

                }
            }

        });

    }
    public GameManager(){
        //Create main window
        mainWindow = new JFrame();
        mainWindow.setSize(1280,720);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.getContentPane().setBackground(Color.BLACK);
        mainWindow.setLayout(null);
        con = mainWindow.getContentPane();

        //Build different screens in game
        screens = new HashMap<>();
        Screen titleScreen = new TitleScreen("titleScreen", con, this);
        screens.put("titleScreen", titleScreen);
        Screen dungeonEntrance = new DungeonEntrance("dungeonEntrance", con, this);
        screens.put("dungeonEntrance",dungeonEntrance);
        Screen roomOne = new RoomOne("roomOne", con, this);
        screens.put("roomOne", roomOne);
        Screen roomTwo = new RoomTwo("roomTwo", con, this);
        screens.put("roomTwo", roomTwo);
        Screen roomThree = new RoomThree("roomThree", con, this);
        screens.put("roomThree", roomThree);
        Screen bossRoom = new BossRoom("bossRoom", con, this);
        screens.put("bossRoom", bossRoom);
        Screen newCharacterScreen = new NewCharacterScreen("newCharacterScreen",con, this);
        screens.put("newCharacterScreen",newCharacterScreen);
        Screen creditScreen = new CreditScreen("creditScreen", con, this);
        screens.put("creditScreen",creditScreen);
        Screen victoryScreen = new VictoryScreen("victoryScreen", con, this);
        screens.put("victoryScreen",victoryScreen);

        //Turn on window, seting the TitleScreen to be the first Screen visible
        titleScreen.updateVisibility(true);
        mainWindow.setVisible(true);
        con.repaint();


    }
    //Public method that other screens/action listeners can call to tell the GameManager to turn the GUI on of a specific Screen
    public void changeScreen(String displayScreen){
        screens.get(displayScreen).updateVisibility(true);
    }
    //Saves the gamestate of the player's character and whether the rooms with combat are cleared or not
    public void saveGame(){
        try{
            FileWriter writer = new FileWriter("savefile3.txt",false);
            writer.write(player.getCharacterType() + "\n");
            writer.write(player.getName() + "\n");
            //writer.write("" + player.getSpecificStat("Strength") + "\n");
            //writer.write("" + player.getSpecificStat("Dexterity") + "\n");
            //writer.write("" + player.getSpecificStat("Constitution") + "\n");
            //writer.write("" + player.getSpecificStat("Intelligence") + "\n");
            //writer.write("" + player.getSpecificStat("Wisdom") + "\n");
            //writer.write("" + player.getSpecificStat("Charisma") + "\n");
            writer.write("" + player.getCurrentHP() + "\n");
            //writer.write("" + player.getMaxHp());
            writer.write("" + screens.get("roomOne").combatDone + "\n");
            writer.write("" + screens.get("roomTwo").combatDone + "\n");
            writer.write("" + screens.get("roomThree").combatDone + "\n");
            writer.write("" + screens.get("bossRoom").combatDone + "\n");
            writer.flush();
            writer.close();

        }
        catch(Exception e){

        }
    }


}
