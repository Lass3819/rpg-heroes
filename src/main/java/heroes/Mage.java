package heroes;

import enums.ArmorType;
import enums.WeaponType;

public class Mage extends Hero {
    public Mage(String name){
        super(name);
        levelAttributes.updateLevels(1,1,8);
        heroClass = "mage";


        // Adding weapon and armor types to mage.
        addValidWeaponType(new WeaponType[]{WeaponType.Wands,WeaponType.Staffs});
        addValidArmorTypes(new ArmorType[]{ArmorType.Cloth});
    }



    public void levelUp() {
        level++;
        levelAttributes.updateLevels(1,1,8);
    }
    //setting damaging attribute
    public int damagingAttribute(){
        return levelAttributes.intelligence;
    }

}
