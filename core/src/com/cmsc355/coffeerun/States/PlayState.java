package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.cmsc355.coffeerun.CoffeeRun;
import com.cmsc355.coffeerun.Sprites.Student;

public class PlayState extends State {
    //CoffeeRun game;
    private Student student;
    private float health = 1; //0 = dead, 1 = full health
    private Texture blank;
    private int timeCount = 0;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        student = new Student(70,50);
        cam.setToOrtho(false, Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        blank = new Texture("plain-white-background.jpg");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            student.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        if(health*(CoffeeRun.V_WIDTH -100)>0)
            health-=.004;
//        if ((CoffeeRun.V_WIDTH-100)*health <=0)
//            System.out.println(CoffeeRun.V_WIDTH*health);
        timeCount += dt;

        student.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(cam.combined);
        sb.begin();
//        if(timeCount<1){
//            sb.setColor(Color.GREEN);
//        }
//        else if(timeCount<3){
//            sb.setColor(Color.ORANGE);
//        }
//
//        else if(timeCount < 5)
//            sb.setColor(Color.RED);
//
//
//        if((CoffeeRun.V_WIDTH-100)*health >0)
            sb.draw(blank,CoffeeRun.V_WIDTH-100,CoffeeRun.V_HEIGHT-1,(CoffeeRun.V_WIDTH -320)* health, 10);


        sb.draw(student.getStudent(), student.getPosition().x/5, student.getPosition().y/5, student.getStudent().getWidth()/5,student.getStudent().getHeight()/5);
        sb.end();
    }

    @Override
    public void dispose() {

    }


}
