package jp.techacademy.kotoyu.sasayama.jumpactiongame;

import com.badlogic.gdx.ScreenAdapter;

/**
 * Created by KOTOYU on 2017/07/05.
 */
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen extends ScreenAdapter{

    static final float CAMERA_WIDTH = 10;
    static final float CAMERA_HEIGHT = 15;

    private JumpActionGame mGame;

    Sprite mBg;
    OrthographicCamera mCamera;
    FitViewport mViewPort;

    public GameScreen(JumpActionGame game){
        mGame = game;
        Texture bgTexture = new Texture("back.png");
        mBg = new Sprite(new TextureRegion(bgTexture, 0, 0, 540, 810));
        mBg.setPosition(0, 0);

        mCamera = new OrthographicCamera();
        mCamera.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
        mViewPort = new FitViewport(CAMERA_WIDTH, CAMERA_HEIGHT, mCamera);

    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // カメラの座標をアップデートしてスプライトの表示に反映させる
        mCamera.update();
        mGame.batch.setProjectionMatrix(mCamera.combined);

        mGame.batch.begin();
        mBg.setPosition(mCamera.position.x - CAMERA_WIDTH/2, mCamera.position.y - CAMERA_HEIGHT/2);
        mBg.draw(mGame.batch);
        mGame.batch.end();
    }

    @Override
    public void resize(int width, int height){
        mViewPort.update(width, height);
    }


}
