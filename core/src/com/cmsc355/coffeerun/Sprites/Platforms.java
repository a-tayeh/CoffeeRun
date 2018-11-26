package com.cmsc355.coffeerun.Sprites;


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




    private static final int FLUCTUATION = 800;

    public Platforms(float x){
        platformTexture = new Texture("platform.jpg");
        rand = new Random();
        platformTexturePosition = new Vector2(x, rand.nextInt(300*(FLUCTUATION+1)));
        platformCollisionBounds = new Rectangle(platformTexturePosition.x-=20, platformTexturePosition.y,platformTexture.getWidth(),platformTexture.getHeight());



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
        platformTexturePosition.set(x, rand.nextInt(FLUCTUATION));
        platformCollisionBounds.setPosition(platformTexturePosition.x-=20, platformTexturePosition.y);
















    }



}


