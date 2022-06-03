import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class TestDriver {
    public static void main(String[] args) {

        GameCharacter stat = new GameCharacter();
        System.out.println(stat.getStats());

        GameCharacter Steven = new GameCharacter();
        GameCharacter Alven = new GameCharacter();
        Steven.attack(Alven);
        System.out.println(Alven.getCurrentHP());
        System.out.println("Yo, I'm testing this cod!!!!!!");

        GameCharacter Nancy = new Fighter("Nancy Higgens");
        System.out.println(Nancy.getName());

        //Character Type Testing
        Rogue rooze = new Rogue();
        Fighter fifi = new Fighter();
        Wizard wazup = new Wizard();
        System.out.println(rooze.getName());
        System.out.println(fifi.getStats());
        System.out.println(wazup.getSpecificStat("Strength"));

        //FileScannerTest
        FileScanner SaveFile = new FileScanner();
    }
}