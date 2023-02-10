package heroes;

import org.example.HeroAttributes;

public abstract class Hero {
    //every hero has the following shared fields:
    public String heroClass;
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
        int lvlAttribute = levelAttributes.totalLevels();
        int armorAttributes = 0;
        return lvlAttribute+armorAttributes;
    }

    public void display(){
        System.out.println("Your hero-name is: " + name);
        System.out.println("Your class is: " + heroClass);
        System.out.println("Your current level is: " + level);
/*       System.out.println(levelAttributes.strength);
        System.out.println(levelAttributes.dexterity);
        System.out.println(levelAttributes.intelligence);*/
        System.out.println("Your attributes from levels and armor is: " + totalAttributes());
        System.out.println("Your damage is: " + damage());
    }






}
