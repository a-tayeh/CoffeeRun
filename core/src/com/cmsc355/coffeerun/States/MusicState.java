package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.cmsc355.coffeerun.CoffeeRun;
import com.cmsc355.coffeerun.Sprites.Student;

import javax.print.DocFlavor;

import sun.font.CCompositeFont;


public class MusicState extends State {
    private Texture ingameBackground;
    private Texture soundButton;
    private Texture musicButton;
    private Input input;
    private Vector3 clickposition;
    private CoffeeRun coffeeRun;
    private Student student;
    public boolean soundOff;
    public MusicState(GameStateManager gsm){
        super(gsm);
        ingameBackground = new Texture("mario.jpeg");
        soundButton = new Texture("sound.png");
        musicButton = new Texture("music.png");
        this.input = Gdx.input;
        clickposition = new Vector3();
        //coffeeRun = new CoffeeRun();
        student = new Student(0,0);
        soundOff = true;

    }

    public MusicState(GameStateManager gsm, Input input) {
        super(gsm);
        this.input = input;
        clickposition = new Vector3(); //talk about this
    }

    @Override
    protected void handleInput() {
        //CoffeeRun coffeeRun = new CoffeeRun();
        doHandleInput(musicButton,1, coffeeRun.music);
        doHandleInput(soundButton, 2, coffeeRun.music);

    }

    public void doHandleInput(Texture texture, int choice, Music music) {
        int heightOfGame = Gdx.graphics.getHeight()/2;
        int widthOfGame = Gdx.graphics.getWidth()/2;
        if (input.justTouched()) {
            clickposition.set(input.getX(), input.getY(), 0);
            if (choice == 1) {
                //this is for music button
                if (clickposition.x < Gdx.graphics.getWidth() / 2 && clickposition.x > Gdx.graphics.getWidth() / 2 - 2 * (texture.getWidth() / 10))
                    if (clickposition.y > Gdx.graphics.getHeight() / 2 && clickposition.y < Gdx.graphics.getHeight() / 2 + 2 * (texture.getWidth() / 10)) {
                        if (music.getVolume() != 0)
                            music.setVolume(0);
                        else
                            music.setVolume(.8f);
                    }
            }


            if (choice == 2) {
                //this is for sound button
                if (clickposition.x > Gdx.graphics.getWidth() / 2 && clickposition.x < Gdx.graphics.getWidth() / 2 + 2 * (musicButton.getWidth() / 10))
                    if (clickposition.y > Gdx.graphics.getHeight() / 2 && clickposition.y < Gdx.graphics.getHeight() / 2 + 2 * (musicButton.getWidth() / 10)) {
                        if (soundOff) {
                            student.flap.setVolume(0, 0.0f);
//                        student.flap.
//                        soundOff = false;
//                    }
//                    else
//                        student.flap.setVolume(1,1.0f);
                        }
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
        sb.draw(ingameBackground,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(musicButton,Gdx.graphics.getWidth()/2 - 2*(musicButton.getWidth()/10), Gdx.graphics.getHeight()/2- (musicButton.getHeight()/10), musicButton.getWidth()/10, musicButton.getHeight()/10);
        sb.draw(soundButton, Gdx.graphics.getWidth()/2 + (musicButton.getWidth()/10), Gdx.graphics.getHeight()/2 - musicButton.getHeight()/10,musicButton.getWidth()/10, musicButton.getHeight()/10);
        //sb.draw(musicButton,Gdx.graphics.getWidth()/2 - 2*musicButton.getWidth(), Gdx.graphics.getHeight()/2 - musicButton.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
