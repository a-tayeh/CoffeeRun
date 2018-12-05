package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.cmsc355.coffeerun.Sprites.Cups;
import com.cmsc355.coffeerun.Sprites.Obstacles;
import com.cmsc355.coffeerun.Sprites.Student;

import org.junit.Test;
import org.mockito.Mockito;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

public class ScoreTest {

    @Test
    public void initiallyStartAtZero(){
        Student student = Mockito.mock(Student.class);
        GameStateManager gsm = Mockito.mock(GameStateManager.class);
        Input input = Mockito.mock(Input.class);
        BitmapFont bit = Mockito.mock(BitmapFont.class);

        PlayState playState = new PlayState(gsm, input,student,bit);
        int initialScore = playState.getScore();
        assertEquals(0, initialScore);
    }

    @Test
    public void collideCoffeeCup_IncreaseScore(){


        PlayState playState = Mockito.mock(PlayState.class);
        Student student = Mockito.mock(Student.class);
        Cups cup = Mockito.mock(Cups.class);
        when(playState.getScore()).thenReturn(10);
        when(cup.collides(student.getPlayerBounds())).thenReturn(true);
        int initialScore = playState.getScore();
        assertEquals(10, initialScore);

    }

    @Test
    public void collideObstacle_DecreaseScore(){

        Student student = Mockito.mock(Student.class);
        Obstacles obstacle = Mockito.mock(Obstacles.class);
        PlayState playState = Mockito.mock(PlayState.class);

        when(playState.getScore()).thenReturn(-10);
        when(obstacle.collides(student.getPlayerBounds())).thenReturn(true);
        int initialScore = playState.getScore();
        assertEquals(-10, initialScore);

    }
}

