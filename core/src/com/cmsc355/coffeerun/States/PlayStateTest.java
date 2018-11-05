package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.cmsc355.coffeerun.Sprites.Student;
import com.badlogic.gdx.math.Rectangle;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class PlayStateTest{
    GameStateManager gsm = new GameStateManager();
    MenuState menu;



    @Test
    public void testOne_ClickOnPlayState_StudentJump() {
        Input mockInput = Mockito.mock(Input.class);
        when(mockInput.getX()).thenReturn(50);
        when(mockInput.getY()).thenReturn(50);
        //SpriteBatch sb = Mockito.mock(SpriteBatch.class);
        Texture texture = Mockito.mock(Texture.class);
        when(texture.getWidth()).thenReturn(300);
        when(texture.getHeight()).thenReturn(300);

        State state = Mockito.mock(PlayState.class);

        Student student = Mockito.mock(Student.class);

        when(student.getVelocity()).thenReturn(new Vector3(0,0,0));
        Student stud = new Student(0,0,0);


        when(mockInput.justTouched()).thenReturn(true);

        GameStateManager gsm = new GameStateManager();
        gsm.push(state);
        Student student5 = Mockito.mock(Student.class);
        PlayState playState = new PlayState(gsm, mockInput, student5);

        playState.doHandleInput(mockInput, stud);

        assertEquals(""+3000,"" + (int)stud.getVelocity().y);
    }
    @Test
    public void test3_GetHealthBar_Decrease(){
        GameStateManager gameStateManager = new GameStateManager();
        Input input = Mockito.mock(Input.class);
        when(input.justTouched()).thenReturn(true);
        Student student = Mockito.mock(Student.class);
        Gdx.graphics = Mockito.mock(Graphics.class);
        when(Gdx.graphics.getWidth()).thenReturn(200);
        PlayState playState = new PlayState(gsm,input,student);
        //when(playState.getHealth()).thenReturn(1f);
        playState.decrementHealth(Gdx.graphics);
//        System.out.println(playState.getHealth());
        assertTrue(playState.getHealth() < 1);


    }

    @Test
    public void onPlayStateTest(){

        State state = Mockito.mock(PlayState.class);
        GameStateManager gsm = new GameStateManager();
        gsm.push(state);
        assertEquals(gsm.getCurrentState(),"[" + state.toString() + "]");
    }


    //Check to see if screen has been clicked then the main character that it's y coordinate increased
    //Check to see if character has hit a block and dies (maybe by checking a certain flag variable)
    //Check to make sure that if the game resets that the obstacles are assigned a random position
}