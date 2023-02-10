package org.example;

public class Warrior extends Hero{
    public Warrior(String name){
        super(name);
        levelAttributes.updateLevels(5,2,1);
    }

    public void levelUp() {
        level++;
        levelAttributes.updateLevels(3,2,1);
    }
}
