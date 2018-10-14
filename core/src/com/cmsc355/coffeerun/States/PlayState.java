package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
//import com.cmsc355.coffeerun.CoffeeRun;
import com.cmsc355.coffeerun.Sprites.Obstacles;
import com.cmsc355.coffeerun.Sprites.Student;

public class PlayState extends State {

    //CoffeeRun game;
    private static final int OBSTACLE_SPACE = 500;
    private static final int OBSTACLE_COUNT = 4;
    private Array<Obstacles> obstacles;
    private Student student;
    private Obstacles obstacle;
    private float health = 1; //0 = dead, 1 = full health
    private int timeCount = 0;
    private Texture healthBar;


    private Texture ingameBackground;  // our actual ingame background
    private Sprite backgroundSprite;   // we'll use sprite to wrap our background infinitely
    float scrollTime = 0;              // the rate in which the background moves



    protected PlayState(GameStateManager gsm) {
        super(gsm);
        student = new Student(Gdx.graphics.getWidth()/5,Gdx.graphics.getHeight()/5); //recongigure this for every screen (screemheight/8)
//        obstacle = new Obstacles(500);
        cam.setToOrtho(false, Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight());
        obstacles = new Array<Obstacles>();
        for(int i = 1;i<OBSTACLE_COUNT;i++){
            obstacles.add(new Obstacles(i * OBSTACLE_SPACE + 52));
        }

        ingameBackground = new Texture("mario.jpeg");

        // this allows us to use an image to represent our healthbar
        healthBar = new Texture("plain-white-background.jpg");

        cam.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        // setWrap wraps our background and backgroundSprite actually sets it as our moving background
        ingameBackground.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.ClampToEdge);
        //why the fuck is the image being weird
        backgroundSprite = new Sprite(ingameBackground, 0,-600, Gdx.graphics.getWidth() , Gdx.graphics.getHeight());




    }
    protected PlayState(GameStateManager gsm, Texture selectedchar){
        super(gsm);
        student = new Student(70,50, selectedchar);
        cam.setToOrtho(false, Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight());
        obstacles = new Array<Obstacles>();
        for(int i = 1;i<OBSTACLE_COUNT;i++){
            obstacles.add(new Obstacles(i * OBSTACLE_SPACE + 52));
        }

        ingameBackground = new Texture("mario.jpeg");

        // this allows us to use an image to represent our healthbar
        healthBar = new Texture("plain-white-background.jpg");

        cam.setToOrtho(false, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        // setWrap wraps our background and backgroundSprite actually sets it as our moving background
        ingameBackground.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.ClampToEdge);
        //why the fuck is the image being weird
        backgroundSprite = new Sprite(ingameBackground, 0,-600, Gdx.graphics.getWidth() , Gdx.graphics.getHeight());

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
        student.update(dt);
        //make sure this constanct doesnt mess with size
        //of different screents
       //make hump
        //cam.position.set(student.getX(), cam.viewportHeight / 2, 0);

        if(health*(Gdx.graphics.getWidth() -100)>0)
            health-=.004;
//        if ((CoffeeRun.V_WIDTH-100)*health <=0)
//            System.out.println(CoffeeRun.V_WIDTH*health);
        timeCount += dt;

        for(Obstacles obstacle : obstacles){
            if(cam.position.x - (cam.viewportWidth/2)> obstacle.getBtmPos().x + obstacle.getBtmObstacle().getWidth()){
                obstacle.reposition(obstacle.getBtmPos().x +  ((52+OBSTACLE_SPACE) *  OBSTACLE_COUNT));
            }
        }
        cam.update();

    }



    @Override
    public void render(SpriteBatch sb) {


        sb.setProjectionMatrix(cam.combined);
        /* the following 3 lines of code below controls the rate at which the background moves and if it reaches
            a certain threshold then it resets
        */
        scrollTime += 0.01f;
        if(scrollTime >=1.0f) {
            scrollTime = 0.0f;
        }

        sb.begin();
        /* setU determines the starting scroll time which is zero, and SetU2 keeps incrementing that by 10
            sb.draw finally draws the background
        */

        backgroundSprite.setU(scrollTime);
        backgroundSprite.setU2(scrollTime+10);
        sb.draw(backgroundSprite,0,0);
//        sb.draw(obstacle.getBtmObstacle(),obstacle.getBtmPos().x,obstacle.getBtmPos().y);
        for(Obstacles obstacle : obstacles){
            sb.draw(obstacle.getBtmObstacle(), obstacle.getBtmPos().x, obstacle.getBtmPos().y);
        }
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



        // previous x value was CoffeeRun.V_WIDTH-100 and y value was CoffeeRun.V_HEIGHT-1
        sb.draw(healthBar,Gdx.graphics.getWidth()-(Gdx.graphics.getWidth()/4),Gdx.graphics.getHeight()-100,(Gdx.graphics.getWidth()/3-(Gdx.graphics.getWidth()/8))* health, 60);

        //Gdx.getGraphic. ->can get height and width of any emulator that we use
        sb.draw(student.getStudent(), student.getPosition().x/5, student.getPosition().y/5, (Gdx.graphics.getWidth()/10),(Gdx.graphics.getWidth()/10));
        sb.end();

    }

    @Override
    public void dispose() {

    }


}
