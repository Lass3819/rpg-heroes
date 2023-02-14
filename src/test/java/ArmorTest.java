import enums.Slot;
import enums.ArmorType;
import heroes.Attributes;
import items.Armor;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArmorTest {
    @Test
    public void check_if_name_is_correct(){
        //Arrange
        Attributes armorStats = new Attributes(10,20,30);
        Armor testArmor = new Armor("testArmor", 5, ArmorType.Plate, Slot.Body,armorStats);
        String expected = "testArmor";
        //Act
        String actual = testArmor.name;
        //Assert
        assertEquals(expected, actual);
    }
    @Test
    public void check_if_req_level_is_correct(){
        //Arrange
        Attributes armorStats = new Attributes(10,20,30);
        Armor testArmor = new Armor("testArmor", 5, ArmorType.Plate, Slot.Body,armorStats);
        int expected = 5;
        //Act
        int actual = testArmor.requiredLevel;
        //Assert
        assertEquals(expected, actual);
    }
    @Test
    public void check_if_Armor_type_is_correct(){
        //Arrange
        Attributes armorStats = new Attributes(10,20,30);
        Armor testArmor = new Armor("testArmor", 5, ArmorType.Plate, Slot.Body,armorStats);
        ArmorType expected = ArmorType.Plate;
        //Act
        ArmorType actual = testArmor.armorType;
        //Assert
        assertEquals(expected, actual);
    }
    @Test public void check_if_Armor_slot_is_correct(){
        //Arrange
        Attributes armorStats = new Attributes(10,20,30);
        Armor testArmor = new Armor("testArmor", 5, ArmorType.Plate, Slot.Body,armorStats);
        Slot expected = Slot.Body;
        //Act
        Slot actual = testArmor.slot;
        //Assert
        assertEquals(expected, actual);

    }
    @Test public void check_if_Armor_stats_are_correct(){
        //Arrange
        Attributes armorStats = new Attributes(1,2,3);
        Armor testArmor = new Armor("testArmor", 1, ArmorType.Plate, Slot.Body,armorStats);
        int[] expected = new int[]{1,2,3};
        //Act
        int[] actual = new int[]{testArmor.stats.strength,testArmor.stats.dexterity,testArmor.stats.intelligence};
        //Assert
        assertArrayEquals(expected, actual);

    }
}
