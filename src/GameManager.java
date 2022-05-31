import java.util.*;
import javax.swing.*;
import java.awt.*;

public class GameManager {
    Character player;
    Map<String,Screen> screens;
    JFrame mainWindow;
    Container con;
    public static void main(String[] args){
        GameManager game = new GameManager();
    }
    public void updateDisplayText(String newText){

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
        Screen villageScreen = new VillageScreen("villageScreen", con, this);
        screens.put("villageScreen",villageScreen);
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
        Screen loadCharacterScreen = new LoadCharacterScreen("loadCharacterScreen", con, this);
        screens.put("loadCharacterScreen",loadCharacterScreen);






        titleScreen.updateVisibility(true);
        mainWindow.setVisible(true);
        con.repaint();
    }
    public void changeScreen(String displayScreen){
        screens.get(displayScreen).updateVisibility(true);
    }


}
