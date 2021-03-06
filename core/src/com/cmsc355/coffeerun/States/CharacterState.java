package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;


public class CharacterState extends State {
    private Texture char1, char2; // the two character assets
    private Texture bg; // background of the character selector screen.
    private Vector3 clickPosition;
    private Input input;



    public CharacterState(GameStateManager gsm){
        super(gsm);
        this.input = Gdx.input;
        char1 = new Texture("peach256.png");
        char2 = new Texture("orange.png");
        bg = new Texture("backgground.png");
        clickPosition = new Vector3();
    }


    public CharacterState(GameStateManager gsm, Input input, int choice){
        super(gsm);
        this.input = input;
        clickPosition = new Vector3();

        //gsm.push(new CharacterState(gsm, input));
    }

    protected void handleInput() {

       doHandleInput(char1, 1, true);
       doHandleInput(char2, 2, true);
    }

    public void doHandleInput(Texture chart, int choice, boolean doDispose){

        if(input.justTouched()) {
            // Gets clicked/ touched position
            clickPosition.set(input.getX(), input.getY(), 0); // screen coordinates.
            if(choice == 1) {
                clickPosition.set(input.getX(), input.getY(), 0); // screen coordinates.
                if (clickPosition.x < (Gdx.graphics.getWidth() / 2)) {
                    gsm.set(new PlayState(gsm,chart));
                    dispose();

                }
            }
            if(choice == 2){
                   if (clickPosition.x > (Gdx.graphics.getWidth() / 2)) {
                    gsm.set(new PlayState(gsm,chart));
                        dispose();

                }
            }
        }
    }
    public void doHandleInput(State curState,int choice, boolean doDispose ){
        if (choice == 1)
            doHandleInput(char1, choice, doDispose);
        else
            doHandleInput(char2,choice, doDispose);
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

    public String getCurrentState() {
        return gsm.getCurrentState();
    }
}
