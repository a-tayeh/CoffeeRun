package com.cmsc355.coffeerun.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;


import java.util.Random;

public class Cups extends Sprite {

    private Texture coffeeCup;
    private Vector2 btmPos;
    private Random rand;
    private Vector3 position;
    private Vector3 velocity;
    private static final int GRAVITY = -100;
    private static final int MOVEMENT = -100;
    private static final int FLUCTUATION = 1000;
    private Rectangle bounds;
    private boolean remove;


    public Cups(float x){
        coffeeCup = new Texture("coffee.png");
        rand = new Random();
        btmPos = new Vector2(x, 300*rand.nextInt(FLUCTUATION+1));
        bounds = new Rectangle(btmPos.x, btmPos.y, 75, 100);
        remove = false;
    }

    public Texture getCoffeeCup() {
        return coffeeCup;
    }

    public Vector2 getBtmPos() {
        return btmPos;
    }

    public void update(float dt)
    {
        velocity.scl(dt);

        position.add(velocity.x,0,0);
        velocity.scl(1/dt);
    }

    public void reposition(float x){
        btmPos.set(x, rand.nextInt(FLUCTUATION));
        bounds.setPosition(btmPos.x, btmPos.y);

    }

    public Rectangle getBounds(){
        return bounds;
    }

    public boolean collides(Rectangle student){
        return student.overlaps(bounds);
   }
    public Vector3 getPosition() { return position;}


  public void dispose(){
    //    coffeeCup.dispose();

    }



}
