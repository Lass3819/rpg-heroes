import heroes.Warrior;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class WarriorTest {
    @Test
    public void check_if_name_correct(){
        // Arrange
        Warrior testWarrior = new Warrior("testName");
        String expected = "testName";
        //Act
        String actual = testWarrior.name;
        //Assert
        assertEquals(expected,actual);
    }
    @Test
    public void check_if_initial_level_attributes_correct(){
        //Arrange
        Warrior testWarrior = new Warrior("testName");
        int[] expected = new int[]{5,2,1};
        //Act
        int[] actual = new int[] {testWarrior.levelAttributes.strength,testWarrior.levelAttributes.dexterity,testWarrior.levelAttributes.intelligence};
        //Assert
        assertArrayEquals(expected,actual);
    }
    @Test
    public void check_if_level_attributes_correct_after_lvl_up(){
        //Arrange
        Warrior testWarrior = new Warrior("testName");
        int[] expected = new int[]{8,4,2};
        //Act
        testWarrior.levelUp();
        int[] actual = new int[] {testWarrior.levelAttributes.strength,testWarrior.levelAttributes.dexterity,testWarrior.levelAttributes.intelligence};
        //Assert
        assertArrayEquals(expected,actual);
    }
    @Test
    public void check_if_level_works_with_level_up(){
        //Arrange
        Warrior testWarrior = new Warrior("testName");
        int[] expected = new int[]{1,2};
        //Act
        int[] actual = new int[2];
        actual[0] = testWarrior.level;
        testWarrior.levelUp();
        actual[1] = testWarrior.level;
        //Assert
        assertArrayEquals(expected,actual);
    }
}
