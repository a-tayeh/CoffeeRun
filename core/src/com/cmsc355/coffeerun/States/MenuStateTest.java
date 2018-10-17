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
    public void testGameStateStack_OnMenu(){
        MenuState menu = new MenuState(gsm,"","",""); //constructor with not texture instantiated
        menu.setCurrentState(menu);
        String gsmStateString = gsm.getCurrentState();
        gsmStateString = gsmStateString.substring(1, gsmStateString.length()-1);



        System.out.println(gsmStateString);
        System.out.println(menu);
        assertEquals(gsmStateString,menu.toString());
    }

    @Test
    public void testGameStateStack_OnMenu_Mockito(){
        MenuState menuState = Mockito.mock(MenuState.class);

        //Mockito.doCallRealMethod().when(menuState).setCurrentState(Mockito.any(MenuState.class));
        //menuState.setCurrentState(menuState);
        gsm.push(menuState);

        //(menuState).setCurrentState(menuState);
        String gsmStateString = gsm.getCurrentState();
        String menuStateString = menuState.toString();


        gsmStateString = gsmStateString.substring(1, gsmStateString.length()-1);
        when(menuState.getCurrentState()).thenReturn(menuStateString);
        assertEquals(gsmStateString, menuState.getCurrentState());
    }

    @Test
    public void testGameStateStack_ClickOnPlayState(){
       MenuState menuState = Mockito.mock(MenuState.class);

       //Texture texture = when(menuState.getPlayButton()).thenReturn();
        menuState.clickPlaybutton();

        //assertEquals(gsm.getCurrentState().toString());
       //Texture playButton = new Texture(Gdx.graphics.getWidth()/2 - (playButton.getWidth()/2), Gdx.graphics.getHeight()/2-(playButton.getHeight()/2), "playbuttonsmall.png");
      // menuState.setClickposition(Gdx.graphics.getWidth()/2 - (playButton.getWidth()/2),Gdx.graphics.getHeight()/2-(playButton.getHeight()/2),0);

       //when(menuState.getCurrentState()).thenReturn();
        String gsmStateString = gsm.getCurrentState();
        //gsm.push(Mockito.mock(PlayState.class));
        String gameStateString = gsm.getCurrentState();

        //TODO
        //have menu state create textures
        //access texture positions in order to simulate clicking it
        //check to make sure the the gsm has a PlayState in class
        //what kind of assertion do I make?
        //assertTrue(check to see if the reference contains the word PlayState)

    }

    @Test
    public void testGameStateStack_ClickOnCharacterState(){
        MenuState menuState = Mockito.mock(MenuState.class);



        //Texture playButton = new Texture(Gdx.graphics.getWidth()/2 - (playButton.getWidth()/2), Gdx.graphics.getHeight()/2-(playButton.getHeight()/2), "playbuttonsmall.png");
        // menuState.setClickposition(Gdx.graphics.getWidth()/2 - (playButton.getWidth()/2),Gdx.graphics.getHeight()/2-(playButton.getHeight()/2),0);
        menuState.clickCharacterbutton();
        //when(menuState.getCurrentState()).thenReturn();
        gsm.push(Mockito.mock(PlayState.class));
        String gameStateString = gsm.getCurrentState();


    }



    @Test
    public void testOne_ClickOnPlayState() {
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
        when(state.toString()).thenReturn("playState");
        assertEquals(gsm.getCurrentState(),menuState.getCurrentState());
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