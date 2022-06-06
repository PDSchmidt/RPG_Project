public class Wizard extends PlayerCharacter{
    public Wizard() {
        stats.put("Strength", 8);
        stats.put("Dexterity", 10);
        stats.put("Constitution", 12);
        stats.put("Intelligence", 18);
        stats.put("Wisdom", 14);
        stats.put("Charisma", 12);
        statModifiers.put("STR", -1);
        statModifiers.put("DEX", 0);
        statModifiers.put("CON", 1);
        statModifiers.put("INT", 4);
        statModifiers.put("WIS", 2);
        statModifiers.put("CHA", 1);
        name = "Wizzils";
        characterType = "Wizard";
    }
    public Wizard(String selectedName) {
        new Wizard();
        this.name = selectedName;
        characterType = "Wizard";
    }

}
