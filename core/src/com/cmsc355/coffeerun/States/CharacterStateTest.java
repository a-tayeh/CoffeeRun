package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CharacterStateTest{
    GameStateManager gsm = new GameStateManager();
    MenuState menu;


    @Test
    public void chooseCharacter1Test(){
        Gdx.graphics = Mockito.mock(Graphics.class);

        when(Gdx.graphics.getWidth()).thenReturn(500);
        Input mockInput = Mockito.mock(Input.class);
        when(mockInput.getX()).thenReturn(50);
        when(mockInput.getY()).thenReturn(50);
        Texture texture = Mockito.mock(Texture.class);

        when(mockInput.justTouched()).thenReturn(true);
        State state = Mockito.mock(PlayState.class);

        gsm.push(state);
        CharacterState characterState = new CharacterState(gsm, mockInput,1);
        characterState.doHandleInput( state, 1,false);


        when(state.toString()).thenReturn("characterState");
        assertEquals(gsm.getCurrentState(),"[" + state.toString() + "]");





    }


    @Test
    public void chooseCharacter2Test(){
        Gdx.graphics = Mockito.mock(Graphics.class);

        when(Gdx.graphics.getWidth()).thenReturn(500);
        Input mockInput = Mockito.mock(Input.class);
        when(mockInput.getX()).thenReturn(400);
        when(mockInput.getY()).thenReturn(400);
        Texture texture = Mockito.mock(Texture.class);
//        when(texture.getWidth()).thenReturn(300);
//        when(texture.getHeight()).thenReturn(300);

        when(mockInput.justTouched()).thenReturn(true);
        State state = Mockito.mock(PlayState.class);

        gsm.push(state);
        CharacterState characterState = new CharacterState(gsm, mockInput,1);
        characterState.doHandleInput( state, 2,false);


        when(state.toString()).thenReturn("characterState");
        assertEquals(gsm.getCurrentState(),"[" + state.toString() + "]");
        

    }


    @Test
    public void testOne_OnMenuState() {
        State state = Mockito.mock(CharacterState.class);

        GameStateManager gsm = new GameStateManager();
        gsm.push(state);

        String stateString = "[" + state.toString() + "]";
        assertEquals(gsm.getCurrentState(),stateString);
    }

    //Do the same thing that it tests to see what current state is
    //Tests to make sure that correct character gets passed into the game screen
    //Test to make sure that the state of the game is changed
}