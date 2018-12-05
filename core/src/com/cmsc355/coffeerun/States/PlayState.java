package com.cmsc355.coffeerun.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.cmsc355.coffeerun.Sprites.Cups;
import com.cmsc355.coffeerun.Sprites.Obstacles;
import com.cmsc355.coffeerun.Sprites.Platforms;
import com.cmsc355.coffeerun.Sprites.Student;

import java.util.ArrayList;

import static com.badlogic.gdx.Gdx.graphics;

@SuppressWarnings("ConstantConditions")
public class PlayState extends State {

    //CoffeeRun game;
    private static int OBSTACLE_SPACE = 600;
    private static int OBSTACLE_COUNT = 4;
    private static final int OBSTACLE_LIMIT=6;
    private ArrayList<Obstacles> obstacles;

    public int getObstaclesSize() {
        return obstacles2.size();
    }

    ArrayList<Obstacles> obstacles2;

    public boolean isDifficulty() {
        return difficulty;
    }

    public boolean difficulty = false;
    private int score;
    private String yourScoreName;
    BitmapFont yourBitmapFontName;




    private ArrayList<Platforms> platforms;
    private static int platformsCount = 3;
    private static final int PLATFORM_SPACE = 700;

    public Student getStudent() {
        return student;
    }

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


    private Texture inGameBackground;  // our actual in-game background
    private Sprite backgroundSprite;   // we'll use sprite to wrap our background infinitely
    float scrollTime = 0;              // the rate in which the background moves


    protected PlayState(){
        student = new Student();
        platforms = new ArrayList<Platforms>();
        for (int i = 1; i < platformsCount; i++) {
            platforms.add(new Platforms());
        }
        score = 0;
        yourScoreName = "0";
        yourBitmapFontName = new BitmapFont();
    }

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        shapeRenderer = new ShapeRenderer();
        student = new Student((graphics.getWidth()/10)+100,(graphics.getWidth()/10)-50); //recongigure this for every screen (screemheight/8)
//        obstacle = new Obstacles(500);
        cam.setToOrtho(false, graphics.getWidth(), graphics.getHeight());
        obstacles = new ArrayList<Obstacles>();
        while(!obstacles.isEmpty()){
            for(int i = 0;i<obstacles.size();i++){
                obstacles.remove(i);
            }
        }
        OBSTACLE_COUNT = 4;
        cups = new ArrayList<Cups>();
        platforms = new ArrayList<Platforms>();

        for (int i = 1; i < OBSTACLE_COUNT; i++) {
            obstacles.add(new Obstacles(i * OBSTACLE_SPACE + Gdx.graphics.getWidth()));
        }
        for (int i = 1; i < platformsCount; i++) {
            platforms.add(new Platforms(i * PLATFORM_SPACE + Gdx.graphics.getWidth()));
        }
        for(int i = 1;i<COFFEE_COUNT;i++){
            cups.add(new Cups(i * COFFEE_SPACE + Gdx.graphics.getWidth()));
        }

        inGameBackground = new Texture("backgground.png");

        // this allows us to use an image to represent our health-bar
        healthBar = new Texture("plain-white-background.jpg");

        cam.setToOrtho(false, graphics.getWidth(),graphics.getHeight());

