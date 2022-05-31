import java.util.Map;
import java.util.TreeMap;

public class GameCharacter {
    Map<String, Integer> stats = new TreeMap<String, Integer>();
    private int MaxHp;
    public int CurrentHp;
    String name;
    private int baseDamage = 4;
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

    }

    //Stat Related Methods
    public Map< String, Integer> getStats() {
        return stats;
    }
    public Integer getSpecificStat(String key) {
        return stats.get(key);
    }

    //HP related methods
    public Integer getMaxHp () {
        return MaxHp;
    }
    public Integer getCurrentHP() {
        return CurrentHp;
    }
    public void attack (GameCharacter target) {
        target.setCurrentHp(target.getCurrentHP() - baseDamage);
    }
    public void setCurrentHp (int newHp) {
        CurrentHp = newHp;
    }
}
