# Rpg-Heroes
Exercise in object oriented programming by making the the stat system of a game consisting of 4 classes:
Mage, Ranger, Rogue and Warrior.

We make an abstract class hero where all the common functionality can be made and then make subclasses for each of the above heroes.
We also have a stat system based on strength, dexterity and intelligence.
And finally we have an item system with weapons and armor.

Based on stats, armor and weapons we then have a function damage(), which calculates the damage done based on a linear combination of
weapon damage, armor and stats.

The test report is done with Github Actions
To see the test report go to Actions -> Last unit test -> Build -> Test Report
All the tests run will be displayed here.

To see what each individual test does go to the source files -> src -> test -> java
and here we have test for each class. The tests where we use all the classes together is done in mage
and could have been done in the other classes as well, but the other classes are all using the abstract hero class for these calculations anyway.
As for coverage, Intellij says that the tests constructed have 92% class coverage and 93% line coverage, but this would be 100% for both if the tests in mage were copy pasted and name changed appropriately for all the other heroclasses.

