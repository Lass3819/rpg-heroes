import heroes.Ranger;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RangerTest {
    @Test
    public void check_if_name_correct(){
        // Arrange
        Ranger testRanger = new Ranger("testName");
        String expected = "testName";
        //Act
        String actual = testRanger.name;
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void check_if_initial_level_attributes_correct(){
        //Arrange
        Ranger testRanger = new Ranger("testName");
        int[] expected = new int[]{1,7,1};
        //Act
        int[] actual = new int[] {testRanger.levelAttributes.strength,testRanger.levelAttributes.dexterity,testRanger.levelAttributes.intelligence};
        //Assert
        assertArrayEquals(expected,actual);
    }
    @Test
    public void check_if_level_attributes_correct_after_lvl_up(){
        //Arrange
        Ranger testRanger = new Ranger("testName");
        int[] expected = new int[]{2,12,2};
        //Act
        testRanger.levelUp();
        int[] actual = new int[] {testRanger.levelAttributes.strength,testRanger.levelAttributes.dexterity,testRanger.levelAttributes.intelligence};
        //Assert
        assertArrayEquals(expected,actual);
    }
    @Test
    public void check_if_level_works_with_level_up(){
        //Arrange
        Ranger testRanger = new Ranger("testName");
        int[] expected = new int[]{1,2};
        //Act
        int[] actual = new int[2];
        actual[0] = testRanger.level;
        testRanger.levelUp();
        actual[1] = testRanger.level;
        //Assert
        assertArrayEquals(expected,actual);
    }
}
