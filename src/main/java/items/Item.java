package items;

import enums.ArmorType;
import enums.Slot;
import enums.WeaponType;
import heroes.Attributes;

public abstract class Item {
    public String name;
    public int requiredLevel;
    public Slot slot;
    public Attributes stats;
    public int weaponDamage;
    public WeaponType weaponType;
    public ArmorType armorType;

    public Item(String name, int req, WeaponType weaponType, ArmorType armortype, Slot slot, Attributes stats){
        this.name = name;
        this.requiredLevel = req;
        this.slot = slot;
        this.stats = stats;
        this.weaponType = weaponType;
        this.armorType = armortype;
        this.weaponDamage = 0;

    }


}
