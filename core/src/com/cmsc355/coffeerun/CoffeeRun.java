package com.cmsc355.coffeerun;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.cmsc355.coffeerun.Screens.PlayScreen;
import com.cmsc355.coffeerun.States.GameStateManager;
import com.cmsc355.coffeerun.States.MenuState;

public class CoffeeRun extends Game { //in flappy bird it extend ApplicationAdaptor
	public static int V_WIDTH =0;
	public static int V_HEIGHT = 0;

	//DisplayMetrics metrics = new DisplayMetrics();
	private GameStateManager gsm;
	public SpriteBatch batch;

	public static final String TITLE = "Coffee Run";



	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
        Gdx.gl.glClearColor(0,0,0,1);
		//setScreen(new PlayScreen(this));
        gsm.push(new MenuState(gsm));
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
		V_WIDTH = Gdx.graphics.getWidth();
		V_HEIGHT = Gdx.graphics.getHeight();

	}

	@Override
	public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
		super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();

	}
}
