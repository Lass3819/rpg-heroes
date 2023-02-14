import enums.Slot;
import enums.WeaponType;
import items.Weapon;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class WeaponTest {
    @Test
    public void check_if_name_is_correct(){
        //Arrange
        Weapon testWeapon = new Weapon("testWeapon", 1, WeaponType.Swords, 50);
        String expected = "testWeapon";
        //Act
        String actual = testWeapon.name;
        //Assert
        assertEquals(expected, actual);
    }
    @Test
    public void check_if_req_level_is_correct(){
        //Arrange
        Weapon testWeapon = new Weapon("testWeapon", 1, WeaponType.Swords, 50);
        int expected = 1;
        //Act
        int actual = testWeapon.requiredLevel;
        //Assert
        assertEquals(expected, actual);
    }
    @Test
    public void check_if_weapon_type_is_correct(){
        //Arrange
        Weapon testWeapon = new Weapon("testWeapon", 1, WeaponType.Swords, 50);
        WeaponType expected = WeaponType.Swords;
        //Act
        WeaponType actual = testWeapon.weaponType;
        //Assert
        assertEquals(expected, actual);
    }
    @Test public void check_if_weapon_damage_is_correct(){
        //Arrange
        Weapon testWeapon = new Weapon("testWeapon", 1, WeaponType.Swords, 50);
        int expected = 50;
        //Act
        int actual = testWeapon.weaponDamage;
        //Assert
        assertEquals(expected, actual);

    }
    @Test public void check_if_weapon_slot_is_correct(){
        //Arrange
        Weapon testWeapon = new Weapon("testWeapon", 1, WeaponType.Swords, 50);
        Slot expected = Slot.Weapon;
        //Act
        Slot actual = testWeapon.slot;
        //Assert
        assertEquals(expected, actual);

    }



}
