package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.cmsc355.coffeerun.CoffeeRun;
import com.cmsc355.coffeerun.Sprites.Student;


public class MusicState extends State {
    private Texture inGameBackground;
    private Texture soundButton;
    private Texture musicButton;
    private Texture backBtn;
    private Input input;
    private Vector3 clickPosition;
    private CoffeeRun coffeeRun;
    private Student student;
    public boolean soundOff;
    public MusicState(GameStateManager gsm){
        super(gsm);
        inGameBackground = new Texture("mario.jpeg");
        soundButton = new Texture("sound.png");
        musicButton = new Texture("music.png");
        backBtn = new Texture("backbutton.png");
        this.input = Gdx.input;
        clickPosition = new Vector3();
        //coffeeRun = new CoffeeRun();
        student = new Student(0,0);
        soundOff = true;

    }

    public MusicState(GameStateManager gsm, Input input) {
        super(gsm);
        this.input = input;
        clickPosition = new Vector3(); //talk about this
    }

    @Override
    protected void handleInput() {
        doHandleInput(musicButton,1, CoffeeRun.music, new MusicState(gsm), false);
        doHandleInput(soundButton, 2, coffeeRun.music, new MusicState(gsm), false);
        doHandleInput(soundButton,3,coffeeRun.music, new MenuState(gsm), true);

    }

    public void doHandleInput(Texture texture, int choice, Music music, State state, boolean doDispose) {
        int heightOfGame = Gdx.graphics.getHeight()/2;
        int widthOfGame = Gdx.graphics.getWidth()/2;
        if (input.justTouched()) {
            clickPosition.set(input.getX(), input.getY(), 0);
            if (choice == 1) {
                //this is for music button
                if (clickPosition.x < Gdx.graphics.getWidth() / 2 && clickPosition.x > Gdx.graphics.getWidth() / 2 - 2 * (texture.getWidth() / 10))
                    if (clickPosition.y > Gdx.graphics.getHeight() / 2 && clickPosition.y < Gdx.graphics.getHeight() / 2 + 2 * (texture.getWidth() / 10)) {
                        if (music.getVolume() != 0)
                            music.setVolume(0);
                        else
                            music.setVolume(.8f);
                    }
            }


            if (choice == 2) {
                //this is for sound button
                if (clickPosition.x > Gdx.graphics.getWidth() / 2 && clickPosition.x < Gdx.graphics.getWidth() / 2 + 2 * (texture.getWidth() / 10))
                    if (clickPosition.y > Gdx.graphics.getHeight() / 2 && clickPosition.y < Gdx.graphics.getHeight() / 2 + 2 * (texture.getWidth() / 10)) {
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

            if(choice == 3){
                if(clickPosition.x > 0 && clickPosition.x < texture.getWidth()) {
                    System.out.println(input.getX());
                    System.out.println(input.getY());
                    if(clickPosition.y > 0 && clickPosition.y < texture.getHeight()/2)
                    gsm.set(state);
                    if (doDispose) {
                        dispose();
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
        sb.draw(inGameBackground,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        sb.draw(musicButton,Gdx.graphics.getWidth()/2 - 2*(musicButton.getWidth()/10), Gdx.graphics.getHeight()/2- (musicButton.getHeight()/10), musicButton.getWidth()/10, musicButton.getHeight()/10);
        sb.draw(soundButton, Gdx.graphics.getWidth()/2 + (musicButton.getWidth()/10), Gdx.graphics.getHeight()/2 - musicButton.getHeight()/10,musicButton.getWidth()/10, musicButton.getHeight()/10);
        sb.draw(backBtn, 0,Gdx.graphics.getHeight() - backBtn.getHeight()/2, backBtn.getWidth()/2, backBtn.getHeight()/2);
        //sb.draw(musicButton,Gdx.graphics.getWidth()/2 - 2*musicButton.getWidth(), Gdx.graphics.getHeight()/2 - musicButton.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
