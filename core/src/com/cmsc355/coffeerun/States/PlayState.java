package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
//import com.cmsc355.coffeerun.CoffeeRun;
import com.cmsc355.coffeerun.Sprites.Obstacles;
import com.cmsc355.coffeerun.Sprites.Student;

import static com.badlogic.gdx.Gdx.graphics;

public class PlayState extends State {

    //CoffeeRun game;
    private static final int OBSTACLE_SPACE = 700;
    private static final int OBSTACLE_COUNT = 4;
    private Array<Obstacles> obstacles;
    private Student student;
    private Obstacles obstacle;
    private float health = 1; //0 = dead, 1 = full health
    private int timeCount = 0;
    private Texture healthBar;
    private Input input;
    private ShapeRenderer shapeRenderer;
    private int count = 0;
    private boolean invisible = false;


    private Texture ingameBackground;  // our actual ingame background
    private Sprite backgroundSprite;   // we'll use sprite to wrap our background infinitely
    float scrollTime = 0;              // the rate in which the background moves



    protected PlayState(GameStateManager gsm) {
        super(gsm);
        shapeRenderer = new ShapeRenderer();
        student = new Student(graphics.getWidth()/10,graphics.getHeight()/10); //recongigure this for every screen (screemheight/8)
//        obstacle = new Obstacles(500);
        cam.setToOrtho(false, graphics.getWidth()/5, graphics.getHeight());
        obstacles = new Array<Obstacles>();

        for(int i = 1;i<OBSTACLE_COUNT;i++){
            obstacles.add(new Obstacles(i * OBSTACLE_SPACE + 52));
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
        obstacles = new Array<Obstacles>();
        for(int i = 1;i<OBSTACLE_COUNT;i++){
            obstacles.add(new Obstacles(i * OBSTACLE_SPACE + 52));
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


        decrementHealth(Gdx.graphics);

        timeCount += dt;

        for(Obstacles obstacle : obstacles){
            if(cam.position.x - (cam.viewportWidth/2)> obstacle.getBtmPos().x + obstacle.getBtmObstacle().getWidth()){
                obstacle.reposition(obstacle.getBtmPos().x +  ((52+OBSTACLE_SPACE) *  OBSTACLE_COUNT));
//
            }


        }
        cam.update();


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
        for(Obstacles obstacle : obstacles){

                sb.draw(obstacle.getBtmObstacle(), obstacle.getBtmPos().x -= 20, obstacle.getBtmPos().y);

            if(obstacle.collides(student.getPlayerBounds())){
                gsm.set(new MenuState(gsm));
//                sb.draw(obstacle.getBtmObstacle(), obstacle.getBtmPos().x, obstacle.getBtmPos().y-=1000);


            }
            cam.update();

        }



        // previous x value was CoffeeRun.V_WIDTH-100 and y value was CoffeeRun.V_HEIGHT-1
        sb.draw(healthBar,graphics.getWidth()-(graphics.getWidth()/4),graphics.getHeight()-100,(graphics.getWidth()/3-(graphics.getWidth()/8))* health, 60);

        //Gdx.getGraphic. ->can get height and width of any emulator that we use
        sb.draw(student.getStudent(), student.getPosition().x, student.getPosition().y, (graphics.getWidth()/10),(graphics.getWidth()/10));
        sb.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(67 ,   34 , 167, 0.5f);
        shapeRenderer.rect(student.getPlayerBounds().x,student.getPlayerBounds().y,200,200);
        for(Obstacles obstacles: obstacles){
            shapeRenderer.rect(obstacles.getBounds().x-=20,obstacles.getBounds().y,200,200);
        }
        shapeRenderer.end();


    }

    @Override
    public void dispose() {

    }


    public float getHealth(){
        return health;
    }


}
