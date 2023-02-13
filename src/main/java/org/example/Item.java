package org.example;

import enums.Slot;
import heroes.Hero;

public abstract class Item {
    public String name;
    public int requiredLevel;
    public Slot slot;
    public HeroAttributes stats;
    public int weaponDamage;

    public Item(String name, int req, Slot slot, HeroAttributes stats){
        this.name = name;
        this.requiredLevel = req;
        this.slot = slot;
        this.stats = stats;
        this.weaponDamage = 0;

    }


}
