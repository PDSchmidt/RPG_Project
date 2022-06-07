public class Goblin extends NonPlayerCharacter{
    public Goblin() {
        // Intended to be used in pairs of 3, but that can change based on the final project
        stats.put("Strength", 8);
        stats.put("Dexterity", 14);
        stats.put("Constitution", 10);
        stats.put("Intelligence", 10);
        stats.put("Wisdom", 8);
        stats.put("Charisma", 8);
        statModifiers.put("STR", -1);
        statModifiers.put("DEX", 2);
        statModifiers.put("CON", 0);
        statModifiers.put("INT", 0);
        statModifiers.put("WIS", -1);
        statModifiers.put("CHA", -1);
        MaxHp = 13;
        CurrentHp = MaxHp;
        name = "Clulb";
        baseDamage = randNum.nextInt(1, 7) + 2;
        characterType = "Goblin";
    }

}
