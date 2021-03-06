package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.cmsc355.coffeerun.Sprites.Student;

import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class JumpTests{
    @Test
    public void initialVelocityIsZero(){
        Student student = new Student(5, 0, 0);
        GameStateManager gsm = Mockito.mock(GameStateManager.class);
        Input input = Mockito.mock(Input.class);
        PlayState playState = new PlayState(gsm, input,student);
        float initialVelocity = playState.getStudent().getVelocity().y;

        assertEquals(initialVelocity,0,2.5);

    }



    @Test
    public void jumpAndComeBackDown() {
//        Platforms platform = new Platforms();
        Student student = new Student(5, 100, 0);
        Gdx.graphics = Mockito.mock(Graphics.class);
        student.jumpTest(Gdx.graphics, student);
        float jumpInitiatedYValue = student.getVelocity().y;
        float afterV = 0;
        int counter = 0;
        while (counter < 3) {
            student.updateJump(.1f,-20);
            counter++;
            if(counter==3){
                afterV = student.getVelocity().y;
            }

        }
        System.out.println("Value of velocity.y after one jump is initiated: "+jumpInitiatedYValue);
        System.out.println("Value of velocity.y when falling starts: "+afterV);

        assertTrue(jumpInitiatedYValue>afterV);
    }

    @Test
    public void JumpMultipleTimes() {
        Student student = new Student(5, 100, 0);
        Gdx.graphics = Mockito.mock(Graphics.class);

        float initialV = student.getVelocity().y;
        float afterV = 0;
        int counter = 0;
        while (counter < 3) {
            student.jumpTest(Gdx.graphics,student);
            student.updateJump(.000000001f,-10);
            counter++;
            if(counter==3){
                afterV = student.getVelocity().y;
            }

        }
        System.out.println("Initial velocity of the Y position: "+initialV);
        System.out.println("Velocity after multiple jumps been invoked: "+afterV);

        assertTrue(initialV<afterV);
    }
}
