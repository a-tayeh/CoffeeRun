package com.cmsc355.coffeerun.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

public class Obstacles extends Sprite {
    private Texture obstacleTexture;
    private Vector2 obstacleTexturePosition;
    private Random rand;
    private Rectangle obstacleCollisionBounds;




    private static final int FLUCTUATION = 500;

    public Obstacles(float x){
        obstacleTexture = new Texture("obstacle.jpg");
        rand = new Random();
        obstacleTexturePosition = new Vector2(x, rand.nextInt(FLUCTUATION));
        obstacleCollisionBounds = new Rectangle(obstacleTexturePosition.x-=20, obstacleTexturePosition.y,200,200);



    }

    public Rectangle getObstacleCollisionBounds() {
        return obstacleCollisionBounds;
    }


    public boolean collides(Rectangle studentCollisionBounds){

        return studentCollisionBounds.overlaps(obstacleCollisionBounds);
    }
    public Texture getObstacleTexture() {
        return obstacleTexture;
    }

    public Vector2 getObstacleTexturePosition() {
        return obstacleTexturePosition;
    }


    public void reposition(float x){
        obstacleTexturePosition.set(x, rand.nextInt(FLUCTUATION));
        obstacleCollisionBounds.setPosition(obstacleTexturePosition.x-=20, obstacleTexturePosition.y);
















    }



}

