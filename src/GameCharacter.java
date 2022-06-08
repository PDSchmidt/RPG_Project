import java.util.Random;
import java.util.Map;
import java.util.TreeMap;
//Base Class for all generic GameCharacter Objects/Classes
public class GameCharacter {
    Map<String, Integer> stats = new TreeMap<String, Integer>();
    Map<String, Integer> statModifiers = new TreeMap<String, Integer>();
    Random randNum = new Random();
    int MaxHp;
    public int CurrentHp;
    String name, characterType;
    int baseDamage;

    //Constructors
    public GameCharacter() {
        stats.put("Strength", 10);
        stats.put("Dexterity", 10);
        stats.put("Constitution", 10);
        stats.put("Intelligence", 10);
        stats.put("Wisdom", 10);
        stats.put("Charisma", 10);
        MaxHp = 12;
        CurrentHp = MaxHp;
        name = "Bilbo Swaggins";
        baseDamage = 4;
    }
    public GameCharacter (String selectedName) {
        new GameCharacter();
        this.name = selectedName;
    }
    public String attack (GameCharacter target) {
        target.setCurrentHp(target.getCurrentHP() - baseDamage);
        return "";
    }
    //getName/setName method
    public String getName () {
        return name;
    }

    //Stat Related Methods
    public Map< String, Integer> getStats() {
        return stats;
    }
    public Integer getSpecificStat(String key) {
        return statModifiers.get(key);
    }
    public Integer getAbilityScore(String key) { return statModifiers.get(key);}

    //HP related methods
    public Integer getMaxHp () {
        return MaxHp;
    }
    public Integer getCurrentHP() {
        return CurrentHp;
    }
    public String getCharacterType(){
        return characterType;
    }
    public void setCurrentHp (int newHp) {
        CurrentHp = newHp;
    }
    public void setCharacterType(String newType){
        characterType = newType;
    }
    public void setMaxHP (int maxHp) {
        this.MaxHp = maxHp;
    }
}
