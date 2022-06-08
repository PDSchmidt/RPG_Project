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
        name = selectedName;
        MaxHp = 54;
        CurrentHp = MaxHp;
        characterType = "Rogue";
    }
    //Override of attack method of GameCharacter to implement how the Rogue Class does combat
    public String attack (GameCharacter target) {
        int first = randNum.nextInt(1,21);
        int second = randNum.nextInt(1,21);
        int higher;
        if(first > second)
            higher = first;
        else
            higher = second;
        if ((higher + getAbilityScore("DEX")) >= (randNum.nextInt(1, 21) + target.getAbilityScore("CON"))) {
            int baseDamage = randNum.nextInt(1, 5) + randNum.nextInt(1, 7) + getAbilityScore("DEX");
            target.setCurrentHp(target.getCurrentHP() - baseDamage);
            System.out.println("Damage was: " + baseDamage + " | Target's HP after damage: " + target.getCurrentHP());
            return "With your daggers, you slice at the " + target.getName() + " for " + baseDamage + " damage!";
        } else {
            //"You missed you bloody idiot"
            return "You missed you bloody idiot";
        }
    }
}
