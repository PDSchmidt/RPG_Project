public class Rogue extends PlayerCharacter{
    public Rogue() {
        stats.put("Strength", 8);
        stats.put("Dexterity", 14);
        stats.put("Constitution", 9);
        stats.put("Intelligence", 14);
        stats.put("Wisdom", 14);
        stats.put("Charisma", 14);
        name = "Rogesh";
    }
    public Rogue(String selectedName) {
        new Rogue();
        this.name = selectedName;
    }
}
