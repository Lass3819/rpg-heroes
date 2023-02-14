package heroes;

public class HeroAttributes {
    public int strength;
    public int dexterity;
    public int intelligence;
    public HeroAttributes(int str, int dex, int intelligence){
        this.strength = str;
        this.dexterity = dex;
        this.intelligence = intelligence;
    }
    public void updateLevels(int str, int dex, int intelligence){
        this.dexterity += dex;
        this.strength += str;
        this.intelligence += intelligence;
    }
    public void addLevelsFromClass(HeroAttributes stats){
        updateLevels(stats.strength, stats.dexterity, stats.intelligence);
    }
    public void removeLevelsFromClass(HeroAttributes stats){
        updateLevels(-stats.strength, -stats.dexterity, -stats.intelligence);
    }




}
