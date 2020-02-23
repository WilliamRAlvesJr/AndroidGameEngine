package br.com.william.androidgameengine;

import java.util.concurrent.ConcurrentLinkedQueue;

import br.com.william.androidgameengine.objects.GameObject;

public class EngineWorld {

    private static ConcurrentLinkedQueue<GameObject> gameObjectList = new ConcurrentLinkedQueue<>();
    private static SceneBlueprint scene;

    public static void init() {
        scene.start();
    }

    public static void update() {
        for (GameObject gameObject : gameObjectList) {
            gameObject.update();
        }
    }

    public static void render() {
        for (GameObject gameObject : gameObjectList) {
            gameObject.render();
        }
    }

    public static void reset() {
        for (GameObject gameObject : gameObjectList) {
            gameObject.resetGameObject();
        }
    }

    public static void addGameObject(GameObject gameObject) {
        if ( !((Scene_TEST) scene).isRunning )
            gameObjectList.offer(gameObject);
    }

    public static void setScene(SceneBlueprint scene) {
        EngineWorld.scene = scene;
    }
}
