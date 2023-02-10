package org.example;

public abstract class Hero {
    //every hero has the following shared fields:
    public String name;
    public int level;
    public HeroAttributes levelAttributes;
    private String[] equipment;
    private String[] validWeaponTypes;
    private String[] validArmorTypes;
    public Hero(String name){
        this.name = name;
        level = 1;
        this.levelAttributes = new HeroAttributes();
    }
    public abstract void levelUp();
    public void equip(){

    }

    public int damage(){
        return 0;
    }

    public int totalAttributes(){
        return levelAttributes.strength + levelAttributes.dexterity + levelAttributes.intelligence;
    }

    public void display(){
        System.out.println(name);
        System.out.println(level);
/*        System.out.println(levelAttributes.strength);
        System.out.println(levelAttributes.dexterity);
        System.out.println(levelAttributes.intelligence);*/
        System.out.println(totalAttributes());
        System.out.println(damage());
    }






}
