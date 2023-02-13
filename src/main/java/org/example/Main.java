package org.example;

import enums.Slot;
import exceptions.InvalidWeaponException;
import heroes.Mage;
import heroes.Warrior;

public class Main {
    public static void main(String[] args) throws InvalidWeaponException {
        Weapon runeSword = new Weapon("Rune Sword",1, 70);
        Armor RunePlateBody = new Armor("Rune Plate Body", 1, Slot.Body, new HeroAttributes(1000,200,1000));

        Warrior test = new Warrior("hej");

        test.levelUp();
        test.levelUp();
        test.equip(runeSword);
        test.equip(RunePlateBody);
        System.out.println(test.equipment.get(Slot.Body).name);
        System.out.println(test.levelAttributes.intelligence);
        System.out.println(test.damage());
    }


}