        // setWrap wraps our background and backgroundSprite actually sets it as our moving background
        inGameBackground.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.ClampToEdge);
        //why the is the image being weird
        backgroundSprite = new Sprite(inGameBackground, 0,900, Gdx.graphics.getWidth() , Gdx.graphics.getHeight());
        input = Gdx.input;
        score = 0;
        yourScoreName = "0";
        yourBitmapFontName = new BitmapFont();



    }
    protected PlayState(GameStateManager gsm, Texture selectedchar){
        super(gsm);
        shapeRenderer = new ShapeRenderer();
        student = new Student((graphics.getWidth()/10)+100,(graphics.getWidth()/10)-50, selectedchar); //recongigure this for every screen (screemheight/8)
//        obstacle = new Obstacles(500);
        cam.setToOrtho(false, graphics.getWidth()/5, graphics.getHeight());
        obstacles = new ArrayList<Obstacles>();
        cups = new ArrayList<Cups>();
        platforms = new ArrayList<Platforms>();

        for (int i = 1; i < OBSTACLE_COUNT; i++) {
            obstacles.add(new Obstacles(i * OBSTACLE_SPACE + Gdx.graphics.getWidth()));
        }
        for (int i = 1; i < platformsCount; i++) {
            platforms.add(new Platforms(i * PLATFORM_SPACE + Gdx.graphics.getWidth()));
        }
        for(int i = 1;i<COFFEE_COUNT;i++){
            cups.add(new Cups(i * COFFEE_SPACE + Gdx.graphics.getWidth()));
        }

        inGameBackground = new Texture("backgground.png");

        // this allows us to use an image to represent our health-bar
        healthBar = new Texture("plain-white-background.jpg");

        cam.setToOrtho(false, graphics.getWidth(),graphics.getHeight());

        // setWrap wraps our background and backgroundSprite actually sets it as our moving background
        inGameBackground.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.ClampToEdge);
        //why the is the image being weird
        backgroundSprite = new Sprite(inGameBackground, 0,900, Gdx.graphics.getWidth() , Gdx.graphics.getHeight());
        input = Gdx.input;
        score = 0;
        yourScoreName = "0";
        yourBitmapFontName = new BitmapFont();

    }

    //testing constructor
    public PlayState(GameStateManager gsm, Input input, Student student,BitmapFont bit){
        super(gsm);
        this.student = student;
        this.input = input;
        score = 0;
        yourScoreName = "0";
        yourBitmapFontName =  bit;

    }

    public PlayState(GameStateManager gsm, Input input, Student student){
        super(gsm);
        this.student = student;
        this.input = input;
         obstacles2 = new ArrayList<Obstacles>();
        for (int i = 1; i < OBSTACLE_COUNT; i++) {
            obstacles2.add(new Obstacles(i * OBSTACLE_SPACE,2));
        }


    }

    //testing constructor for scores
    public PlayState(GameStateManager gsm, BitmapFont bitmapFont){
        super(gsm);
        score = 0;
        yourScoreName = "score: 0";

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




    public void checkTime(float timeCount, float time){
        if(timeCount>time*300 && OBSTACLE_COUNT<OBSTACLE_LIMIT ){
            createObstacles();
            OBSTACLE_COUNT++;
            difficulty = true;
        }
    }
    public void updateTest(float dt) {
        handleInput();
        student.update(dt);



    }
    @Override
    public void update(float dt) {
        handleInput();
        student.update(dt);





        decrementHealth(Gdx.graphics);
        float time = 0.00001f;
        timeCount += time;
        checkTime(timeCount,time);



        int obstacleCount = 0;
        for(Obstacles obstacle : obstacles){

            if(cam.position.x - (cam.viewportWidth/2)> obstacle.getObstacleCollisionBounds().x + obstacle.getObstacleCollisionBounds().getWidth()){
                if(!cups.get(obstacleCount).collides(obstacle.getObstacleCollisionBounds())) {

                    obstacle.reposition(obstacle.getObstacleCollisionBounds().x + ((60+OBSTACLE_SPACE) * OBSTACLE_COUNT));
                }
            }
            obstacleCount++;
        }

        for(Cups cup : cups) {
            if (cam.position.x - (cam.viewportWidth / 2) > cup.getBounds().x + cup.getBounds().getWidth()) {
                cup.reposition(cup.getBounds().x + ((30 + COFFEE_SPACE) * COFFEE_COUNT));
            }


        }

        for(Platforms platform : platforms) {
            if (cam.position.x - (cam.viewportWidth / 2) > platform.getPlatformCollisionBounds().x + platform.getPlatformCollisionBounds().getWidth()) {
                platform.reposition(platform.getPlatformCollisionBounds().x + ((70+PLATFORM_SPACE) * platformsCount));
            }


        }
        cam.update();

    }

    public void createObstacles() {
        if(OBSTACLE_COUNT<=OBSTACLE_LIMIT) {
            obstacles.add(new Obstacles(OBSTACLE_SPACE+(Gdx.graphics.getWidth()+300)));
            cups.add(new Cups(COFFEE_SPACE*2 + Gdx.graphics.getWidth() + 100));
            OBSTACLE_SPACE = 400;
            OBSTACLE_COUNT++;
    }


    }
    public void createObstaclesAfterTimeTest() {
        boolean difficultyLevel = true;
        if(difficultyLevel) {
            if (OBSTACLE_COUNT <= OBSTACLE_LIMIT) {
                obstacles2.add(new Obstacles(OBSTACLE_SPACE + 300,2));
                OBSTACLE_SPACE = 400;
                OBSTACLE_COUNT++;
            }
        }
    }


    public void decrementHealthAfterDifficultyIsOn(Graphics graphics){
        boolean difficultyLevel = true;
        if(health*(graphics.getWidth() -100)<=0) {
            if(!difficultyLevel) {
                this.health -= .0004f;
            }
            else{
                this.health -= .004f;

            }
        }


    }

    public void decrementHealth(Graphics graphics){

        if(health*(graphics.getWidth() -100)>0) {
            if(!difficulty) {
               this.health -= .0004f;
            }
            else{
               this.health -= .004f;

            }
        }
        else{
            gsm.set(new MenuState(gsm));
        }

    }

    @Override
    public void render(SpriteBatch sb) {


        sb.setProjectionMatrix(cam.combined);
        /* the following 3 lines of code below controls the rate at which the background moves and if it reaches
            a certain threshold then it resets
        */
        scrollTime += 0.008f;
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
        int cupCount = 0;
        boolean collision =  false;

        while(!collision && cupCount<getObstacleCount()) {
            for(int i = 0;i<getObstacleCount();i++) {
                if (cups.get(cupCount).collides(obstacles.get(i).getObstacleCollisionBounds())) {
                    collision = true;
                }

            }
            cupCount++;
        }
        for(Obstacles obstacle : obstacles){
            if(!collision) {
                sb.draw(obstacle.getObstacleTexture(), obstacle.getObstacleCollisionBounds().x -= 20, obstacle.getObstacleCollisionBounds().y);
            }
            if(obstacle.collides(student.getPlayerBounds())){
                if(health>.1){
                    health-=.005f;
                }
                else{
                    gsm.set(new MenuState(gsm));

                }
            }
            collision = false;
            cam.update();


        }
        int counterCup = 0;


        for(Cups cup : cups) {
            if(!difficulty) {
                if (!obstacles.get(counterCup).collides(cup.getBounds()) && cup.getBtmPos().y > student.getPlayerBounds().getHeight()) {

                    sb.draw(cup.getCoffeeCup(), cup.getBounds().x -= 20, cup.getBounds().y, 75, 100);
                    if (cup.collides(student.getPlayerBounds())) {
                        score+=10;
                        yourScoreName = "" + score;
                        if (health < 1) {
                            health += .04f;
                        }
                        sb.draw(cup.getCoffeeCup(), cup.getBounds().x, cup.getBounds().y -= 1000);
                    }

                }
            }
            else{
                if (!obstacles.get(counterCup).collides(cup.getBounds()) && cup.getBtmPos().y > student.getPlayerBounds().getHeight()) {

                    sb.draw(cup.getCoffeeCup(), cup.getBounds().x -= 20, cup.getBounds().y, 75, 100);
                    if (cup.collides(student.getPlayerBounds())) {
                        score+=100;
                        yourScoreName = "" + score;
                        if (health < 1) {
                            health += .04f;
                        }
                        sb.draw(cup.getCoffeeCup(), cup.getBounds().x, cup.getBounds().y -= 1000);
                    }

                }

            }


            cam.update();
            counterCup++;
            if(difficulty && counterCup>0){
                break;
            }


        }

        for(Platforms platform : platforms) {
            if(platform.getPlatformCollisionBounds().y>student.getPlayerBounds().getHeight()) {
                sb.draw(platform.getPlatformTexture(), platform.getPlatformCollisionBounds().x -= 20, platform.getPlatformCollisionBounds().y, platform.getPlatformTexture().getWidth(), platform.getPlatformTexture().getHeight());
                if (platform.collides(student.getPlayerBounds())){
//                if(student.getPlayerBounds().getY()<platform.getPlatformCollisionBounds().getY()){
//                    student.getVelocity().y = 0;
//                    student.getPosition().y = platform.getPlatformCollisionBounds().getY()-100;
//                }
//                else {
                    student.platform_collision(platform.getPlatformTexturePosition().y + 30);
//                }
//                student.getPosition().y = platform.getPlatformTexture().getHeight() ;
                }

            }
            cam.update();



        }

        // previous x value was CoffeeRun.V_WIDTH-100 and y value was CoffeeRun.V_HEIGHT-1
        sb.draw(healthBar,graphics.getWidth()-(graphics.getWidth()/4),graphics.getHeight()-100,(graphics.getWidth()/3-(graphics.getWidth()/8))* health, 60);

        //Gdx.getGraphic. ->can get height and width of any emulator that we use
        sb.draw(student.getStudent(), student.getPlayerBounds().x, student.getPlayerBounds().y, (graphics.getWidth()/10),(graphics.getWidth()/10));

        yourBitmapFontName.getData().setScale(10f);
        yourBitmapFontName.setColor(255f, 255f, 1.0f, 1.0f);

        yourBitmapFontName.draw(sb, yourScoreName, 200, graphics.getHeight());

        sb.end();

        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(240 ,   0 , 0, 0.5f);
        shapeRenderer.rect(student.getPlayerBounds().x,student.getPlayerBounds().y,(graphics.getWidth()/10),(graphics.getWidth()/10));
        shapeRenderer.rect(0,0,300,120);

        shapeRenderer.end();
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
    public int getPlatformCount() { return platforms.size();}

    public int getCupsCount(){
        return cups.size();
    }
    public Cups getCup(){
        return new Cups(12);
    }

    public void platformCollisionAndDetection(SpriteBatch sb2){
        for(Platforms platform : platforms) {
            if(platform.getPlatformCollisionBounds().y>student.getPlayerBounds().getHeight()) {
                sb2.draw(platform.getPlatformTexture(), platform.getPlatformCollisionBounds().x -= 20, platform.getPlatformCollisionBounds().y, platform.getPlatformTexture().getWidth(), platform.getPlatformTexture().getHeight());
                if (platform.collides(student.getPlayerBounds())){
//                if(student.getPlayerBounds().getY()<platform.getPlatformCollisionBounds().getY()){
//                    student.getVelocity().y = 0;
//                    student.getPosition().y = platform.getPlatformCollisionBounds().getY()-100;
//                }
//                else {
                    student.platform_collision(platform.getPlatformTexturePosition().y + 30);
//                }
//                student.getPosition().y = platform.getPlatformTexture().getHeight() ;
                }

            }
            cam.update();



        }
    }

    public int getPlatforms() {
        return platforms.size();
    }
    public int getScore(){ return score; }


}
