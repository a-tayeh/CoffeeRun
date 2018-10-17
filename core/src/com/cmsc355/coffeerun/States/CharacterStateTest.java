package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CharacterStateTest{
    GameStateManager gsm = new GameStateManager();
    MenuState menu;
//    public MenuStateTest(GameStateManager gsm) {
//        super(gsm);
//    }

    @Before
    public void setUp() throws Exception {
        //menu = new MenuState(gsm);
    }

    @Test
    public void handleInput() {
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
        //menu = new MenuState(gsm);

        System.out.println(gsm.getCurrentState());
    }

    @Test
    public void testGameStateStack_OnPlayState(){
        // menu = new MenuState(gsm);

        System.out.println(gsm.getCurrentState());
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