package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
//import com.cmsc355.coffeerun.CoffeeRun;
import com.cmsc355.coffeerun.Sprites.Cups;
import com.cmsc355.coffeerun.Sprites.Obstacles;
import com.cmsc355.coffeerun.Sprites.Student;

import java.util.ArrayList;

import static com.badlogic.gdx.Gdx.graphics;

public class PlayState extends State {

    //CoffeeRun game;
    private static int OBSTACLE_SPACE = 700;
    private static int OBSTACLE_COUNT = 4;
    private ArrayList<Obstacles> obstacles;
    private Student student;
    private Obstacles obstacle;
    private float health = 1; //0 = dead, 1 = full health
    private float timeCount = 0;
    private Texture healthBar;
    private Input input;

    private static final int COFFEE_SPACE = 500;
    private static final int COFFEE_COUNT = 4;
    private ArrayList<Cups> cups;
    private Cups cup;
    private ShapeRenderer shapeRenderer;


    private Texture ingameBackground;  // our actual ingame background
    private Sprite backgroundSprite;   // we'll use sprite to wrap our background infinitely
    float scrollTime = 0;              // the rate in which the background moves



    protected PlayState(GameStateManager gsm) {
        super(gsm);
        shapeRenderer = new ShapeRenderer();
        student = new Student(graphics.getWidth()/10,graphics.getHeight()/10); //recongigure this for every screen (screemheight/8)
//        obstacle = new Obstacles(500);
        cam.setToOrtho(false, graphics.getWidth()/5, graphics.getHeight());
        obstacles = new ArrayList<Obstacles>();



            for (int i = 1; i < OBSTACLE_COUNT; i++) {
                obstacles.add(new Obstacles(i * OBSTACLE_SPACE + 52));
            }

        cups = new ArrayList<Cups>();
        for(int i = 1;i<COFFEE_COUNT;i++){
            cups.add(new Cups(i * COFFEE_SPACE + 30));
        }

        ingameBackground = new Texture("mario.jpeg");

        // this allows us to use an image to represent our healthbar
        healthBar = new Texture("plain-white-background.jpg");

        cam.setToOrtho(false, graphics.getWidth(),graphics.getHeight());

        // setWrap wraps our background and backgroundSprite actually sets it as our moving background
        ingameBackground.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.ClampToEdge);
        //why the is the image being weird
        backgroundSprite = new Sprite(ingameBackground, 0,-600, graphics.getWidth() , graphics.getHeight());
        input = Gdx.input;



    }
    protected PlayState(GameStateManager gsm, Texture selectedchar){
        super(gsm);
        student = new Student(200,0, selectedchar);
//        cam.setToOrtho(false, graphics.getWidth()/5, graphics.getHeight());
        obstacles = new ArrayList<Obstacles>();
        for(int i = 1;i<OBSTACLE_COUNT;i++){
            obstacles.add(new Obstacles(i * OBSTACLE_SPACE + 52));
        }
        cups = new ArrayList<Cups>();
        for(int i = 1;i<COFFEE_COUNT;i++){
            cups.add(new Cups(i * COFFEE_SPACE + 30));
        }

        ingameBackground = new Texture("mario.jpeg");

        // this allows us to use an image to represent our healthbar
        healthBar = new Texture("plain-white-background.jpg");

//        cam.setToOrtho(false, graphics.getWidth(),graphics.getHeight());

        // setWrap wraps our background and backgroundSprite actually sets it as our moving background
        ingameBackground.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.ClampToEdge);
        //why the fuck is the image being weird
        backgroundSprite = new Sprite(ingameBackground, 0,-600, graphics.getWidth() , graphics.getHeight());
        input = Gdx.input;
    }

    //testing constructor
    public PlayState(GameStateManager gsm, Input input, Student student){
        super(gsm);
        this.student = student;
        this.input = input;
    }
    @Override
    protected void handleInput() {


        doHandleInput(input, student);

    }

    public void doHandleInput(Input input, Student student){
        if(input.justTouched()){
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



        decrementHealth(Gdx.graphics);

        timeCount += dt;


        for(Obstacles obstacle : obstacles){
            if(cam.position.x - (cam.viewportWidth/2)> obstacle.getObstacleCollisionBounds().x + obstacle.getObstacleCollisionBounds().getWidth()){
                obstacle.reposition(obstacle.getObstacleCollisionBounds().x +  ((52+OBSTACLE_SPACE) *  OBSTACLE_COUNT));
            }
        }

        for(Cups cup : cups) {
                if (cam.position.x - (cam.viewportWidth / 2) > cup.getBounds().x + cup.getBounds().getWidth()) {
                    cup.reposition(cup.getBounds().x + ((30 + COFFEE_SPACE) * COFFEE_COUNT));
                }

    }
        cam.update();

        }

    public void createObstacles(){

        obstacles.add(new Obstacles(OBSTACLE_SPACE+52));

    }

    public void decrementHealth(Graphics graphics){
        if(health*(graphics.getWidth() -100)>0)
            this.health-=.0004f;
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
        ArrayList<Cups> cupsToRemove = new ArrayList<Cups>();

        for(Obstacles obstacle : obstacles){
            sb.draw(obstacle.getObstacleTexture(), obstacle.getObstacleCollisionBounds().x-=20, obstacle.getObstacleCollisionBounds().y);
            if(obstacle.collides(student.getPlayerBounds())){

                if(health>.1){
                    health-=.01f;
                }
                else{
                    gsm.set(new MenuState(gsm));

                }
            }
            cam.update();


        }
        //Array<Cups> cupsToRemove = new Array<Cups>();

        for(Cups cup : cups) {
            int counter = 0;

            if(!obstacles.get(counter).collides(cup.getBounds())) {
                sb.draw(cup.getCoffeeCup(), cup.getBounds().x -= 20, cup.getBounds().y, 75, 100);
            }
            if(cup.collides(student.getPlayerBounds())) {
                if(health<1) {
                    health += .01f;
                }
                sb.draw(cup.getCoffeeCup(), cup.getBounds().x, cup.getBounds().y-=1000);
            }

            counter++;
            cam.update();


        }

        // previous x value was CoffeeRun.V_WIDTH-100 and y value was CoffeeRun.V_HEIGHT-1
        sb.draw(healthBar,graphics.getWidth()-(graphics.getWidth()/4),graphics.getHeight()-100,(graphics.getWidth()/3-(graphics.getWidth()/8))* health, 60);

        //Gdx.getGraphic. ->can get height and width of any emulator that we use
        sb.draw(student.getStudent(), student.getPosition().x, student.getPosition().y, (graphics.getWidth()/10),(graphics.getWidth()/10));


        sb.end();


    }

    @Override
    public void dispose() {
        cup.dispose();
    }


    public float getHealth(){
        return health;
    }

    public int getObstacleCount(){
        return obstacles.size();
    }

    public int getCupsCount(){
        return 12;
    }
    public Cups getCup(){
        return new Cups(12);
    }


}
