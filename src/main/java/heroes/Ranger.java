package heroes;

public class Ranger extends Hero {

    public Ranger(String name){
        super(name);
        levelAttributes.updateLevels(1,7,1);
    }

    public void levelUp() {
        level++;
        levelAttributes.updateLevels(1,5,8);
    }
}
