package items;

import enums.ArmorType;
import enums.Slot;
import heroes.HeroAttributes;


public class Armor extends Item {
    public Armor(String name, int req, ArmorType armorType, Slot slot, HeroAttributes stats){
        super(name, req, null,armorType, slot, stats);
    }
}
