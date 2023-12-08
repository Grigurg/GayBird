package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bird {
    Texture birdTexture;

    int x, y;
    int birdSpeedX, birdSpeedY;

    int birdSize = 100;
    int width, height;

    int r = 100;
    int jumpHeight = 100;
    boolean jumpUp = false, jumpDown = false;
    boolean jump = false;

    int jumpSpeed = 5;

    int startJumpY;

    Bird(int x, int y, int speed, int width, int height) {
        birdTexture = new Texture("toucan.png");
        this.width = width;
        this.height = height;
//        birdSpeedX = birdSpeedY = speed;
        birdSpeedX = birdSpeedY = 5;
        birdSpeedY = -birdSpeedY;
        this.x = x;
        this.y = y;
    }

    void fly() {
        if (x < 0 || x > width + height)
            birdSpeedX = -birdSpeedX;
//        if (y < initialY - r || y > initialY + r)
//            birdSpeedY = -birdSpeedY;
//        if (x < 0 || x >= width - birdSize)
//            birdSpeedX = -birdSpeedX;
//        if (y < 0 || y >= height - birdSize)
//            birdSpeedY = -birdSpeedY;
        x += birdSpeedX;
        y += birdSpeedY;
    }

    void draw(SpriteBatch batch) {
//        fly();
        action();
        batch.draw(birdTexture, x, y, birdSize, birdSize);
    }

    void action() {
        if (jump) jump();
    }
    void jump() {
        if (!jumpUp && !jumpDown) jumpUp = true;
        if (jumpUp) y += jumpSpeed;
        if (jumpDown) y -= jumpSpeed;
        if (y >= startJumpY + jumpHeight) {
            jumpUp = false;
            jumpDown = true;
        }
        if (y <= startJumpY) {
            jump = jumpDown = jumpUp = false;
        }
    }

    void onClick() {
        if (!jump) {
            jump = true;
            startJumpY = y;
        }
    }
    void dispose() {
        birdTexture.dispose();
    }
}
