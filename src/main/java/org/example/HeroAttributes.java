package org.example;

public class HeroAttributes {
    public int strength;
    public int dexterity;
    public int intelligence;
    public HeroAttributes(){
        this.strength = 0;
        this.dexterity = 0;
        this.intelligence = 0;
    }
    public void updateLevels(int str, int dex, int intelligence){
        this.strength += str;
        this.dexterity += dex;
        this.intelligence += intelligence;
    }





}
