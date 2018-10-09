package com.cmsc355.coffeerun.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.cmsc355.coffeerun.CoffeeRun;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = CoffeeRun.V_WIDTH;
        config.height = CoffeeRun.V_HEIGHT;
        config.title = CoffeeRun.TITLE;
		new LwjglApplication(new CoffeeRun(), config);

	}
}
