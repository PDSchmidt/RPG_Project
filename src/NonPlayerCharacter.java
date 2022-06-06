public class NonPlayerCharacter extends GameCharacter{
    public void attack (GameCharacter target) {
        if (target instanceof Fighter) {
            if ((randNum.nextInt(1, 21) + target.getAbilityScore("CON")) <= randNum.nextInt(1, 21) + getAbilityScore("STR")) {
                target.setCurrentHp(target.getCurrentHP() - baseDamage);
            }
            else {
                //Tell player that enemy is a stupid turd for missing
                //The enemy tries to attack you but misses like a bafoon!
            }
        } else if (target instanceof Rogue) {
            if ((randNum.nextInt(1, 21) + target.getAbilityScore("DEX")) <= randNum.nextInt(1, 21) + getAbilityScore("STR")) {
                target.setCurrentHp(target.getCurrentHP() - baseDamage);
            }
            else {
                //Tell player that enemy is a stupid turd for missing
                System.out.println("You missed you bloody idiot");
            }
        } else {
            if ((randNum.nextInt(1, 21) + target.getAbilityScore("INT")) <= randNum.nextInt(1, 21) + getAbilityScore("STR")) {
                target.setCurrentHp(target.getCurrentHP() - baseDamage);
            }
            else {
                //Tell player that enemy is a stupid turd for missing
                //The enemy tries to attack you but misses like a bafoon!
            }
        }
    }
}
