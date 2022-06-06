public class HobgoblinCaptain extends NonPlayerCharacter{
    public HobgoblinCaptain() {
        //Hobgoblins who've reached the rank of capatian due to their martial prowess
        //HobGoblins are skilled warriors from martial culture; their average height are about 6ft.
        //Wear half-plate mail armor with leather/cloth padding underneath;
        //Captain's color-scheme is blue with black
        //Used as a singular enemy
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
        CurrentHp = MaxHp;
        name = "Captain Gozrer Bellow";
        baseDamage = randNum.nextInt(1, 7) + randNum.nextInt(1, 7)  + 2;
    }
}
