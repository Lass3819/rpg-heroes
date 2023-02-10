package org.example;

public class Mage extends Hero {
    String heroClass = "mage";
    Mage(String name){
        super(name);
        levelAttributes.updateLevels(1,1,8);
    }



    public void levelUp() {
        level++;
        levelAttributes.updateLevels(1,1,8);
    }

    @Override
    public void display() {
        super.display();
        System.out.println(heroClass);

    }
}
