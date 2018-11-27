package com.cmsc355.coffeerun.States;

import com.cmsc355.coffeerun.Sprites.Obstacles;
import com.cmsc355.coffeerun.Sprites.Platforms;
import com.cmsc355.coffeerun.Sprites.Student;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.Platform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class PlatformTest extends GameTest{

    @Test
    public void multiplePlatformOnScreen() {
        PlayState playState = Mockito.mock(PlayState.class);
        when(playState.getPlatformCount()).thenReturn(3);
        assertTrue(playState.getObstacleCount() > 1);


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

//        State state = Mockito.mock(PlayState.class);
//        GameStateManager gsm = new GameStateManager();
//        gsm.push(state);
        }
            //when(platform.collides(student.getPlayerBounds())).thenReturn(true);
            //when(platform.getPlatformCollisionBounds().y).thenReturn(student.getPlayerBounds().y);
            System.out.println(platform.getPlatformCollisionBounds().y);
            assertEquals(platform.getPlatformCollisionBounds().y, student.getPosition().y, 2.5);

    }


    @Test
    public void stayOnPlatform(){

        Student student = Mockito.mock(Student.class);
        State state = Mockito.mock(PlayState.class);
        GameStateManager gsm = new GameStateManager();



        when(((PlayState) state).getHealth()).thenReturn(0.0f);
       // assertEquals(gsm.getCurrentState(),"[" + menuStateMock.toString() + "]");

    }

}
