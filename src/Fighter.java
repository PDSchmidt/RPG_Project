public class Fighter extends PlayerCharacter{
    public Fighter() {
        stats.put("Strength", 20);
        stats.put("Dexterity", 20);
        stats.put("Constitution", 20);
        stats.put("Intelligence", 5);
        stats.put("Wisdom", 5);
        stats.put("Charisma", 5);
        name = "Fiedoor";
    }
    public Fighter(String selectedName) {
        new Fighter();
        this.name = selectedName;
    }
}
