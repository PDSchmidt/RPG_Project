public class HobgoblinCaptain extends NonPlayerCharacter{
    public HobgoblinCaptain() {
        //
        //HobGoblins are skilled warriors from martial culture; their average height are about 6ft.
        //Wear Chain mail armor with leather/cloth padding underneath;
        //Foot-soldier's color-scheme is red with black
        //Probably should be used in pairs of 2
        stats.put("Strength", 15);
        stats.put("Dexterity", 14);
        stats.put("Constitution", 14);
        stats.put("Intelligence", 12);
        stats.put("Wisdom", 10);
        stats.put("Charisma", 13);
        statModifiers.put("STR", 2);
        statModifiers.put("DEX", 2);
        statModifiers.put("CON", 2);
        statModifiers.put("INT", 1);
        statModifiers.put("WIS", 0);
        statModifiers.put("CHA", 1);
        MaxHp = 40;
        name = "Captain Gozrer Bellow";
        baseDamage = randNum.nextInt(1, 7) + randNum.nextInt(1, 7)  + 2;
    }
}
