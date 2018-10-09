//package com.cmsc355.coffeerun.Screens;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.utils.viewport.FitViewport;
//import com.badlogic.gdx.utils.viewport.ScreenViewport;
//import com.badlogic.gdx.utils.viewport.StretchViewport;
//import com.badlogic.gdx.utils.viewport.Viewport;
//import com.cmsc355.coffeerun.CoffeeRun;
//import com.cmsc355.coffeerun.Scenes.Hud;
//
//public class PlayScreen implements Screen {
//    private CoffeeRun game;
//    private OrthographicCamera gamecam;
//    private Viewport gamePort;
//    private Hud hud;
//    private float timeCount = 0;
//
//    //Health Bar
//    private float health = 1; //0 = dead, 1 = full health
//    private Texture blank;
//
//    public PlayScreen(CoffeeRun game){
//        this.game = game;
//        gamecam = new OrthographicCamera();
//        gamePort = new FitViewport(CoffeeRun.V_WIDTH,CoffeeRun.V_HEIGHT,gamecam);
//        blank = new Texture("plain-white-background.jpg");
//        hud = new Hud(game.batch);
//    }
//
//    @Override
//    public void show() {
//
//    }
//
//    @Override
//    public void render(float delta) {
//        Gdx.gl.glClearColor(0,0,0,1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        //what will be shown with our camera
//        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
//        hud.stage.draw();
//
//        game.batch.begin();
//        //game.batch.setColor(Color.RED);
//
//
//        //DECREMENT HEALTH BAR
//        if(health*(CoffeeRun.V_WIDTH -100)>0)
//            health-=.004;
////        if ((CoffeeRun.V_WIDTH-100)*health <=0)
////            System.out.println(CoffeeRun.V_WIDTH*health);
//        timeCount += delta;
//        if(timeCount<1){
//            game.batch.setColor(Color.GREEN);
//        }
//        else if(timeCount<3){
//            game.batch.setColor(Color.ORANGE);
//        }
//
//        else if(timeCount < 5)
//            game.batch.setColor(Color.RED);
//
//
//        if((CoffeeRun.V_WIDTH-100)*health >0)
//            game.batch.draw(blank,CoffeeRun.V_WIDTH-100,CoffeeRun.V_HEIGHT-1,(CoffeeRun.V_WIDTH -320)* health, 10);
//
//
//        game.batch.end();
//    }
//
//    @Override
//    public void resize(int width, int height) {
//        gamePort.update(width,height);
//
//    }
//
//    @Override
//    public void pause() {
//
//    }
//
//    @Override
//    public void resume() {
//
//    }
//
//    @Override
//    public void hide() {
//
//    }
//
//    @Override
//    public void dispose() {
//
//    }
//}
