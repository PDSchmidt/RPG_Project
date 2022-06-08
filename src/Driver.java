//Testing Class for parts of the program
public class Driver {
    public static void main(String[] args) {
        //Character Type Testing
        Rogue rooze = new Rogue();
        Fighter fifi = new Fighter();
        Wizard wazup = new Wizard();
        Goblin gobels = new Goblin();
        HobGoblin hobs = new HobGoblin();
        HobgoblinCaptain cptHobs = new HobgoblinCaptain();
        Princess warHobs = new Princess();
        for (int i = 0; i < 5; i++) {
            hobs.attack(fifi);

        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            wazup.attack(hobs);

        }
        //FileScannerTest
        FileScanner SaveFile = new FileScanner();
        HobGoblin boss = new HobGoblin();
        System.out.println("boss's base damage: " + boss.baseDamage);
    }
}
