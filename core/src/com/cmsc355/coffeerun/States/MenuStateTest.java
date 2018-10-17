package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mock.*;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


import java.awt.Menu;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class MenuStateTest{
    GameStateManager gsm = new GameStateManager();
    //MenuState menu;
    @Mock
    private MenuState menuState = Mockito.mock(MenuState.class);


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void handleInput() {
        //write a few lines of code, look at code/user story
        //study for it by going through all of the slides
        //metric meaning some value you can get at
        //first part of solid could be on exam
        //
    }

    @Test
    public void update() {
    }

    @Test
    public void render() {
    }

    @Test
    public void dispose() {
    }





    @Test
    public void testOne_ClickOnPlayState() {
        Input mockInput = Mockito.mock(Input.class);
        when(mockInput.getX()).thenReturn(50);
        when(mockInput.getY()).thenReturn(50);
        //SpriteBatch sb = Mockito.mock(SpriteBatch.class);
        Texture texture = Mockito.mock(Texture.class);
        when(texture.getWidth()).thenReturn(300);
        when(texture.getHeight()).thenReturn(300);

        //get rid of draw
        //sb.draw(texture,texture.getWidth() / 2 - (texture.getWidth() / 2), texture.getHeight() / 2 - (texture.getHeight() / 2));

        //Vector3 vector3 = Mockito.mock(Vector3.class);

        State state = Mockito.mock(PlayState.class);

        Gdx.graphics = Mockito.mock(Graphics.class);
        when(Gdx.graphics.getWidth()).thenReturn(50);
        when(Gdx.graphics.getWidth()).thenReturn(50);
        when(mockInput.justTouched()).thenReturn(true);
        //when(mockInput.getX()).thenReturn(300);
        GameStateManager gsm = new GameStateManager();
        gsm.push(state);
        MenuState menuState = new MenuState(gsm, mockInput);
        //menuState.setClickposition(50,50,0);
        menuState.doHandleInput(texture,1, state, false);
        //when(state.toString()).thenReturn("playState");


        assertEquals(gsm.getCurrentState(),"[" + state.toString() + "]");
    }

    @Test
    public void testOne_ClickOnCharacterState() {
        Input mockInput = Mockito.mock(Input.class);
        when(mockInput.getX()).thenReturn(50);
        when(mockInput.getY()).thenReturn(50);
        SpriteBatch sb = Mockito.mock(SpriteBatch.class);
        Texture texture = Mockito.mock(Texture.class);
        when(texture.getWidth()).thenReturn(300);
        when(texture.getHeight()).thenReturn(300);

        //get rid of draw
        sb.draw(texture,texture.getWidth() / 2 - (texture.getWidth() / 2), texture.getHeight() / 2 - (texture.getHeight() / 2));

        //Vector3 vector3 = Mockito.mock(Vector3.class);

        State state = Mockito.mock(CharacterState.class);
        Gdx.graphics = Mockito.mock(Graphics.class);
        when(Gdx.graphics.getWidth()).thenReturn(50);
        when(Gdx.graphics.getWidth()).thenReturn(50);
        when(mockInput.justTouched()).thenReturn(true);
        //when(mockInput.getX()).thenReturn(300);
        GameStateManager gsm = new GameStateManager();
        gsm.push(state);
        MenuState menuState = new MenuState(gsm, mockInput);
        //menuState.setClickposition(50,50,0);
        menuState.doHandleInput(texture,2, state, false);
        when(state.toString()).thenReturn("characterState");
        assertEquals(gsm.getCurrentState(),menuState.getCurrentState());
    }

    @Test
    public void testOne_OnMenuState() {
        Input mockInput = Mockito.mock(Input.class);

        State state = Mockito.mock(MenuState.class);

        GameStateManager gsm = new GameStateManager();
        gsm.push(state);
        MenuState menuState = new MenuState(gsm, mockInput);

        when(state.toString()).thenReturn("menuState");
        assertEquals(gsm.getCurrentState(),menuState.getCurrentState());
    }


    //Create a method in Menu State that simulates when an image is clicked on?
    //It could have a parameter for where it needs to be clicked
    //Create a method that pushes on game state
    //Create a test to make sure clicking on play button access PlayState
    //Create a test to make sure clicking on character button access CharacterState
    //              (create a method that clicks on the correct area of the button)
    //How to create a class that is not null (creates textures and everything)
}