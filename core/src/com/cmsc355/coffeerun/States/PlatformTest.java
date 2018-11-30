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
        Student student = new Student(5, 100, 0);
        student.jump();
        boolean z=true;
        int counter = 0;
        float studentPosUponLanding = 0;
        float studentPosAfterFall = 0;
        while(z && counter<4) {
            student.update(.000001f);
            if(platform.collides(student.getPlayerBounds())){
                studentPosUponLanding = student.getPlayerBounds().y;

            }
            while (platform.collides(student.getPlayerBounds())&& counter<4) {
                student.update(.01f);


                counter++;
                if(counter==4){
                    studentPosAfterFall = student.getPlayerBounds().y;
                }

            }
        }
        System.out.println("Student's y Position upon landing on platform: "+ studentPosUponLanding);
        System.out.println("Student's y Position after falling off the platform: "+ studentPosAfterFall);


        assertNotEquals(studentPosUponLanding, studentPosAfterFall, 2.5);



    }

}
