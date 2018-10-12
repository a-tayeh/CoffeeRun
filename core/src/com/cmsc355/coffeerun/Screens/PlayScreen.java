//package com.cmsc355.coffeerun.Screens;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.Color;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.Texture;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.utils.viewport.FitViewport;
//import com.badlogic.gdx.utils.viewport.ScreenViewport;
//import com.badlogic.gdx.utils.viewport.StretchViewport;
//import com.badlogic.gdx.utils.viewport.Viewport;
//import com.cmsc355.coffeerun.CoffeeRun;
//import com.cmsc355.coffeerun.Scenes.Hud;
//
//public class PlayScreen implements Screen {
//   protected SpriteBatch spriteBatch;
//    protected Stage stage;
//    protected OrthographicCamera camera;
//
//    @Override
//    public void show() {
//        spriteBatch = new SpriteBatch();
//        stage = new Stage();
//        camera = (OrthographicCamera)stage.getCamera();
//        Gdx.input.setInputProcessor(stage);
//    }
//
//    @Override
//    public void render(float delta) {
//        camera.update();
//        //  spriteBatch.begin();
//        stage.draw();
//        stage.act(delta);
//    }
//
//    @Override
//    public void resize(int width, int height) {
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
