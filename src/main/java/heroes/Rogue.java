package heroes;

public class Rogue extends Hero {
    public Rogue(String name){
        super(name);
        levelAttributes.updateLevels(2,6,1);

    }

    public void levelUp() {
        level++;
        levelAttributes.updateLevels(1,4,1);
    }

}
