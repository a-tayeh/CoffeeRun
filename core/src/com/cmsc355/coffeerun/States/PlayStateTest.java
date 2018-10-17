package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayStateTest{
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
    public void testGameStateStack_OnCharacterState(){

        MenuState menu = new MenuState(gsm, "mario.jpeg", "playbuttonsmall.png", "character.png");
        menu.getCurrentState();
        System.out.println(gsm.getCurrentState());
    }

    //Check to see if screen has been clicked then the main character that it's y coordinate increased
    //Check to see if character has hit a block and dies (maybe by checking a certain flag variable)
    //Check to make sure that if the game resets that the obstacles are assigned a random position
}