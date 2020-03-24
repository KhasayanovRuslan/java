package com.geekbrains.rpg.game.logic;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.geekbrains.rpg.game.logic.utils.MapElement;
import com.geekbrains.rpg.game.logic.utils.Poolable;

public class Message implements Poolable, MapElement {
    private Vector2 position;
    private Vector2 velocity;
    private boolean active;
    private float time;
    private GameController gc;
    //private float angle;
    private StringBuilder strBuilder;

    public Message(GameController gc) {
        this.position = new Vector2(0.0f, 0.0f);
        this.velocity = new Vector2(0.0f, 0.0f);
        this.gc = gc;
        this.active = false;
        this.strBuilder = new StringBuilder();
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setup(float x, float y) {
        position.set(x, y);
        velocity.set(MathUtils.random(-60.0f, 60.0f), MathUtils.random(-60.0f, 60.0f));
        //this.angle = angle;
        active = true;
        time = 0.0f;
    }

    public void deactivate() {
        active = false;
    }

    @Override
    public void render(SpriteBatch batch, BitmapFont font) {
        strBuilder.setLength(0);
        strBuilder.append(MathUtils.random(-10, -1)).append("\n");
        font.draw(batch, strBuilder, gc.getHero().getPosition().x, gc.getHero().getPosition().y);
        //font.draw(batch, strBuilder, gc.getMonster().getPosition().x, gc.getMonster().getPosition().y);
    }

    @Override
    public int getCellX() { return (int) position.x / Map.CELL_WIDTH; }

    @Override
    public int getCellY() { return (int) position.y / Map.CELL_HEIGHT; }

    @Override
    public float getY() {
        return position.y;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    public void update(float dt) {
        time += dt;
        position.mulAdd(velocity, dt);
        if (time > 4.0f) {
            active = false;
        }
    }
}
