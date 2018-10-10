package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.cmsc355.coffeerun.CoffeeRun;

import javax.xml.soap.Text;

public class MenuState extends State {
    private Texture background;
    private Texture playButton;
    private Texture character_selector;
    private Vector3 clickposition, worldposition;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("mario.jpeg");
        playButton = new Texture("playbuttonsmall.png");
        character_selector = new Texture("character.png");
        clickposition = new Vector3(); // stores screen coordinates
        worldposition = new Vector3(); // stores world coordinates
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            // Gets clicked/ touched position
            clickposition.set(Gdx.input.getX(), Gdx.input.getY(), 0); // screen coordinates.
            if (clickposition.x > (Gdx.graphics.getWidth()/2 - (playButton.getWidth()/2)) &&
                    (clickposition.x < (Gdx.graphics.getWidth()/2 + (playButton.getWidth())))){
                if (clickposition.y > (Gdx.graphics.getHeight()/2 - (playButton.getHeight()/2)) &&
                        (clickposition.y < (Gdx.graphics.getHeight()/2 + (playButton.getHeight()/2)))) {
                    gsm.set(new PlayState(gsm));
                    dispose();
                }
            }
            else if ((clickposition.x > (Gdx.graphics.getWidth() - (character_selector.getWidth()/2)) &&
                        (clickposition.x < (Gdx.graphics.getWidth() )))) {
                if (clickposition.y > 0 && clickposition.y < character_selector.getHeight()) {
                    gsm.set(new CharacterState(gsm));
                    dispose();
                }
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
        sb.draw(background,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(playButton,Gdx.graphics.getWidth()/2 - (playButton.getWidth()/2), Gdx.graphics.getHeight()/2-(playButton.getHeight()/2));
        sb.draw(character_selector,Gdx.graphics.getWidth() - (character_selector.getWidth()), Gdx.graphics.getHeight()- character_selector.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
        character_selector.dispose();
    }
}
