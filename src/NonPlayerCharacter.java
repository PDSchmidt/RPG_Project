public class NonPlayerCharacter extends GameCharacter{
    public void attack (GameCharacter target) {
        if (this instanceof Goblin){
            baseDamage = randNum.nextInt(1, 7) + 2;
            // The Goblin catches you off guard and stabs at you for (baseDamage) amount of damage!
        } else if (this instanceof HobGoblin) {
            baseDamage = randNum.nextInt(1, 9) + 1;
            // The HobGoblin overpowers and slashes at you for (baseDamage) amount of damage!
        } else if (this instanceof HobgoblinCaptain) {
            baseDamage = randNum.nextInt(1, 7) + 2;
            // The Hobgoblin Captain knocks you back and pierces you for (baseDamage) amount of damage!
        } else {
            baseDamage = randNum.nextInt(1, 11) + 3;
            //The princess in a whirlwind of slashes deals you (baseDamage) amount of damage!
        }
        if (target instanceof Fighter) {
            if ((randNum.nextInt(1, 21) + target.getAbilityScore("CON")) <= randNum.nextInt(1, 21) + getAbilityScore("STR")) {
                target.setCurrentHp(target.getCurrentHP() - baseDamage);
                System.out.println("Damage was: " + baseDamage + " | Target's HP after damage: " + target.getCurrentHP());
            }
            else {
                //Tell player that enemy is a stupid turd for missing
                //The enemy tries to attack you but misses like a bafoon!
            }
        } else if (target instanceof Rogue) {
            if ((randNum.nextInt(1, 21) + target.getAbilityScore("DEX")) <= randNum.nextInt(1, 21) + getAbilityScore("STR")) {
                target.setCurrentHp(target.getCurrentHP() - baseDamage);
                System.out.println("Damage was: " + baseDamage + " | Target's HP after damage: " + target.getCurrentHP());
            }
            else {
                //Tell player that enemy is a stupid turd for missing
                System.out.println("You missed you bloody idiot");
            }
        } else {
            if ((randNum.nextInt(1, 21) + target.getAbilityScore("INT")) <= randNum.nextInt(1, 21) + getAbilityScore("STR")) {
                target.setCurrentHp(target.getCurrentHP() - baseDamage);
                System.out.println("Damage was: " + baseDamage + " | Target's HP after damage: " + target.getCurrentHP());
            }
            else {
                //Tell player that enemy is a stupid turd for missing
                //The enemy tries to attack you but misses like a bafoon!
            }
        }
    }
}
