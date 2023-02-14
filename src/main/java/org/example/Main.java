package org.example;

import enums.ArmorType;
import enums.Slot;
import enums.WeaponType;
import exceptions.InvalidWeaponException;
import heroes.HeroAttributes;
import heroes.Warrior;
import items.Armor;
import items.Weapon;

public class Main {
    public static void main(String[] args) throws InvalidWeaponException {
        Weapon runeSword = new Weapon("Rune sword",1, WeaponType.Swords, 70);
        Armor runePlateBody = new Armor("Rune plate body", 1, ArmorType.Plate, Slot.Body, new HeroAttributes(100,100,100));
        Armor adamantPlateBody = new Armor("Adamant plate body", 1, ArmorType.Plate, Slot.Body, new HeroAttributes(140,70,70));
        Weapon adamantSword = new Weapon("Adamant sword",1, WeaponType.Swords, 130);


        Warrior test = new Warrior("hej");

        test.levelUp();
        test.levelUp();
        test.equip(runeSword);
        test.equip(runePlateBody);
        //System.out.println(test.damage());
        System.out.println(test.display());
        test.equip(adamantPlateBody);
        test.equip(adamantSword);
        System.out.println(test.display());


    }


}