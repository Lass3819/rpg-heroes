package heroes;

public class Mage extends Hero {
    public Mage(String name){
        super(name);
        levelAttributes.updateLevels(1,1,8);
        heroClass = "mage";
    }



    public void levelUp() {
        level++;
        levelAttributes.updateLevels(1,1,8);
    }
}
