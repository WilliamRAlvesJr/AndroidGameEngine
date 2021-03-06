package br.com.william.androidgameengine;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Renderer.init(this);
        if(Renderer.getSurfaceView() == null) {
            return;
        }
        GameLoop.enableStart();

        super.setContentView(Renderer.getSurfaceView());
        addFlags();

        EngineWorld.setScene(new Scene_TEST());
    }

    @Override
    protected void onStart() {
        super.onStart();
        GameLoop.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        GameLoop.stop();
        if (Renderer.isRendererSet()) {
            Renderer.getSurfaceView().onPause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Renderer.isRendererSet()) {
            Renderer.getSurfaceView().onResume();
        }
        GameLoop.enableStart();
    }

    private void addFlags() {
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}
