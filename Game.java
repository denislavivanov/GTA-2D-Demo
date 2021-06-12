import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL33C.*;
import org.lwjgl.opengl.GL;
import org.joml.Vector2f;
import org.joml.Matrix4f;

public class Game {
    private Graphics renderer;
    private Player player;
    private Map map;
    private boolean gameover = false;
    private Matrix4f projection;
    private CollisionDetection collision_detector;

    private void init() {
        renderer = new Graphics(800, 600, "GTA II(kind of)", false);
        player = new Player(new Vector2f(1.0f, 1.0f), new Vector2f(32.0f, 32.0f), 3.0f);
        map = new Map(11, 11);
        collision_detector = new CollisionDetection();
        projection = new Matrix4f().ortho(0.0f, 11.0f, 11.0f, 0.0f, -1.0f, 1.0f, false);
    }

    public void run() {
        init();

        while(!gameover) {
            render();
            update();

            if(glfwWindowShouldClose(renderer.window))
                gameover = true;
        }
    }

    private void update() {
        glfwPollEvents();
        getInput();
    }

    private void render() {
        glClear(GL_COLOR_BUFFER_BIT);

        renderer.setMatrix4f("projection", projection);
        map.draw(player);
        player.draw(new Vector2f(5.0f, 5.0f));

        glfwSwapBuffers(renderer.window);
    }

    private void getInput() {
        if(glfwGetKey(renderer.window, GLFW_KEY_W) == GLFW_PRESS) {
            player.move(new Vector2f(0.0f, -player.getSpeed() * 0.1f));

            if(collision_detector.check_map(player)) {
                player.move(new Vector2f(0.0f, player.getSpeed() * 0.1f));
            }
        }
        if(glfwGetKey(renderer.window, GLFW_KEY_A) == GLFW_PRESS) {
            player.move(new Vector2f(-player.getSpeed() * 0.1f, 0.0f));

            if(collision_detector.check_map(player)) {
                player.move(new Vector2f(player.getSpeed() * 0.1f, 0.0f));
            }
        }
        if(glfwGetKey(renderer.window, GLFW_KEY_S) == GLFW_PRESS) {
            player.move(new Vector2f(0.0f, player.getSpeed() * 0.1f));

            if(collision_detector.check_map(player)) {
                player.move(new Vector2f(0.0f, -player.getSpeed() * 0.1f));
            }
        }
        if(glfwGetKey(renderer.window, GLFW_KEY_D) == GLFW_PRESS) {
            player.move(new Vector2f(player.getSpeed() * 0.1f, 0.0f));

            if(collision_detector.check_map(player)) {
                player.move(new Vector2f(-player.getSpeed() * 0.1f, 0.0f));
            }
        }
    }
}