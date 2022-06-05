public class HobGoblin extends GameCharacter{
    public HobGoblin() {
        //Described as Foot-soldiers in the monster manual; bully/threaten goblins & use them as cannon-fauder.
        //HobGoblins are skilled warriors from martial culture; their average height are about 6ft.
        //Wear Chain mail armor with leather/cloth padding underneath;
        //Foot-soldier's color-scheme is red with black
        //Probably should be used in pairs of 2
        stats.put("Strength", 13);
        stats.put("Dexterity", 12);
        stats.put("Constitution", 12);
        stats.put("Intelligence", 10);
        stats.put("Wisdom", 10);
        stats.put("Charisma", 9);
        statModifiers.put("STR", 1);
        statModifiers.put("DEX", 1);
        statModifiers.put("CON", 1);
        statModifiers.put("INT", 0);
        statModifiers.put("WIS", 0);
        statModifiers.put("CHA", -1);
        MaxHp = 17;
        name = "Golvog";
        baseDamage = randNum.nextInt(1, 9) + 1;
    }
}
