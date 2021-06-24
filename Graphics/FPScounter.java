public class FPScounter {
    private double start_time;
    private double end_time;
    private int fps;

    public void start() {
        start_time = System.currentTimeMillis();
    }

    public void end() {
        end_time = System.currentTimeMillis();

        fps = (int)(1000 / (end_time - start_time));

        showFPS();
    }

    private void showFPS() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch(Exception e) {
            System.out.println(e);
        }
        System.out.println("FPS: " + fps);
    }
}