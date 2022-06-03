import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Driver {
    public static void main(String[] args) {
        File newFile = new File("src/savefile.txt");
        //Scanner Object
        try {
            Scanner scnr = new Scanner(newFile);
            while (scnr.hasNext()) {
                System.out.print(scnr.nextLine() + " ");
            }
        } catch(FileNotFoundException e) {

        }
        //Scanner object

        GameCharacter stat = new GameCharacter();
        System.out.println(stat.getStats());

        GameCharacter Steven = new GameCharacter();
        GameCharacter Alven = new GameCharacter();
        Steven.attack(Alven);
        System.out.println(Alven.getCurrentHP());
        System.out.println("Yo, I'm testing this cod!!!!!!");

        //Character Type Testing
        Rogue rooze = new Rogue();
        Fighter fifi = new Fighter();
        Wizard wazup = new Wizard();
        System.out.println(rooze.getName());
        System.out.println(fifi.getStats());
        System.out.println(wazup.getSpecificStat("Strength"));

    }
}
