package heroes;

import enums.ArmorType;
import enums.WeaponType;

public class Warrior extends Hero {
    public Warrior(String name){
        super(name);
        levelAttributes.updateLevels(5,2,1);
        heroClass = "Warrior";

        // Adding weapon and armor types to mage.
        addValidWeaponType(new WeaponType[]{WeaponType.Axes, WeaponType.Hammers, WeaponType.Swords});
        addValidArmorTypes(new ArmorType[]{ArmorType.Plate,ArmorType.Mail});
    }

    public void levelUp() {
        level++;
        levelAttributes.updateLevels(3,2,1);
    }
    //setting damaging attribute
    public int damagingLevelAttribute(){
        return levelAttributes.strength;
    }
    public int damagingArmorAttribute(){
        return armorAttributes.strength;
    }
}
