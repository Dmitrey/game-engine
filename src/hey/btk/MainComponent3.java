package hey.btk;

public class MainComponent3 {

    public static String title = "game engine";
    public static int width = 800;
    public static int height = 600;
    public static final int frame_cap = 5000;

    public boolean isRunning;
    private Game game;

    public MainComponent3() {
        RenderUtil.initGraphics();
        isRunning = false;
        game = new Game();
    }

    public void render() {
        RenderUtil.clearScreen();
        game.render();
        Window.render();
    }

    public void run() {

        long startTime = Time.getTime();
        double frameTime = 1.0 / frame_cap;
        double unprocessedTime = 0;
//        System.out.println("frame_time: " + frame_time);
        int frames = 0;
        long framesTimer = 0;
        isRunning = true;
        while (isRunning) {
            boolean render = false;
            long newTime = Time.getTime();
            long passedTime = newTime - startTime;
//            System.out.println("passedTime: " + passedTime);
            unprocessedTime += (double) passedTime / Time.SECOND;
//            System.out.println("unprocessedTime: " + unprocessedTime);
            startTime = newTime;
            framesTimer+=passedTime;

            while (unprocessedTime > frameTime) {
                unprocessedTime -= frameTime;
                render = true;

                Time.setDelta(frameTime);
                Input.update();
                game.input();
                game.update();
            }
            if (framesTimer >= Time.SECOND){
                System.out.println(frames);
                frames = 0;
                framesTimer = 0;
            }

            if (Window.isCloseRequested()) {
                stop();
            }
            if (render) {
                render();
                frames++;
            }
        }
    }

    public void stop() {
        isRunning = false;
    }

    public static void main(String[] args) {
        Window.createWindow(width, height, title);
        new MainComponent3().run();

//        String s = new Vector3f(-2, 3, 0).cross(new Vector3f(-2, 0, 6)).toString();
//        System.out.println(s);
//
//        Matrix m1 = new Matrix(
//                3,5,4,6,
//                7,8,6,5,
//                4,3,4,5,
//                7,8,9,3);
//        Matrix m2 = new Matrix(
//                3,5,4,6,
//                7,8,6,5,
//                4,3,4,5,
//                7,8,9,3);
//        m1.mult(m2).print();

    }
}
