import enums.Slot;
import enums.WeaponType;
import exceptions.InvalidWeaponException;
import heroes.Mage;
import items.Weapon;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

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


}
