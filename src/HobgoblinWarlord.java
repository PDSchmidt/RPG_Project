public class HobgoblinWarlord extends NonPlayerCharacter{
    public HobgoblinWarlord() {
        //Warlord of the hobgoblins; skilled warriors who've taken leadership due to superior skills
        //Strategically minded & more skilled than most; around 7 ft tall.
        //Wear plate mail armor with leather/cloth padding underneath;
        //Warlord's color-scheme is blue with purple
        //Used as a singular enemy
        stats.put("Strength", 16);
        stats.put("Dexterity", 14);
        stats.put("Constitution", 16);
        stats.put("Intelligence", 14);
        stats.put("Wisdom", 11);
        stats.put("Charisma", 15);
        statModifiers.put("STR", 3);
        statModifiers.put("DEX", 2);
        statModifiers.put("CON", 3);
        statModifiers.put("INT", 2);
        statModifiers.put("WIS", 0);
        statModifiers.put("CHA", 2);
        MaxHp = 90;
        name = "Warlord Kruverg The Boar";
        baseDamage = randNum.nextInt(1, 11) + 3;
    }
}
