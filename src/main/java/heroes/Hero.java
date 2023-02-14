package heroes;

import enums.ArmorType;
import enums.Slot;
import enums.WeaponType;
import exceptions.InvalidWeaponException;
import items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public abstract class Hero {
    //every hero has the following shared fields:
    public String heroClass;
    public String name;

    public int level;
    public Attributes levelAttributes;
    public Attributes armorAttributes;
    public HashMap<Slot,Item> equipment;
    public List<WeaponType> validWeaponTypes = new ArrayList<>();
    public List<ArmorType> validArmorTypes = new ArrayList<>();


    public Hero(String name){
        this.name = name;
        level = 1;
        this.levelAttributes = new Attributes(0,0,0);
        this.armorAttributes = new Attributes(0,0,0);
        //initialize equipment with null values in each slot.
        equipment = new HashMap<>();
        for(Slot slots: Slot.values()){
            equipment.put(slots,null);
        }

    }
    public abstract void levelUp();
    public void equip(Item item) throws InvalidWeaponException{
        if(item.requiredLevel >level){
            throw new InvalidWeaponException("You are too low level to equip that");
        }
        if(!validWeaponTypes.contains(item.weaponType) && !validArmorTypes.contains(item.armorType)){
            throw new InvalidWeaponException("Your class cannot equip this item");
        }

        //check if something is already equipped and remove the stats from levelAttributes.
        if(equipment.get(item.slot)!=null && item.slot!=Slot.Weapon) {
            armorAttributes.removeLevelsFromClass(equipment.get(item.slot).stats);
        }
        equipment.put(item.slot, item);
        if(item.stats == null){
            return;
        }
        armorAttributes.addLevelsFromClass(item.stats);
    }

    public int damage(){
        int armorAtt = damagingArmorAttribute();
        int levelAtt = damagingLevelAttribute();
        int damagingAtt = armorAtt + levelAtt;

        if (equipment.get(Slot.Weapon) == null) {
            return 1 + damagingAtt / 100;
        }

        return equipment.get(Slot.Weapon).weaponDamage * (1 + damagingAtt / 100);


    }
    public abstract int damagingLevelAttribute();
    public abstract int damagingArmorAttribute();

    public void addValidArmorTypes( ArmorType[] arr ){
        validArmorTypes.addAll(Arrays.asList(arr));

    }

    public void addValidWeaponType( WeaponType[] arr ){
        validWeaponTypes.addAll(Arrays.asList(arr));

    }

    public String display(){
        String toDisplay = "Name: ";
        toDisplay+= name+"\n";
        toDisplay += "Hero Class: "+heroClass+"\n";
        toDisplay += "Level: " + level +"\n";
        toDisplay += "Total strength: " + levelAttributes.strength +"\n";
        toDisplay += "Total dexterity: " + levelAttributes.dexterity +"\n";
        toDisplay += "Total intelligence: " + levelAttributes.intelligence +"\n";
        toDisplay += "Damage: " + damage();
        return toDisplay;
    }






}
