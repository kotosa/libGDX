package jp.techacademy.kotoyu.sasayama.jumpactiongame;

import com.badlogic.gdx.ScreenAdapter;

/**
 * Created by KOTOYU on 2017/07/05.
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameScreen extends ScreenAdapter{
    private JumpActionGame mGame;

    Sprite mBg;

    public GameScreen(JumpActionGame game){
        mGame = game;
        Texture bgTexture = new Texture("backk.png");
        mBg = new Sprite(new TextureRegion(bgTexture, 0, 0, 540, 810));
        mBg.setPosition(0, 0);
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mGame.batch.begin();
        mBg.draw(mGame.batch);
        mGame.batch.end();
    }

}
