# project-ones-zeros
project-ones-zeros created by GitHub Classroom

# CoffeeRun
Game Team: Ali, Rasha, Collin and Amelia.

an infinite running game where there is a healthbar that's powered by collecting coffee cups, obstacles are generated along the way 
to decrease health upon impact till the healthbar is empty which will result in game ending.

# Iteration 1
Closed HealthBar, Character, and start menu issues.

# Iteration 2
Closed Coffee,Sound Options and Obstacles issues.

Tests for iteration 2 can be found under states package(MusicStateTest, CoffeeCupTest, ObstacleTest).

# Video Demo iteration 2
   https://youtu.be/A2pYbF6qma0
   
   

# Iteration 3
Closes jump, score ranking, platform and difficulty issues.

Tests for iteration 3 can be found under states package (jump tests, difficultyTest, platform test and scoreTest)

*Lint Tool Summary:
  - get rid of uncessary import statments.
  - privatize some variables and create getters for encapsulation purposes.
  - fix backward compatibility sdk path in gradle.build file
  - access static members via instance reference
  - delete unecessary methods
  
  <Ignored lint fixes>
    - empty methods that are inherited from sprite and only call its super class implementation are necessary for the game to work.
    - spelling in comments and assets png/jpg files
    - Unused Declaration 50 issues (fixing any of those would result in game crashing) some declaration may seem unused at first but
        they're used in other methods later on.
  

# Video Demo Iteration 3
   https://youtu.be/zcFKEc9RVmk
