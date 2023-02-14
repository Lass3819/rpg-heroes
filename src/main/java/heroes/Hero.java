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
    public HeroAttributes levelAttributes;
    public HashMap<Slot,Item> equipment;
    public List<WeaponType> validWeaponTypes = new ArrayList<>();
    public List<ArmorType> validArmorTypes = new ArrayList<>();


    public Hero(String name){
        this.name = name;
        level = 1;
        this.levelAttributes = new HeroAttributes(0,0,0);
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
            levelAttributes.removeLevelsFromClass(equipment.get(item.slot).stats);
        }
        equipment.put(item.slot, item);
        if(item.stats == null){
            return;
        }
        levelAttributes.addLevelsFromClass(item.stats);
    }

    public int damage(){
        return equipment.get(Slot.Weapon).weaponDamage*(1+damagingAttribute()/100);


    }
    public abstract int damagingAttribute();

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
