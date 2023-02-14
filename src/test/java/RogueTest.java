import heroes.Rogue;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RogueTest {

    @Test
    public void check_if_name_correct(){
        // Arrange
        Rogue testRogue = new Rogue("testName");
        String expected = "testName";
        //Act
        String actual = testRogue.name;
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void check_if_initial_level_attributes_correct(){
        //Arrange
        Rogue testRogue = new Rogue("testName");
        int[] expected = new int[]{2,6,1};
        //Act
        int[] actual = new int[] {testRogue.levelAttributes.strength,testRogue.levelAttributes.dexterity,testRogue.levelAttributes.intelligence};
        //Assert
        assertArrayEquals(expected,actual);
    }
    @Test
    public void check_if_level_attributes_correct_after_lvl_up(){
        //Arrange
        Rogue testRogue = new Rogue("testName");
        int[] expected = new int[]{3,10,2};
        //Act
        testRogue.levelUp();
        int[] actual = new int[] {testRogue.levelAttributes.strength,testRogue.levelAttributes.dexterity,testRogue.levelAttributes.intelligence};
        //Assert
        assertArrayEquals(expected,actual);
    }
    @Test
    public void check_if_level_works_with_level_up(){
        //Arrange
        Rogue testRogue = new Rogue("testName");
        int[] expected = new int[]{1,2};
        //Act
        int[] actual = new int[2];
        actual[0] = testRogue.level;
        testRogue.levelUp();
        actual[1] = testRogue.level;
        //Assert
        assertArrayEquals(expected,actual);
    }
}
