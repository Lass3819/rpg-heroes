package org.example;

import enums.Slot;

public abstract class Item {
    String name;
    int requiredLevel;

    Slot slot;

    public Item(String name, int req, Slot slot){
        this.name = name;
        this.requiredLevel = req;
        this.slot = slot;

    }


}
