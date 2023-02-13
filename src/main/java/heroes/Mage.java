package heroes;

import enums.ArmorType;
import enums.Slot;
import enums.WeaponType;
import org.example.Weapon;

import java.util.Arrays;
import java.util.List;

public class Mage extends Hero {
    public Mage(String name){
        super(name);
        levelAttributes.updateLevels(1,1,8);
        heroClass = "mage";
        this.damagingAttribute = levelAttributes.intelligence;

        // Adding weapon and armor types to mage.
        addValidWeaponType(new WeaponType[]{WeaponType.Wands,WeaponType.Staffs});
        addValidArmorTypes(new ArmorType[]{ArmorType.Cloth});
    }



    public void levelUp() {
        level++;
        levelAttributes.updateLevels(1,1,8);
    }
}
