package com.cmsc355.coffeerun.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

import static com.badlogic.gdx.Gdx.graphics;

public class Obstacles extends Sprite {
    private Texture btmObstacle;
    private Vector2 btmPos;
    //include something like a tube gap to prevent images touching each other
    private Random rand;
    private Vector3 position;
    private Vector3 velocity;

    public Rectangle getBounds() {
        return bounds;
    }

    private Rectangle bounds;
    private static final int GRAVITY = -100;
    private static final int MOVEMENT = -100;




    private static final int FLUCTUATION = 500;

    public Obstacles(float x){
        btmObstacle = new Texture("obstacle.jpg");
        rand = new Random();
        btmPos = new Vector2(x, rand.nextInt(FLUCTUATION));
        bounds = new Rectangle(btmPos.x,btmPos.y,200,200);

    }

    public Texture getBtmObstacle() {
        return btmObstacle;
    }

    public Vector2 getBtmPos() {
        return btmPos;
    }


    public void reposition(float x){
        btmPos.set(x, rand.nextInt(FLUCTUATION));
        bounds.setPosition(btmPos.x,btmPos.y);

    }

    public boolean collides(Rectangle player){
        Rectangle intersection = new Rectangle();
        Intersector.intersectRectangles(player, bounds, intersection);
        return player.overlaps(bounds);
    }



}
