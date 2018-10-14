package com.cmsc355.coffeerun.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

import java.awt.TextArea;

public class Student extends Sprite {
    private static final int GRAVITY = -100;
    private static final int MOVEMENT = -100;


    private Vector3 position;
    private Vector3 velocity;

    private Texture student;
    public Student(int x, int y){
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        student = new Texture("peach.png");

    }
    public Student(int x, int y, Texture sp){
        position = new Vector3(x,y,0);
        velocity = new Vector3(0,0,0);
        student = sp;
    }
    public void update(float dt)
    {
        if(position.y>70) {
                velocity.add(0, GRAVITY, 0);
        }
        else if(position.y != 50) {
            velocity.y = 0;
            position.y =50;
        }

        velocity.scl(dt);

        position.add(0,velocity.y,0);
        velocity.scl(1/dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getStudent(){

        return student;
    }

    public void jump(){
        velocity.y = 3000;
    }


}
