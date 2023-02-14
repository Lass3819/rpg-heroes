package items;

import enums.Slot;
import enums.WeaponType;
import items.Item;

public class Weapon extends Item {


    public Weapon(String name, int req, WeaponType weaponType, int weaponDamage){
        super(name, req, weaponType,null, Slot.Weapon, null);
        this.weaponDamage = weaponDamage;
    }
}
