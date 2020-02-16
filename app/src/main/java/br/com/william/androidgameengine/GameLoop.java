package br.com.william.androidgameengine;

public class GameLoop {

    private static boolean running = false;

    private static int updates = 0;
    private static final int MAX_UPDATES = 5;

    private static long startTime = 0;

    private static int targetFPS = 60;
    private static int targetTime = 1000000000 / targetFPS;

    public static void start() {
        Thread thread = new Thread() {
            public void run() {

                running = true;

                startTime = System.nanoTime();

                while (running) {

                    long currentTime = System.nanoTime();

                    updates = 0;

                    while (currentTime - startTime >= targetTime) {
                        EngineWorld.update();
                        startTime += targetTime;
                        updates++;

                        if (updates > MAX_UPDATES) {
                            break;
                        }
                    }

                    Renderer.render();

                    long timeTaken = System.nanoTime() - currentTime;

                    if (timeTaken < targetTime) {
                        try {
                            Thread.sleep((targetTime - timeTaken) / 1000000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        thread.setName("GameLoop");
        thread.start();
    }

    public static float updateDelta() {
        return 1.0f / 1000000000 * targetTime;
    }
}

