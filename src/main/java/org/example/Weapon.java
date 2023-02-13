package org.example;

import enums.Slot;

public class Weapon extends Item{


    public Weapon(String name, int req, int weaponDamage){
        super(name, req, Slot.Weapon, null);
        this.weaponDamage = weaponDamage;
    }
}
