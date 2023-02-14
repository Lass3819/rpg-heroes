package heroes;

public class Attributes {
    public int strength;
    public int dexterity;
    public int intelligence;
    public Attributes(int str, int dex, int intelligence){
        this.strength = str;
        this.dexterity = dex;
        this.intelligence = intelligence;
    }
    public void updateLevels(int str, int dex, int intelligence){
        this.dexterity += dex;
        this.strength += str;
        this.intelligence += intelligence;
    }
    public void addLevelsFromClass(Attributes stats){
        updateLevels(stats.strength, stats.dexterity, stats.intelligence);
    }
    public void removeLevelsFromClass(Attributes stats){
        updateLevels(-stats.strength, -stats.dexterity, -stats.intelligence);
    }




}
