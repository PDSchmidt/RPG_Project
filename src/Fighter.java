public class Fighter extends PlayerCharacter{
    public Fighter() {
        stats.put("Strength", 18);
        stats.put("Dexterity", 14);
        stats.put("Constitution", 16);
        stats.put("Intelligence", 10);
        stats.put("Wisdom", 10);
        stats.put("Charisma", 5);
        statModifiers.put("STR", 4);
        statModifiers.put("DEX", 2);
        statModifiers.put("CON", 3);
        statModifiers.put("INT", 0);
        statModifiers.put("WIS", 0);
        statModifiers.put("CHA", 0);
        name = "Fiedoor";
        characterType = "Fighter";
    }
    public Fighter(String selectedName) {
        new Fighter();
        this.name = selectedName;
        characterType = "Fighter";
    }
}
