package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.cmsc355.coffeerun.Sprites.Student;

import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

public class DifficultyTest {

    @Test
    public void increaseObstaclesAfterTime(){
        Student student = Mockito.mock(Student.class);
        GameStateManager gsm = Mockito.mock(GameStateManager.class);
        Input input = Mockito.mock(Input.class);
        PlayState playState = new PlayState(gsm,input,student);
        int initialObstacleCount = playState.getObstaclesSize();
        playState.createObstaclesAfterTimeTest();
        int afterCallingCreateObstacles = playState.getObstaclesSize();
        assertTrue(initialObstacleCount<afterCallingCreateObstacles);



    }


    @Test
    public void decreaseHealthAfterCertainTime(){
        Student student = Mockito.mock(Student.class);
        GameStateManager gsm = Mockito.mock(GameStateManager.class);
        Input input = Mockito.mock(Input.class);
        Gdx.graphics = Mockito.mock(Graphics.class);
        PlayState playState = new PlayState(gsm,input,student);
        float initialHealth = playState.getHealth();
        int counter = 0;
        while(counter<6) {
            playState.decrementHealthAfterDifficultyIsOn(Gdx.graphics);
            counter++;
        }
        float afterCallingDecrementHealth = playState.getHealth();
        assertTrue(initialHealth>afterCallingDecrementHealth);
    }


    @Test
    public void checkObstacleCountWhenNormalDifficultyIsOn(){
        Student student = Mockito.mock(Student.class);
        GameStateManager gsm = Mockito.mock(GameStateManager.class);
        Input input = Mockito.mock(Input.class);
        PlayState p = Mockito.mock(PlayState.class);
        PlayState playState = new PlayState(gsm,input,student);
        when(p.isDifficulty()).thenReturn(true);
        int expectedObstacleCount = 4;
        int actualObstacleCount = playState.getObstaclesSize();
        assertEquals(expectedObstacleCount,actualObstacleCount);


    }
}
