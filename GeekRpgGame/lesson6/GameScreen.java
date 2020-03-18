package com.geekbrains.rpg.game.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.geekbrains.rpg.game.logic.GameController;
import com.geekbrains.rpg.game.logic.WorldRenderer;
import com.geekbrains.rpg.game.screens.utils.Assets;

public class GameScreen extends AbstractScreen {
    private GameController gc;
    private WorldRenderer worldRenderer;
    private Stage stage;
    private State state = State.RUN;

    public enum State
    {
        PAUSE,
        RUN,
        RESUME
    }

    public void setGameState(State s){
        this.state = s;
    }

    @Override
    public void pause()
    {
        this.state = State.PAUSE;
    }

    @Override
    public void resume()
    {
        this.state = State.RESUME;
    }

    public GameScreen(SpriteBatch batch) {
        super(batch);
    }

    @Override
    public void show() {
        gc = new GameController();
        worldRenderer = new WorldRenderer(gc, batch);
        createGui();
    }

    @Override
    public void render(float delta) {
        switch (state)
        {
            case RUN:
                update(delta);
                gc.update(delta);
                worldRenderer.render();
                stage.draw();
                break;
            case PAUSE:
                break;
            case RESUME:
                state = State.RUN;
                break;
            default:
                break;
        }

    }

    public void createGui() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin();
        skin.addRegions(Assets.getInstance().getAtlas());

        BitmapFont font14 = Assets.getInstance().getAssetManager().get("fonts/font14.ttf");
        TextButton.TextButtonStyle gameBtnStyle = new TextButton.TextButtonStyle(
                skin.getDrawable("shortButton"), null, null, font14);

        TextButton btnPause = new TextButton("Pause", gameBtnStyle);
        btnPause.setPosition(1100, 580);
        TextButton btnExitMenu = new TextButton("Exit Menu", gameBtnStyle);
        btnExitMenu.setPosition(1190, 580);

        btnExitMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                ScreenManager.getInstance().changeScreen(ScreenManager.ScreenType.MENU);
            }
        });

        btnPause.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (state == State.RESUME || state == State.RUN ) pause();
                if (state == State.PAUSE) resume();
            }
        });

        stage.addActor(btnPause);
        stage.addActor(btnExitMenu);
        skin.dispose();
    }

    public void update(float dt) {
        stage.act(dt);
    }
}