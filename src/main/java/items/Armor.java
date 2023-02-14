package items;

import enums.ArmorType;
import enums.Slot;
import heroes.Attributes;


public class Armor extends Item {
    public Armor(String name, int req, ArmorType armorType, Slot slot, Attributes stats){
        super(name, req, null,armorType, slot, stats);
    }
}
