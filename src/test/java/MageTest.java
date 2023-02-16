import enums.ArmorType;
import enums.Slot;
import enums.WeaponType;
import exceptions.InvalidWeaponException;
import heroes.Attributes;
import heroes.Mage;
import items.Armor;
import items.Weapon;

import org.junit.Test;


import static org.junit.Assert.*;

public class MageTest {

    @Test
    public void check_if_name_correct(){
        // Arrange
        Mage testMage = new Mage("testName");
        String expected = "testName";
        //Act
        String actual = testMage.name;
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void check_if_initial_level_attributes_correct(){
        //Arrange
        Mage testMage = new Mage("testName");
        int[] expected = new int[]{1,1,8};
        //Act
        int[] actual = new int[] {testMage.levelAttributes.strength,testMage.levelAttributes.dexterity,testMage.levelAttributes.intelligence};
        //Assert
        assertArrayEquals(expected,actual);
    }
    @Test
    public void check_if_level_attributes_correct_after_lvl_up(){
        //Arrange
        Mage testMage = new Mage("testName");
        int[] expected = new int[]{2,2,13};
        //Act
        testMage.levelUp();
        int[] actual = new int[] {testMage.levelAttributes.strength,testMage.levelAttributes.dexterity,testMage.levelAttributes.intelligence};
        //Assert
        assertArrayEquals(expected,actual);
    }
    @Test
    public void check_if_level_works_with_level_up(){
        //Arrange
        Mage testMage = new Mage("testName");
        int[] expected = new int[]{1,2};
        //Act
        int[] actual = new int[2];
        actual[0] = testMage.level;
        testMage.levelUp();
        actual[1] = testMage.level;
        //Assert
        assertArrayEquals(expected,actual);
    }

    @Test
    public void check_if_mage_can_equip_weapon() throws InvalidWeaponException {
        //Arrange
        Mage testMage = new Mage("testName");
        Weapon testWeapon = new Weapon("testWeapon", 1, WeaponType.Wands, 50);
        String expected = "testWeapon";
        //Act
        testMage.equip(testWeapon);
        String actual = testMage.equipment.get(Slot.Weapon).name;
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void check_if_mage_equipped_weapon_shows_stats() throws InvalidWeaponException{
        //Arrange
        Mage testMage = new Mage("testName");
        Weapon testWeapon = new Weapon("testWeapon", 1, WeaponType.Wands, 50);
        int expected = 50;
        //Act
        testMage.equip(testWeapon);
        int actual = testMage.equipment.get(Slot.Weapon).weaponDamage;
        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void equip_wrong_weapon_shouldRaiseInvalidWeaponException(){
        //Arrange
        Mage testMage = new Mage("testName");
        Weapon testWeapon = new Weapon("testWeapon", 1, WeaponType.Swords, 50);
        String expected = "Your class cannot equip this item";
        //Act
        InvalidWeaponException exception =
                assertThrows(InvalidWeaponException.class,()->testMage.equip(testWeapon));

        //Assert
        assertEquals(exception.getMessage(),expected);
    }

    @Test
    public void equip_weapon_with_too_low_level_shouldRaiseInvalidWeaponException(){
        Mage testMage = new Mage("testName");
        Weapon testWeapon = new Weapon("testWeapon", 10, WeaponType.Swords, 50);
        String expected = "You are too low level to equip that";
        //Act
        InvalidWeaponException exception =
                assertThrows(InvalidWeaponException.class,()->testMage.equip(testWeapon));

        //Assert
        assertEquals(exception.getMessage(),expected);

    }
    @Test
    public void equip_armor_with_too_low_level_shouldRaiseInvalidWeaponException(){
        Mage testMage = new Mage("testName");
        Attributes stats = new Attributes(1,2,3);
        Armor testArmor = new Armor("testWeapon", 10, ArmorType.Cloth,Slot.Body,stats);
        String expected = "You are too low level to equip that";
        //Act
        InvalidWeaponException exception =
                assertThrows(InvalidWeaponException.class,()->testMage.equip(testArmor));

        //Assert
        assertEquals(exception.getMessage(),expected);

    }

    @Test
    public void equip_wrong_armor_shouldRaiseInvalidWeaponException(){
        Mage testMage = new Mage("testName");
        Attributes stats = new Attributes(1,2,3);
        Armor testArmor = new Armor("testWeapon", 1, ArmorType.Plate,Slot.Body,stats);
        String expected = "Your class cannot equip this item";
        //Act
        InvalidWeaponException exception =
                assertThrows(InvalidWeaponException.class,()->testMage.equip(testArmor));

        //Assert
        assertEquals(exception.getMessage(),expected);

    }
    @Test
    public void total_attributes_with_no_armor(){
        //Arrange
        Mage testMage = new Mage("testName");
        int expected = 8;

        //Act
        int actual = testMage.damagingArmorAttribute()+testMage.damagingLevelAttribute();
        //Assert
        assertEquals(expected,actual);
    }

    @Test
    public void total_attributes_with_one_armor() throws InvalidWeaponException{
        //Arrange
        Mage testMage = new Mage("testName");
        Attributes testArmor1Stats = new Attributes(1,2,3);
        Armor testArmor1 = new Armor("testArmor1",1,ArmorType.Cloth,Slot.Body,testArmor1Stats);
        testMage.equip(testArmor1);
        int expected = 8+3;

        //Act
        int actual = testMage.damagingArmorAttribute()+testMage.damagingLevelAttribute();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void total_attributes_with_two_armor() throws InvalidWeaponException{
        //Arrange
        Mage testMage = new Mage("testName");
        Attributes testArmor1Stats = new Attributes(1,2,3);
        Attributes testArmor2Stats = new Attributes(4,5,6);
        Armor testArmor1 = new Armor("testArmor1",1,ArmorType.Cloth,Slot.Body,testArmor1Stats);
        Armor testArmor2 = new Armor("testArmor2",1,ArmorType.Cloth,Slot.Legs,testArmor2Stats);
        testMage.equip(testArmor1);
        testMage.equip(testArmor2);
        int expected = 8+3+6;

        //Act
        int actual = testMage.damagingArmorAttribute()+testMage.damagingLevelAttribute();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void total_attributes_with_replaced_armor() throws InvalidWeaponException{
        //Arrange
        Mage testMage = new Mage("testName");
        Attributes testArmor1Stats = new Attributes(1,2,3);
        Attributes testArmor2Stats = new Attributes(4,5,6);
        Armor testArmor1 = new Armor("testArmor1",1,ArmorType.Cloth,Slot.Body,testArmor1Stats);
        Armor testArmor2 = new Armor("testArmor2",1,ArmorType.Cloth,Slot.Body,testArmor2Stats);
        testMage.equip(testArmor1);
        testMage.equip(testArmor2);
        int expected = 8+6;

        //Act
        int actual = testMage.damagingArmorAttribute()+testMage.damagingLevelAttribute();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void damage_done_with_no_weapon(){
        //Arrange
        Mage testMage = new Mage("testName");

        int expected = 1*(1+8/100);

        //Act
        int actual = testMage.damage();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void damage_done_with_weapon() throws InvalidWeaponException{
        //Arrange
        Mage testMage = new Mage("testName");
        Weapon testWeapon = new Weapon("testWeapon", 1, WeaponType.Wands, 50);
        testMage.equip(testWeapon);
        int expected = 50*(1+8/100);

        //Act
        int actual = testMage.damage();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void damage_done_with_replaced_weapon() throws InvalidWeaponException{
        //Arrange
        Mage testMage = new Mage("testName");
        Weapon testWeapon1 = new Weapon("testWeapon1", 1, WeaponType.Wands, 50);
        Weapon testWeapon2 = new Weapon("testWeapon2", 1, WeaponType.Wands, 70);
        testMage.equip(testWeapon1);
        testMage.equip(testWeapon2);
        int expected = 70*(1+8/100);

        //Act
        int actual = testMage.damage();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void damage_done_with_armor_weapon_and_3leveled() throws InvalidWeaponException{
        //Arrange
        Mage testMage = new Mage("testName");
        testMage.levelUp();
        testMage.levelUp();
        testMage.levelUp();
        Weapon testWeapon1 = new Weapon("testWeapon1", 1, WeaponType.Wands, 50);
        testMage.equip(testWeapon1);
        Attributes testArmor1Stats = new Attributes(1,2,3);
        Attributes testArmor2Stats = new Attributes(4,5,6);
        Armor testArmor1 = new Armor("testArmor1",1,ArmorType.Cloth,Slot.Body,testArmor1Stats);
        Armor testArmor2 = new Armor("testArmor2",1,ArmorType.Cloth,Slot.Head,testArmor2Stats);
        testMage.equip(testArmor1);
        testMage.equip(testArmor2);
        int expectedLevelAtt = 8+5+5+5;
        int expectedArmorAtt = 3+6;
        int expected = 50*(1+(expectedArmorAtt+expectedLevelAtt)/100);

        //Act
        int actual = testMage.damage();
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void check_if_stats_showed_correctly(){
        //Arrange
        Mage testMage = new Mage("testMage");
        String expected = """
                Name: testMage
                Hero Class: mage
                Level: 1
                Total strength: 1
                Total dexterity: 1
                Total intelligence: 8
                Damage: 1""";

        //Act
        String actual = testMage.display();
        //Assert
        assertEquals(expected,actual);

    }



}
