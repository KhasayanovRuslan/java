package com.geekbrains.rpg.game.logic;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.geekbrains.rpg.game.logic.utils.ObjectPool;
import com.geekbrains.rpg.game.screens.utils.Assets;

public class MessageController extends ObjectPool<Message> {
    private GameController gc;

    @Override
    protected Message newObject() {
        return new Message(gc);
    }

    public MessageController(GameController gc) {
        this.gc = gc;
    }

    public void setup(float x, float y) {
        for (int i = 0; i < 5; i++) {
            if (MathUtils.random(100) < 25) {
                getActiveElement().setup(x, y);
            }
        }
    }

//    public void render(SpriteBatch batch, BitmapFont font) {
//        for (int i = 0; i < getActiveList().size(); i++) {
//            getActiveList().get(i).render(batch, font);
//        }
//    }

    public void update(float dt) {
        for (int i = 0; i < getActiveList().size(); i++) {
            getActiveList().get(i).update(dt);
        }
        checkPool();
    }
}
