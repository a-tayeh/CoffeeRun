package com.cmsc355.coffeerun.Sprites;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Platforms extends Sprite {
    private Texture platformTexture;

    public Vector2 getPlatformTexturePosition() {
        return platformTexturePosition;
    }

    private Vector2 platformTexturePosition;
    private Random rand;
    private Rectangle platformCollisionBounds;




    private static final int FLUCTUATION = 700;

    public Platforms(float x){
        platformTexture = new Texture("platform.jpg");
        rand = new Random();
        int rand2 = rand.nextInt((FLUCTUATION));
        if(rand2< Gdx.graphics.getHeight()/4){
            platformTexturePosition = new Vector2(x, rand2+Gdx.graphics.getHeight()/5);
        }
        else{
            platformTexturePosition = new Vector2(x, rand2);

        }
        platformCollisionBounds = new Rectangle(platformTexturePosition.x-=5, platformTexturePosition.y,platformTexture.getWidth(),platformTexture.getHeight());



    }

    public Platforms(){
        platformCollisionBounds = new Rectangle(5, 50,50,50);
    }

    public Rectangle getPlatformCollisionBounds() {
        return platformCollisionBounds;
    }


    public boolean collides(Rectangle studentCollisionBounds){

        return studentCollisionBounds.overlaps(platformCollisionBounds);
    }
    public Texture getPlatformTexture() {
        return platformTexture;
    }



    public void reposition(float x){
        int rand2 = rand.nextInt((FLUCTUATION));
        if(rand2< Gdx.graphics.getHeight()/5){
            platformTexturePosition = new Vector2(x, rand2+Gdx.graphics.getHeight()/5);
        }
        else{
            platformTexturePosition = new Vector2(x, rand2);

        }
        platformCollisionBounds.setPosition(platformTexturePosition.x-=5, platformTexturePosition.y);

    }



}


