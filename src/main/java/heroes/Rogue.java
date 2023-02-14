package heroes;

import enums.ArmorType;
import enums.WeaponType;

public class Rogue extends Hero {
    public Rogue(String name){
        super(name);
        levelAttributes.updateLevels(2,6,1);
        heroClass = "Rogue";

        // Adding weapon and armor types to mage.
        addValidWeaponType(new WeaponType[]{WeaponType.Daggers,WeaponType.Swords});
        addValidArmorTypes(new ArmorType[]{ArmorType.Leather,ArmorType.Mail});

    }

    public void levelUp() {
        level++;
        levelAttributes.updateLevels(1,4,1);
    }
    //setting damaging attribute
    public int damagingLevelAttribute(){
        return levelAttributes.dexterity;
    }
    public int damagingArmorAttribute(){
        return armorAttributes.dexterity;
    }

}
