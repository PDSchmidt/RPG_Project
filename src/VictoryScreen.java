import java.awt.*;

public class VictoryScreen extends Screen{
    public VictoryScreen(String type, Container container, GameManager game){
        super(type,container,game);
        hasCombat = false;
        combatDone = true;
    }
}
