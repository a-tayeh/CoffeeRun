package com.cmsc355.coffeerun.States;

<<<<<<< HEAD
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
=======
>>>>>>> c90a5309a455a2ce2a8a0055e4bf616fb1919d25
import com.cmsc355.coffeerun.Sprites.Obstacles;
import com.cmsc355.coffeerun.Sprites.Platforms;
import com.cmsc355.coffeerun.Sprites.Student;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.Platform;

<<<<<<< HEAD
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
=======
import static org.junit.Assert.assertEquals;
>>>>>>> c90a5309a455a2ce2a8a0055e4bf616fb1919d25
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class PlatformTest extends GameTest{

    @Test
    public void multiplePlatformOnScreen() {
<<<<<<< HEAD
        PlayState playState = new PlayState();
        assertNotNull(playState.getPlatforms());
=======
        PlayState playState = Mockito.mock(PlayState.class);
        when(playState.getPlatformCount()).thenReturn(3);
        assertTrue(playState.getObstacleCount() > 1);
>>>>>>> c90a5309a455a2ce2a8a0055e4bf616fb1919d25


    }

    @Test
    public void landOnPlatform() {
        Platforms platform = new Platforms();
        Student student = new Student(5, 100, 0);
        student.jump();
        boolean z=true;
        while (z) {
            student.update(.00000000001f);
            if (platform.collides(student.getPlayerBounds())) {
                student.platform_collision(platform.getPlatformCollisionBounds().y);
                z=false;
            }
<<<<<<< HEAD
        }
            assertEquals(platform.getPlatformCollisionBounds().y, student.getPosition().y, 2.5);
=======

//        State state = Mockito.mock(PlayState.class);
//        GameStateManager gsm = new GameStateManager();
//        gsm.push(state);
        }
            //when(platform.collides(student.getPlayerBounds())).thenReturn(true);
            //when(platform.getPlatformCollisionBounds().y).thenReturn(student.getPlayerBounds().y);
            System.out.println(platform.getPlatformCollisionBounds().y);
            assertEquals(platform.getPlatformCollisionBounds().y, student.getPosition().y, 2.5);

>>>>>>> c90a5309a455a2ce2a8a0055e4bf616fb1919d25
    }


    @Test
    public void stayOnPlatform(){
<<<<<<< HEAD
        Platforms platform = new Platforms();
        PlayState  playState = new PlayState();
        Student student = new Student(5, 100, 0);
        student.jump();
        boolean z=true;
        float landingXValue = 0;
        float afterLandingValue = 0;
        int counter = 0;
        while (z && counter < 2) {
            student.update(.00000000001f);
            if (platform.collides(student.getPlayerBounds())) {
                playState.platformCollisionAndDetection();
                if(counter == 0) {
                    landingXValue = platform.getPlatformCollisionBounds().x;
                    System.out.println(landingXValue);
                    counter++;
                }

                if(counter == 1){
                    afterLandingValue = platform.getPlatformCollisionBounds().x;
                    counter++;
                }
                student.platform_collision(platform.getPlatformCollisionBounds().y);

                z=false;
            }

        }

        playState.platformCollisionAndDetection();
        System.out.println(landingXValue);

        System.out.println(afterLandingValue);
        assertNotEquals(landingXValue,afterLandingValue);


=======

        Student student = Mockito.mock(Student.class);
        State state = Mockito.mock(PlayState.class);
        GameStateManager gsm = new GameStateManager();



        when(((PlayState) state).getHealth()).thenReturn(0.0f);
       // assertEquals(gsm.getCurrentState(),"[" + menuStateMock.toString() + "]");
>>>>>>> c90a5309a455a2ce2a8a0055e4bf616fb1919d25

    }

}
