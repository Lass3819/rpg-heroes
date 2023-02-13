package heroes;

import enums.ArmorType;
import enums.Slot;
import enums.WeaponType;
import exceptions.InvalidWeaponException;
import org.example.HeroAttributes;
import org.example.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public abstract class Hero {
    //every hero has the following shared fields:
    public String heroClass;
    public String name;
    public int damagingAttribute;
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
        equipment.put(item.slot, item);
        if(item.stats == null){
            return;
        }
        levelAttributes.updateLevelsFromClass(item.stats);
    }

    public int damage(){
        System.out.println(equipment.get(Slot.Weapon).weaponDamage);
        System.out.println(damagingAttribute);
        return equipment.get(Slot.Weapon).weaponDamage*(1+damagingAttribute/100);


    }

    public int totalAttributes(){
        int lvlAttribute = levelAttributes.totalLevels();
        int armorAttributes = 0;
        return lvlAttribute+armorAttributes;
    }

    public void addValidArmorTypes( ArmorType[] arr ){
        validArmorTypes.addAll(Arrays.asList(arr));

    }

    public void addValidWeaponType( WeaponType[] arr ){
        validWeaponTypes.addAll(Arrays.asList(arr));

    }

    public void display(){
        System.out.println("Your hero-name is: " + name);
        System.out.println("Your class is: " + heroClass);
        System.out.println("Your current level is: " + level);
        System.out.println("Your attributes from levels and armor is: " + totalAttributes());
        System.out.println("Your damage is: " + damage());
    }






}
