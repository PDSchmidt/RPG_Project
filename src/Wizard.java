public class Wizard extends PlayerCharacter {
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

    public void attack(GameCharacter target) {
        if ((randNum.nextInt(1, 21) + getAbilityScore("INT")) >= (randNum.nextInt(1, 21) + target.getAbilityScore("STR"))) {
            target.setCurrentHp(target.getCurrentHP() - baseDamage);
            //You hit the target for "baseDamage" amount of damage
        } else {
            // Tell the player how stupid they are for missing.
        }

    }
}
