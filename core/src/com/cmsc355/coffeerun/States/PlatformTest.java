package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cmsc355.coffeerun.Sprites.Obstacles;
import com.cmsc355.coffeerun.Sprites.Platforms;
import com.cmsc355.coffeerun.Sprites.Student;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.Platform;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

public class PlatformTest extends GameTest{

    @Test
    public void multiplePlatformOnScreen() {
        PlayState playState = new PlayState();
        assertNotNull(playState.getPlatforms());


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
        }
            assertEquals(platform.getPlatformCollisionBounds().y, student.getPosition().y, 2.5);
    }


    @Test
    public void stayOnPlatform(){
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



    }

}
