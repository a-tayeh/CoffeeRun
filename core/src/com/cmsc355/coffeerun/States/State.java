package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
//import com.cmsc355.coffeerun.CoffeeRun;

public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager gsm;
    //private Viewport gamePort;
    protected State(){

    }
    protected State(GameStateManager gsm){
        this.gsm = gsm;

        cam = new OrthographicCamera();

        mouse = new Vector3();
    }

    protected abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb);
    public abstract void dispose();

}
