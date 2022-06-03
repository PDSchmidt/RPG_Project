public class Wizard extends PlayerCharacter{
    public Wizard() {
        stats.put("Strength", 8);
        stats.put("Dexterity", 8);
        stats.put("Constitution", 8);
        stats.put("Intelligence", 20);
        stats.put("Wisdom", 12);
        stats.put("Charisma", 4);
        name = "Wizzils";
    }
    public Wizard(String selectedName) {
        new Wizard();
        this.name = selectedName;
    }

}
