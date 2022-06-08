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
        MaxHp = 48;
        CurrentHp = MaxHp;
        characterType = "Wizard";
    }
    public Wizard(String selectedName) {
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
        name = selectedName;
        MaxHp = 48;
        CurrentHp = MaxHp;
        characterType = "Wizard";
    }
    public String attack (GameCharacter target) {
        baseDamage = randNum.nextInt(1, 5)*2 + getAbilityScore("INT");
        target.setCurrentHp(target.getCurrentHP() - baseDamage);
        return "You sling your spell towards " + target.getName() + " for " + baseDamage + " damage!";
    }
}