package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;


public class CharacterState extends State {
    private Texture char1, char2; // the two character assets
    private Texture bg; // background of the character selector screen.
    private Vector3 clickposition;


    public CharacterState(GameStateManager gsm){
        super(gsm);
        char1 = new Texture("peach256.png");
        char2 = new Texture("orange.png");
        bg = new Texture("mario.jpeg");
        clickposition = new Vector3();
    }
    protected void handleInput() {
        if(Gdx.input.justTouched()) {
            // Gets clicked/ touched position
            clickposition.set(Gdx.input.getX(), Gdx.input.getY(), 0); // screen coordinates.
            if (clickposition.x < (Gdx.graphics.getWidth()/2)) {
                gsm.set(new PlayState(gsm, char1));
                dispose();
            }
            else{
                gsm.set(new PlayState(gsm, char2));
                dispose();
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(bg,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(char1,0,Gdx.graphics.getHeight()/2-char1.getHeight()/2);
        sb.draw(char2, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2-char2.getHeight()/2);
        sb.end();
    }

    @Override
    public void dispose() {
        bg.dispose();
        char1.dispose();
        char2.dispose();
    }
}
