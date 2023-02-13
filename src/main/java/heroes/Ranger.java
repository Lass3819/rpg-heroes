package heroes;

import enums.ArmorType;
import enums.WeaponType;

public class Ranger extends Hero {

    public Ranger(String name){
        super(name);
        levelAttributes.updateLevels(1,7,1);
        heroClass = "Ranger";
        this.damagingAttribute = levelAttributes.dexterity;

        // Adding weapon and armor types to mage.
        addValidWeaponType(new WeaponType[]{WeaponType.Bows});
        addValidArmorTypes(new ArmorType[]{ArmorType.Leather,ArmorType.Mail});
    }

    public void levelUp() {
        level++;
        levelAttributes.updateLevels(1,5,8);
    }
}
