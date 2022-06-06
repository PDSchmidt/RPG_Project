public class Rogue extends PlayerCharacter{
    public Rogue() {
        stats.put("Strength", 12);
        stats.put("Dexterity", 18);
        stats.put("Constitution", 14);
        stats.put("Intelligence", 12);
        stats.put("Wisdom", 14);
        stats.put("Charisma", 14);
        statModifiers.put("STR", 1);
        statModifiers.put("DEX", 4);
        statModifiers.put("CON", 2);
        statModifiers.put("INT", 1);
        statModifiers.put("WIS", 2);
        statModifiers.put("CHA", 2);
        name = "Rogesh";
        MaxHp = 54;
        CurrentHp = MaxHp;
        //baseDamage = randNum.nextInt(1, 5) + randNum.nextInt(1, 7) + getAbilityScore("DEX");
        characterType = "Rogue";
    }
    public Rogue(String selectedName) {
        new Rogue();
        this.name = selectedName;
        characterType = "Rogue";
    }
    public void attack (GameCharacter target) {
        if ((randNum.nextInt(1, 21) + getAbilityScore("DEX")) >= (randNum.nextInt(1, 21) + target.getAbilityScore("CON"))) {
            int baseDamage = randNum.nextInt(1, 5) + randNum.nextInt(1, 7) + getAbilityScore("DEX");
            target.setCurrentHp(target.getCurrentHP() - baseDamage);
            //You hit the target for "baseDamage" amount of damage
            System.out.println("Damage was: " + baseDamage + " | Target's HP after damage: " + target.getCurrentHP());
            // With your daggers, you slice at the (target.type) for (baseDamage) damage!
        } else {
            // Tell the player how stupid they are for missing.
            //"You missed you bloody idiot"
        }
    }
}
