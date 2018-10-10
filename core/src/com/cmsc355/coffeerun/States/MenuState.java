package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cmsc355.coffeerun.CoffeeRun;

import javax.xml.soap.Text;

public class MenuState extends State {
    private Texture startBackground;
    private Texture playButton;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        startBackground = new Texture("mario.jpeg");
        playButton = new Texture("playbutton3.png");


    }


    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(startBackground,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(playButton,Gdx.graphics.getWidth()/2 - (playButton.getWidth()/2), Gdx.graphics.getHeight()/2);
        sb.end();
    }

    @Override
    public void dispose() {
        startBackground.dispose();
        playButton.dispose();
    }


}
